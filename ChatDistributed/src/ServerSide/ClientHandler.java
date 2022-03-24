package ServerSide;

import MessageManager.Message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private final String name;
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;
    private final ClientList clients;
    private final Socket socket;

    public ClientHandler(Socket socket, String name,
                         DataInputStream inputStream, DataOutputStream outputStream, ClientList clients) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.name = name;
        this.socket = socket;
        this.clients = clients;
    }

    @Override
    public void run() {
        while (true)
        {
            try
            {
                Message msg = new Message(this.name);
                String received = inputStream.readUTF();

                System.out.println(received);

                if(msg.isMessageCorrect(received)){
                    msg.proceedMessage(received);
                    if(msg.getReceiver().equals(""))
                        break;
                    else{
                        ClientHandler receiver = this.clients.getClientByID(msg.getReceiver());
                        if(receiver != null) {
                            if(receiver.getName().equals(msg.getSender()))
                                this.outputStream.writeUTF("Message not send. You want to send msg to yourself");
                            else
                                receiver.outputStream.writeUTF(this.name+" : "+msg.getContent());
                        }
                        else
                            this.outputStream.writeUTF("Message not send. User is not connected to the server");

                        System.out.println(msg);
                    }
                }
                else
                    this.outputStream.writeUTF("Message has wrong format. Did not send message");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try
        {
            this.outputStream.writeUTF("disconnect");
            this.inputStream.close();
            this.outputStream.close();
            if(!this.socket.isClosed())
                this.socket.close();

            this.clients.remove(this.name);
            String msg = "Active clients : " + this.clients.getListOfClients();

            System.out.println(msg);
            this.clients.informClients(msg);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public String getName(){
        return this.name;
    }

    public DataOutputStream getOutputStream() {
        return outputStream;
    }

    public Socket getSocket() {
        return socket;
    }
}
