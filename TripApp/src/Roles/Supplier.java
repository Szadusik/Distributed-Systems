package Roles;

import Utils.Management;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Supplier {
    private final String supplier;
    private final String[] products;
    private final Management management;
    private final Random ackIDGenerator = new Random();

    public Supplier(String supplier, String[] products, Management management){
        this.supplier = supplier;
        this.products = products;
        this.management = management;
    }

    public void start(){
        try {
            this.management.ackAdminMsg(this.management.initRoleQueue(0), this.supplier);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Supplier : " + this.supplier);
        System.out.println("Offered types of products : " + Arrays.toString(this.products));
        for(String orderType : this.products){
            try {
                this.management.initQueue(orderType,1);
                this.management.ackOrders(orderType, this.supplier, this.ackIDGenerator);
            } catch (IOException e) {
                System.err.println("Error with initializing queue for product type: " + orderType);
                System.err.println("Product will be omitted and queue will not be created");
                e.printStackTrace();
            }
        }
        System.out.println("Supplier ready to receive orders!");
    }
}
