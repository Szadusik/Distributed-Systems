package MessageManager;

import java.util.Random;
import java.util.StringTokenizer;

public class Message {
    private final String sender;
    private String receiver;
    private String content;
    private final String[] special = {"disconnect", "limitExceeded"};

    public Message(){
        this.sender = "";
        this.receiver = "";
        this.content = "";
    }

    public Message(String sender){
        this.sender = sender;
        this.receiver = "";
        this.content = "";
    }

    public boolean isMessageCorrect(String msg){
        StringTokenizer st = new StringTokenizer(msg,"|");
        if (st.countTokens() <= 1){
            String res = st.nextToken();
            for(String term: this.special){
                if(res.equals(term))
                    return true;
            }
            return false;
        }
        else{
            while(st.countTokens() !=1){
                st.nextToken();
            }
            String user = st.nextToken();
            return user.contains("user#");
        }
    }

    public void proceedMessage(String msg){
        StringTokenizer st = new StringTokenizer(msg,"|");
        System.out.println("Proceeding message");
        if(st.countTokens() == 1){
            this.content = msg;
        }
        else{
            while (st.countTokens() != 1){
                this.content += st.nextToken();
            }
            this.receiver = st.nextToken();
        }
    }

    public byte[] generateUDPMessage(int length){
        byte[] msg = new byte[length];
        new Random().nextBytes(msg);
        return msg;
    }

    public String getContent() {
        return this.content;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public String getSender() {
        return sender;
    }

    public String toString(){
        return "Send by : "+ this.sender + "\nTo : "+this.receiver+"\nContent : "+this.content;
    }
}
