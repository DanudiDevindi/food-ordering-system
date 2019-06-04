package viewController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.OrderDTO;
import dto.PizzaTypeDTO;
import dto.ReceptionDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import observes.OrderObserveimpl;
import orderController.OrderController;
import serverConnect.ServerConnector;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReceptionController  implements Initializable {

    @FXML
    private JFXTextField cusNametxt;

    @FXML
    private JFXTextField tptxt;

    @FXML
    private JFXTextField addresstxt;

    @FXML
    private JFXTextField qtytxt;

    @FXML
    private TableView<OrderDTO> OrdersTable;

    @FXML
    private JFXTextField receptionNametxt;

    @FXML
    private JFXButton addOrderbtn;

    @FXML
    private JFXComboBox<String> pizzatypesCombo;


    private OrderObserveimpl orderObserveimpl;
    private OrderController orderController;
    private ReceptionDTO receptionDTO;
    private ArrayList<PizzaTypeDTO>pizzaTypes=new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        receptionController=this;
        OrdersTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("custName"));
        OrdersTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("status"));
        OrdersTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("cheff"));
        OrdersTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("boyName"));

        try {
            this.orderObserveimpl = new OrderObserveimpl(this);
            this.orderController = ServerConnector.getInstance().getOrderController();
            orderController.addOrderObserve(orderObserveimpl);
            pizzaTypes=orderController.getAllPizzaTypes();
            ObservableList<String>types=FXCollections.observableArrayList();
            for (PizzaTypeDTO p : pizzaTypes) {
                types.add(p.getType());
            }
            pizzatypesCombo.setItems(types);
            orderController.checkStatus();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @FXML
    void addOrders(ActionEvent event) {
        try {

            if(pizzatypesCombo.getSelectionModel().getSelectedIndex()>=0) {
                orderController.addOrder(new OrderDTO(
                        cusNametxt.getText(),
                        addresstxt.getText(),
                        Integer.parseInt(tptxt.getText()),
                        Integer.parseInt(qtytxt.getText()),
                        "Pending...",
                        "Pending...",
                        "Pending...",
                        pizzaTypes.get(pizzatypesCombo.getSelectionModel().getSelectedIndex()).getTypeId(),
                        pizzaTypes.get(pizzatypesCombo.getSelectionModel().getSelectedIndex()).getType(),
                        Double.parseDouble(qtytxt.getText()) * pizzaTypes.get(pizzatypesCombo.getSelectionModel().getSelectedIndex()).getPrice()
                ));
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Select type").show();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void reqAddress(ActionEvent event) {
        addresstxt.requestFocus();

    }

    @FXML
    void reqQTY(ActionEvent event) {
        qtytxt.requestFocus();

    }

    @FXML
    void reqTP(ActionEvent event) {
        tptxt.requestFocus();

    }

    @FXML
    void TableClick(MouseEvent event) {

    }

    public void removeOrderObserve() {
        try {
            orderController.removeOrderObserve(orderObserveimpl);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.exit(0);


    }

    public void loadOrdresIfIsAdded(ArrayList<OrderDTO> orderDTOS) {
        OrdersTable.getColumns().removeAll();
        OrdersTable.setItems(FXCollections.observableArrayList(orderDTOS));

    }


    @FXML
    void wernHignQty(KeyEvent event) {

    }


    public void setReception(ReceptionDTO receptionDTO){
        this.receptionDTO=receptionDTO;
        receptionNametxt.setText(receptionDTO.getName());
    }
private static ReceptionController receptionController;
    public  static ReceptionController getReceptionController(){
        return  receptionController;
    }
}







