package main;

import orderController.orderControllerimpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRun {
    public static void main(String[]args){
        try {
            Registry registry = LocateRegistry.createRegistry(5050);
            System.out.println("server Starting");
            registry.rebind("placeOrder",new orderControllerimpl());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
