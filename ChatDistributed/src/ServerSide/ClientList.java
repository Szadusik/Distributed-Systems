package ServerSide;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ClientList {
    private final HashMap<String, ClientHandler> activeClients;
    private final ArrayList<Integer> udpClients;
    public ClientList(){
        this.activeClients = new HashMap<>();
        this.udpClients = new ArrayList<>();
    }

    public synchronized void add(ClientHandler client){
        this.activeClients.put(client.getName(),client);
    }

    public synchronized void addUDP(Integer port){
        this.udpClients.add(port);
    }

    public synchronized void remove(String ID){
        this.activeClients.remove(ID);
    }

    public synchronized void removeUDP(Integer port){
        this.udpClients.remove(port);
    }

    public synchronized ClientHandler getClientByID(String ID){
        return this.activeClients.get(ID);
    }

    public synchronized Set<String> getListOfClients(){
        return this.activeClients.keySet();
    }

    public synchronized ArrayList<Integer> getUdpClients(){
        return this.udpClients;
    }

    public synchronized void informClients(String message) throws IOException {
        for(ClientHandler client : this.activeClients.values()){
            client.getOutputStream().writeUTF(message);
        }
    }

    public synchronized void informClientsUDP(DatagramPacket packet, DatagramSocket datagramSocket, byte[] message,
                                              int messageLength) throws IOException {
        for(Integer ports : this.udpClients){
            InetAddress sender = InetAddress.getByName("localhost");
            if(packet.getPort() != ports)
                datagramSocket.send(new DatagramPacket(message, messageLength,sender,ports));
        }
    }
}
