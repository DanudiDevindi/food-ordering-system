package serverConnect;

import orderController.OrderController;

import java.rmi.Naming;

public class SeverConnector {
    public static SeverConnector severConnector;
    private OrderController orderController;
    private SeverConnector()throws Exception{
        orderController = (OrderController)Naming.lookup("rmi://localhost:5050/placeOrder");

    }
    public static SeverConnector getSeverConnector()throws Exception{
        if(severConnector==null){
            severConnector=new SeverConnector();

        }
        return severConnector;
    }

    public OrderController getOrderController() throws Exception {
        return  orderController;
            }



    }

