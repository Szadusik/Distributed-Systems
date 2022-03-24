package Lauchers;

import ClientSide.Client;
import ClientSide.Receiver;
import ClientSide.Sender;
import ClientSide.UDPReceiver;

import java.io.IOException;

public class ClientLauncher {
    public static void main(String[] args) throws IOException, InterruptedException {
        Client client = new Client(1234);
        Thread sendMessage = new Thread(new Sender(client.getSocket(), client.datagramSocket,client.getScanner()));
        Thread readMessage = new Thread(new Receiver(client.getSocket(),client.datagramSocket));
        Thread UDPMessage = new Thread(new UDPReceiver(1024,client.datagramSocket));

        sendMessage.start();
        readMessage.start();
        UDPMessage.start();

        sendMessage.join();
        readMessage.join();
        UDPMessage.join();
    }
}
