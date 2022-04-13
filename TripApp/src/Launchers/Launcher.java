package Launchers;

import Roles.Admin;
import Roles.Crew;
import Roles.Supplier;
import Utils.ConnectionChannel;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Launcher {
    public static void main(String[] args) {
        ConnectionChannel connectionChannel;
        try {
            connectionChannel = new ConnectionChannel();
        } catch (IOException | TimeoutException e) {
            System.err.println("error occurred when connecting to message broker");
            e.printStackTrace();
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("What role do you want to be: crew,supplier or admin?");
        String role = input.nextLine();
        System.out.println("You have chosen: " + role);

        if(role.equals("crew")){
            System.out.println("Your crew name: ");
            String crewName = input.nextLine();
            Crew crew = new Crew(crewName, input, connectionChannel.getSystemManager());
            crew.start();
        }
        else if(role.equals("supplier")){
            System.out.println("Your supplier name:");
            String supplierName = input.nextLine();

            System.out.println("Types of products you offer (Split your offered products by typing ' ' between them):");
            String[] products = input.nextLine().split(" ");

            Supplier supplier = new Supplier(supplierName, products, connectionChannel.getSystemManager());
            input.close();
            supplier.start();
        }
        else{
            System.out.println("Your admin name: ");
            String systemName = input.nextLine();
            Admin admin = new Admin(systemName, connectionChannel.getSystemManager(), input);
            admin.start();
        }
    }
}
