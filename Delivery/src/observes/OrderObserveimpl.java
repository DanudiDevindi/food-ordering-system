package observes;

import dto.OrderDTO;
import observable.OrderObserve;
import viewController.deliverController;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class OrderObserveimpl extends UnicastRemoteObject implements OrderObserve {
         private deliverController deliverController;

    public OrderObserveimpl(deliverController deliverController) throws RemoteException {
        this.deliverController=deliverController;
    }

    @Override
    public void isOrderAdded(ArrayList<OrderDTO> orders) throws RemoteException {
    deliverController.UpdateTable(orders);
    }
}
