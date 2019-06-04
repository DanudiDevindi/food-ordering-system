package viewController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.DelivaryDTO;
import dto.OrderDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import observes.OrderObserveimpl;
import orderController.OrderController;
import serverConnect.ServerConnector;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class deliverController implements Initializable {
    @FXML
    private JFXTextField deliverboynametxt;

    @FXML
    private TableView<OrderDTO> OrdersTable;

    @FXML
    private JFXButton Completebtn;

    @FXML
    private JFXButton deliverbtn;
    private DelivaryDTO delivaryDTO;
    private OrderObserveimpl orderObserve;
    private OrderController orderController;
    private  static deliverController deliverController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OrdersTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("custName"));
        OrdersTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("address"));
        OrdersTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("tel"));
        OrdersTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("price"));
        OrdersTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("status"));
        try{
            this.orderController =ServerConnector.getInstance().getOrderController();
            this.orderObserve=new OrderObserveimpl(this);
            orderController.addOrderObserve(orderObserve);
            orderController.checkStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }
        deliverController=this;
    }

   public void pizzadeliver(ActionEvent event) {
        try {
            orderController.DeliverPizza(delivaryDTO,OrdersTable.getSelectionModel().getSelectedItem());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void doneDeliver(ActionEvent event) {
        try {
            orderController.doneDeliver(delivaryDTO,OrdersTable.getSelectionModel().getSelectedItem());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void clickTable(MouseEvent event) {

    }

    public  void setDelivery(DelivaryDTO delivaryDTO){
        this.delivaryDTO=delivaryDTO;
        deliverboynametxt.setText(delivaryDTO.getDelvryBot());
    }
    public  static deliverController getDeliverController(){
        return deliverController;
    }
    public  void removeObserver(){
        try {
            orderController.removeOrderObserve(orderObserve);
        } catch (RemoteException e) {
            e.printStackTrace();
        }finally {
            System.exit(0);
        }
    }
    public  void UpdateTable(ArrayList<OrderDTO> orderDTOS){
        OrdersTable.getColumns().removeAll();
        OrdersTable.setItems(FXCollections.observableArrayList(orderDTOS));
    }





}
