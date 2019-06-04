package observable;

import dto.OrderDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface OrderObserve extends Remote {

    void isOrderAdded(ArrayList<OrderDTO>orders)throws RemoteException;
}
