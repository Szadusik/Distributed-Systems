package ClientSide;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final Scanner scanner;
    private final Socket socket;
    public DatagramSocket datagramSocket;

    public Client(int serverPort) throws IOException {
        InetAddress address = InetAddress.getByName("localhost");
        this.socket = new Socket(address, serverPort);
        this.scanner = new Scanner(System.in);
        this.datagramSocket = new DatagramSocket();
    }

    public Socket getSocket() {
        return this.socket;
    }

    public Scanner getScanner() {
        return this.scanner;
    }
}
