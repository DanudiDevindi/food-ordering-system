package serverConnect;

import orderController.OrderController;

import java.rmi.Naming;

public class ServerConnector {
    private OrderController orderController;
    public static ServerConnector serverConnector;
    private ServerConnector()throws Exception{
        orderController=(OrderController)Naming.lookup("rmi://localhost:5050/placeOrder");

    }
    public  static ServerConnector getInstance()throws Exception{
        if(serverConnector==null){
            serverConnector = new ServerConnector();


        }
        return serverConnector;
    }
    public OrderController getOrderController(){
        return orderController;
    }
}
