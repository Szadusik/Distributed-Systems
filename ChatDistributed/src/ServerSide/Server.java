package ServerSide;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private final int userLimit;
    private final ServerSocket serverSocket;
    private final ClientList clientList;
    private final int port;

    public Server(int userLimit,int port) throws IOException {
        this.userLimit = userLimit;
        this.port = port;
        this.serverSocket = new ServerSocket(port);
        this.clientList = new ClientList();
    }

    public ClientList getClientList(){
        return this.clientList;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public String generateID(){
        return "user#"+ (int)(Math.random()*9000 + 1000);
    }

    public int getUserLimit() {
        return userLimit;
    }

    public int getPort() {
        return port;
    }
}
