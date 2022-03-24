package ServerSide;

import MessageManager.Message;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer implements Runnable{
    private final DatagramSocket datagramSocket;
    private final ClientList clientList;
    private final int datagramLength;

    public UDPServer(int port, ClientList clientList, int datagramLength) throws SocketException {
        this.datagramSocket = new DatagramSocket(port);
        this.clientList = clientList;
        this.datagramLength = datagramLength;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message manager = new Message();
                DatagramPacket packet = new DatagramPacket(new byte[this.datagramLength], this.datagramLength);
                this.datagramSocket.receive(packet);
                this.clientList.addUDP(packet.getPort());
                this.clientList.informClientsUDP(packet,this.datagramSocket,
                        manager.generateUDPMessage(this.datagramLength),this.datagramLength);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
