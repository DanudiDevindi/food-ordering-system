package orderController;

import dto.*;
import observable.OrderObserve;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface OrderController extends Remote {
    void addOrderObserve(OrderObserve o)throws RemoteException;
    void addOrder(OrderDTO o)throws RemoteException;
    void removeOrderObserve(OrderObserve o)throws RemoteException;
    ArrayList<ReceptionDTO>getAllReceptions()throws Exception;
    void checkStatus()throws  RemoteException;
    ArrayList<DelivaryDTO>getAllDeliverBoys()throws Exception;
    ArrayList<ChefDTO>getAllchefs()throws  Exception;

    void doneDeliver(DelivaryDTO delivaryDTO, OrderDTO o)throws Exception;
    void DeliverPizza(DelivaryDTO delivaryDTO,OrderDTO o)throws Exception;
    void setCheff(ChefDTO chefDTO,OrderDTO o)throws  Exception;
    void madePizza(ChefDTO chefDTO, OrderDTO o)throws  Exception;


    ArrayList<PizzaTypeDTO> getAllPizzaTypes()throws Exception;
}
