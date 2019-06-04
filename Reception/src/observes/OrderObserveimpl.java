package observes;

import dto.OrderDTO;
import observable.OrderObserve;
import viewController.ReceptionController;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class OrderObserveimpl extends UnicastRemoteObject implements OrderObserve {
    public  ReceptionController receptionController;
    public OrderObserveimpl(ReceptionController receptionController) throws RemoteException {
        this.receptionController=receptionController;
    }

    @Override
    public void isOrderAdded(ArrayList<OrderDTO> orders) throws RemoteException {
         receptionController.loadOrdresIfIsAdded(orders);
    }
}
