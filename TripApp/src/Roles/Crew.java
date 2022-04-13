package Roles;

import Utils.Management;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Crew {
    private final String name;
    private final Scanner input;
    private final Management management;

    public Crew(String name, Scanner input, Management management){
        this.name = name;
        this.input = input;
        this.management = management;
    }

    public void start(){
        try {
            this.management.ackAcknowledgment(this.management.initAcknowledgementsQueue(this.name), this.name);
            this.management.ackAdminMsg(this.management.initRoleQueue(1), this.name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("You are ready to put your orders!");
        while(true){
            System.out.println("To put orders type things you want to get. Products have to separated by ' '");
            String[] orders = this.input.nextLine().strip().split(" ");
            for(String product : orders){
                if(product.toLowerCase(Locale.ROOT).equals("end"))
                    System.exit(0);

                try {
                    this.management.publishOrder(product, this.name);
                } catch (IOException e) {
                    System.err.println("Post order for " + product + " for crew " + this.name + "has failed!");
                    System.err.println("Order will be omitted and not posted");
                    e.printStackTrace();
                }
            }
        }
    }
}
