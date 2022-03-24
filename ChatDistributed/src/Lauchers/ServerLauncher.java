package Lauchers;

import ServerSide.ClientHandler;
import ServerSide.Server;
import ServerSide.UDPServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerLauncher {
    public static void main(String[] args) throws IOException {
        Server server = new Server(2,1234); //User limit + 1 - Total user limit
        System.out.println("----------Java TCP Server running on port " + server.getServerSocket().getLocalPort() + "------------");
        Thread udp = new Thread(new UDPServer(server.getPort(),server.getClientList(),1024));
        udp.start();
        while (true)
        {
            Socket s = server.getServerSocket().accept();
            System.out.println("New client request received : " + s);

            // obtain input and output streams
            DataInputStream inputStream = new DataInputStream(s.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());

            if(server.getClientList().getListOfClients().size() > server.getUserLimit()){
                System.out.println("Active users limit exceeded! Request denied");
                outputStream.writeUTF("limitExceeded");
                inputStream.close();
                outputStream.close();
                s.close();
            }
            else{
                String ID = server.generateID();
                while(server.getClientList().getClientByID(ID) != null){
                    ID = server.generateID();
                }
                ClientHandler client = new ClientHandler(s,ID, inputStream, outputStream, server.getClientList());
                Thread t = new Thread(client);
                server.getClientList().add(client);

                System.out.println("Client added successfully! " + "Active clients : " + server.getClientList().getListOfClients());
                outputStream.writeUTF("Your ID is : " + ID);
                server.getClientList().informClients("Active clients : " + server.getClientList().getListOfClients());

                t.start();
            }
        }
    }

}
