package viewController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.ChefDTO;
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
import serverConnect.SeverConnector;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class KitchenController implements Initializable {

    @FXML
    private TableView<OrderDTO> OrderTable;

    @FXML
    private JFXButton completebtn;

    @FXML
    private JFXButton startbtn;

    @FXML
    private JFXTextField chefnametxt;
    private OrderObserveimpl orderObserveimpl;
    private OrderController orderController;
    private ArrayList<OrderDTO>orderDTOS=new ArrayList<>();
    private ChefDTO chefDTO;
    private static KitchenController kitchenController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OrderTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("type"));
        OrderTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("qty"));
        OrderTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("reception"));
        OrderTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("cheff"));
        OrderTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("status"));

        kitchenController = this;
        try{
            this.orderController=SeverConnector.getSeverConnector().getOrderController();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            orderObserveimpl=new OrderObserveimpl(this);
            orderController.addOrderObserve(orderObserveimpl);
            orderController.checkStatus();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

//
    }

    @FXML
    void StartCooking(ActionEvent event) {
        try{
            orderController.setCheff(chefDTO,OrderTable.getSelectionModel().getSelectedItem());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//

    @FXML
    void cookfinish(ActionEvent event) {
        try{
            orderController.madePizza(chefDTO,OrderTable.getSelectionModel().getSelectedItem());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    void clicktable(MouseEvent event) {


    }

    public  void UpdateTable(ArrayList<OrderDTO>orderDTOS){
        OrderTable.getColumns().removeAll();
        OrderTable.setItems(FXCollections.observableList(orderDTOS));
    }
    public  void removeObserve(){
        try{
            orderController.removeOrderObserve(orderObserveimpl);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        finally {

                System.exit(0);

                }
    }
    public static KitchenController getKitchenController(){
        return  kitchenController;
    }
    public void setChef(ChefDTO chefDTO){
        this.chefDTO=chefDTO;
        chefnametxt.setText(chefDTO.getCheff());
    }





}
