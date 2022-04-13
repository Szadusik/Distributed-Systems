package Utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionChannel {
    private final ConnectionFactory factory;
    private final Management management;
    private final Connection connection;
    private final Channel channel;

    public ConnectionChannel() throws IOException, TimeoutException {
        this.factory = new ConnectionFactory();
        this.factory.setHost("localhost");
        this.connection = this.factory.newConnection();
        this.channel = this.connection.createChannel();
        this.management = new Management(channel);
        this.management.initSystem();
    }

    public ConnectionFactory getFactory(){
        return this.factory;
    }

    public Management getSystemManager(){
        return this.management;
    }

    public Channel getChannel() {
        return channel;
    }

    public Connection getConnection() {
        return connection;
    }
}
