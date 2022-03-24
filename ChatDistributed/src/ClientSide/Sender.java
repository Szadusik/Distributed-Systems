package ClientSide;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.Scanner;

public class Sender implements Runnable{
    private final Socket socket;
    private final DataOutputStream outputStream;
    private final Scanner scanner;
    public DatagramSocket datagramSocket;

    public Sender(Socket socket, DatagramSocket datagramSocket,Scanner scanner) throws IOException {
        this.socket = socket;
        this.datagramSocket = datagramSocket;
        this.scanner = scanner;
        this.outputStream = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        while (true) {
            String msg = this.scanner.nextLine();
            if (msg.equals("U")){
                byte [] buf = msg.getBytes();
                try {
                    datagramSocket.send(new DatagramPacket(buf,buf.length,this.socket.getInetAddress(),this.socket.getPort()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    this.outputStream.writeUTF(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
