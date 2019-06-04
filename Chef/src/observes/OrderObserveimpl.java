package observes;

import dto.OrderDTO;
import observable.OrderObserve;
import viewController.KitchenController;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class OrderObserveimpl extends UnicastRemoteObject implements OrderObserve {
    private KitchenController kitchenController;
    public OrderObserveimpl(KitchenController kitchenController) throws RemoteException {
        this.kitchenController=kitchenController;
    }

    @Override
    public void isOrderAdded(ArrayList<OrderDTO> orders) throws RemoteException {
        kitchenController.UpdateTable(orders);
    }
}
