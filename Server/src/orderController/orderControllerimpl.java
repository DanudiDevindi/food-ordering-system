package orderController;

import dto.*;
import observable.OrderObserve;
import repository.Repository;
import utilities.ObserverStatus;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class orderControllerimpl extends UnicastRemoteObject implements OrderController {
    ObserverStatus observerStatus;
    Repository repository = new Repository();

    public orderControllerimpl() throws RemoteException {
         observerStatus = new ObserverStatus();

    }

    @Override
    public void addOrderObserve(OrderObserve o) throws RemoteException {
        observerStatus.addStatusObserves(o);

    }

    @Override
    public void addOrder(OrderDTO o) throws RemoteException {
        observerStatus.addOrder(o);

    }

    @Override
    public void removeOrderObserve(OrderObserve o) throws RemoteException {
      observerStatus.removeObserves(o);
    }

    @Override
    public ArrayList<ReceptionDTO> getAllReceptions() throws Exception {
        return repository.getAllReceptions();
    }

    @Override
    public void checkStatus() throws RemoteException {
        observerStatus.notifyStatus();

    }

    @Override
    public ArrayList<DelivaryDTO> getAllDeliverBoys() throws Exception {
        return repository.loadAllDeliveryBoys();
    }

    @Override
    public ArrayList<ChefDTO> getAllchefs() throws Exception {
        return repository.loadAllCheffs();
    }

    @Override
    public void doneDeliver(DelivaryDTO delivaryDTO, OrderDTO o) throws Exception {
     observerStatus.doneDeliver(delivaryDTO,o);
    }

    @Override
    public void DeliverPizza(DelivaryDTO delivaryDTO, OrderDTO o) throws Exception {
     observerStatus.deliverPizza(o,delivaryDTO);
    }

    @Override
    public void setCheff(ChefDTO chefDTO, OrderDTO o) throws Exception {
       observerStatus.makePizza(chefDTO,o);
    }

    @Override
    public void madePizza(ChefDTO chefDTO, OrderDTO o) throws Exception {
   observerStatus.madePizza(chefDTO,o);
    }

    @Override
    public ArrayList<PizzaTypeDTO> getAllPizzaTypes() throws Exception {
        return repository.getAllPizzaTypes();
    }
}
