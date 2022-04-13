package Utils;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Management {
/*
* Types of exchange for exchangeTypes:
* 0 - Exchange for orders
* 1 - Exchange for sending acknowledge
* 2 - Exchange for admin privileges
* */
    private static final String[] exchangeTypes = {
            "ORDERS_EXCHANGE",
            "ACKNOWLEDGEMENTS_EXCHANGE",
            "ADMIN_EXCHANGE"};

    private final Channel channel;

    public Management(Channel channel){
        this.channel = channel;
    }

    public void initSystem() throws IOException {
        this.channel.exchangeDeclare(Management.exchangeTypes[0], BuiltinExchangeType.TOPIC);
        this.channel.exchangeDeclare(Management.exchangeTypes[1], BuiltinExchangeType.TOPIC);
        this.channel.exchangeDeclare(Management.exchangeTypes[2], BuiltinExchangeType.TOPIC);
        this.channel.basicQos(1);
    }

    public void initQueue(String name,int mode) throws IOException {
        /*
            modes for initializing and activating queues for system
            0 - Normal system queue
            1 - Queue for orders
         */
        switch (mode) {
            case 0 -> {
                this.channel.queueDeclare(name, true, false, false, null);
                this.channel.queueBind(name, Management.exchangeTypes[1], "#");
                this.channel.queueBind(name, Management.exchangeTypes[0], "#");
            }
            case 1 -> {
                this.channel.queueDeclare(name, true, false, false, null);
                this.channel.queueBind(name, Management.exchangeTypes[0], name);
            }
            default -> {
            }
        }
    }

    public String initAcknowledgementsQueue(String crewName) throws IOException {
        String ackQueueName = this.channel.queueDeclare().getQueue();
        this.channel.queueBind(ackQueueName, Management.exchangeTypes[1], crewName + ".*");
        return ackQueueName;
    }

    public String initRoleQueue(int mode) throws IOException {
        /*
            Modes for admin queue:
            0 -> Sending/Receiving messages as suppliers
            1 -> Sending/Receiving messages as crew
         */
        String adminQueueTag = this.channel.queueDeclare().getQueue();
        switch (mode) {
            case 0 -> this.channel.queueBind(adminQueueTag, Management.exchangeTypes[2], "*.supplier");
            case 1 -> this.channel.queueBind(adminQueueTag, Management.exchangeTypes[2], "crew.*");
        }
        return adminQueueTag;
    }

    public void publishOrder(String order, String crew) throws IOException {
        this.channel.basicPublish(Management.exchangeTypes[0], order, null, crew.getBytes());
    }

    public void publishAck(int ackID, String crew, String order, String supplier) throws IOException {
        this.channel.basicPublish(Management.exchangeTypes[1], crew + "." + ackID, null, (supplier + "." + order).getBytes());
    }

    public void sendAdminMsg(String msg, boolean includeSuppliers, boolean includeCrews) throws IOException {
        String routingKey = includeCrews ? (includeSuppliers ? "crew.supplier" : "crew.none") : "none.supplier";
        this.channel.basicPublish(Management.exchangeTypes[2], routingKey, null, msg.getBytes());
    }

    public void ackOrders(String order, String supplier, Random random) throws IOException{
        this.channel.basicConsume(order, false, "", new DefaultConsumer(this.channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String crew = new String(body, StandardCharsets.UTF_8);
                System.out.println(
                        "----------------------\n" +
                        "Supplier: "+ supplier +
                        "\nReceived order for a product: " + order +
                        "\nSend by crew: " + crew +
                        "\n---------------------"
                );
                publishAck(Math.abs(random.nextInt()), crew, order, supplier);
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }

    public void ackAcknowledgment(String ackTag, String crew) throws IOException {
        this.channel.basicConsume(ackTag, false, "", new DefaultConsumer(this.channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                int acknowledgementID = Integer.parseInt(envelope.getRoutingKey().split("\\.")[1]);
                String[] msg = new String(body, StandardCharsets.UTF_8).split("\\.");
                System.out.println(
                        "----------------\n" +
                        "Crew: " + crew + "\n" +
                        "ID of received acknowledge: " + acknowledgementID +
                        "\nReceived from supplier: " + msg[0] +
                        "\nOrdered product: " + msg[1] +
                        "\n----------------"
                );
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }

    public void ackSysMessages(String system) throws IOException {
        this.channel.basicConsume(system, false, "", new DefaultConsumer(this.channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(
                        "----------------\n" +
                        "Admin: " + system + "\n" +
                        "\nMessage logged: " + new String(body, StandardCharsets.UTF_8) +
                        "\nRouting key used: " + envelope.getRoutingKey() +
                        "\n----------------"
                );
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }

    public void ackAdminMsg(String adminCommunicationTag, String name) throws IOException {
        this.channel.basicConsume(adminCommunicationTag, false, "", new DefaultConsumer(this.channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(
                        "----------------\n" +
                        "Your name: " + name + "\n" +
                        "You have received a message from admin: " + new String(body, StandardCharsets.UTF_8)
                        + "\n----------------"
                );
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}
