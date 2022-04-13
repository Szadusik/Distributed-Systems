package Roles;

import Utils.Management;

import java.io.IOException;
import java.util.Scanner;

public class Admin {
    private final String name;
    private final Management management;
    private final Scanner input;

    public Admin(String name, Management management, Scanner input){
        this.name = name;
        this.management = management;
        this.input = input;
    }

    public void start(){
        try {
            this.management.initQueue(this.name,0);
            this.management.ackSysMessages(this.name);
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Admin up! To send msg only to crews start msg with crew-, to suppliers with supplier-," +
                "otherwise it will be sent to everyone");
        while(true){
            System.out.println("Send your message:");
            String msg = this.input.nextLine();
            try {
                if(msg.startsWith("crew-"))
                    this.management.sendAdminMsg(msg.replaceAll("crew-",""), false, true);
                else{
                    msg = msg.startsWith("supplier-") ? msg.replaceAll("supplier-","") : msg;
                    this.management.sendAdminMsg(msg, true, !msg.startsWith("supplier-"));
                }

            } catch (IOException e){
                System.err.println("Error occurred while sending your message!");
                e.printStackTrace();
            }

        }
    }
}
