package ClientSide;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver implements Runnable{
    private final int datagramLength;
    public DatagramSocket datagramSocket;

    public UDPReceiver(int datagramLength, DatagramSocket datagramSocket){
        this.datagramLength = datagramLength;
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
        while(true){
            DatagramPacket packet = new DatagramPacket(new byte[this.datagramLength],datagramLength);
            try {
                this.datagramSocket.receive(packet);
                String data = new String(packet.getData());
                System.out.println("Got UDP Message:\n" + data);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
