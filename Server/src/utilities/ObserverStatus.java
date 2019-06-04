package utilities;

import dto.ChefDTO;
import dto.CustomerDTO;
import dto.DelivaryDTO;
import dto.OrderDTO;
import observable.OrderObserve;
import repository.Repository;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class ObserverStatus {
    private Repository repository = new Repository();
    private ArrayList<OrderObserve> orderObserves = new ArrayList<>();
    private ArrayList<OrderDTO> orderDTOS = new ArrayList<>();

    private ArrayList<ChefDTO> chefDTOS = new ArrayList<>();
    private ArrayList<DelivaryDTO> delivaryDTOS = new ArrayList<>();

    public void addStatusObserves(OrderObserve observe) {
        orderObserves.add(observe);

        try {


            chefDTOS = repository.loadAllCheffs();
            delivaryDTOS = repository.loadAllDeliveryBoys();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addOrder(OrderDTO o) {
        orderDTOS.add(o);
        try {
            notifyStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makePizza(ChefDTO chefDTO, OrderDTO o) {
        try {
            for (int i = 0; i < orderDTOS.size(); i++) {
                if (orderDTOS.get(i).getTel() == o.getTel()) {
                    orderDTOS.get(i).setCheffId(chefDTO.getCheffId());
                    orderDTOS.get(i).setCheff(chefDTO.getCheff());
                    orderDTOS.get(i).setStatus("cooking");
                    notifyStatus();
                    break;


                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void madePizza(ChefDTO chefDTO, OrderDTO o) {
        try {
            for (int i = 0; i < orderDTOS.size(); i++) {
                System.out.println(orderDTOS.get(i).getTel());
                if (orderDTOS.get(i).getTel() == o.getTel()) {
                    orderDTOS.get(i).setStatus("Cooked");
                    notifyStatus();
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deliverPizza(OrderDTO o,DelivaryDTO delivaryDTO){
        try{
            for(int i=0;i<orderDTOS.size();i++){
                if(orderDTOS.get(i).getTel()==o.getTel()){
                    orderDTOS.get(i).setStatus("On Delivery");
                    orderDTOS.get(i).setBoyId(delivaryDTO.getDbId());
                    orderDTOS.get(i).setBoyName(delivaryDTO.getDelvryBot());
                    notifyStatus();
                    break;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void doneDeliver(DelivaryDTO deliveryDTO, OrderDTO o) {
        try {
            for (int i = 0; i < orderDTOS.size(); i++) {
                if (orderDTOS.get(i).getTel() == o.getTel()) {
                    orderDTOS.get(i).setStatus("Delivered");
                    notifyStatus();
                    break;
                }
            }
            repository.saveCustomer(new CustomerDTO(0,o.getCustName(),o.getAddress(),o.getTel()));
            ArrayList<CustomerDTO> allCustomers = repository.getAllCustomers();
            repository.saveOrder(o,allCustomers.get(allCustomers.size()-1).getcid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void notifyStatus()throws RemoteException{
        for(OrderObserve o:orderObserves){
            o.isOrderAdded(orderDTOS);
        }
    }
    public void removeOrder(OrderDTO o){
        orderDTOS.remove(o);
    }
    public void removeObserves(OrderObserve observe){
        orderObserves.remove(observe);
    }
}


