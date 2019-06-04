package serverConnect;

import orderController.OrderController;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class ServerConnector {
    private static ServerConnector serverConnector;
    private OrderController orderController;

    private ServerConnector() throws Exception {
        this.orderController=(OrderController)Naming.lookup("rmi://localhost:5050/placeOrder");
    }
    public static ServerConnector getInstance()throws Exception{
        if(serverConnector==null){
            serverConnector = new ServerConnector();
        }
        return serverConnector;
    }
    public OrderController getOrderController(){
        return orderController;
    }
}


