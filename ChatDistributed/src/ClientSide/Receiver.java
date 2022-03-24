package ClientSide;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Socket;

public class Receiver implements Runnable{
    private final DataInputStream inputStream;
    private final Socket socket;
    public DatagramSocket datagramSocket;
    public Receiver(Socket socket, DatagramSocket datagramSocket) throws IOException {
        this.socket = socket;
        this.datagramSocket = datagramSocket;
        this.inputStream = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run(){
        while (true) {
            try {
                String msg = this.inputStream.readUTF();
                if(msg.equals("disconnect") || msg.equals("limitExceeded"))
                    break;
                else
                    System.out.println(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Disconnecting... Closing socket");
        try{
            this.inputStream.close();
            if(!this.socket.isClosed())
                this.socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Socket closed. Disconnected correctly");
        System.exit(0);
    }
}
