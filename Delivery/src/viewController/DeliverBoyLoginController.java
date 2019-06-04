package viewController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.DelivaryDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import orderController.OrderController;
import serverConnect.ServerConnector;

import java.io. IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DeliverBoyLoginController implements Initializable {

    @FXML
    private JFXTextField nameText;

    @FXML
    private JFXButton loginBitton;

    @FXML
    private JFXTextField passwordText;


    @FXML
    void requestPw(ActionEvent event) {

    }
    private ArrayList<DelivaryDTO> delivaries=new ArrayList<>();
    private OrderController orderController;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            this.orderController=ServerConnector.getInstance().getOrderController();
            delivaries=orderController.getAllDeliverBoys();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void logIN(ActionEvent actionEvent) {
        try {
            for (DelivaryDTO d:delivaries) {
                if(d.getDelvryBot().equalsIgnoreCase(nameText.getText())){
                    Parent ui=FXMLLoader.load(this.getClass().getResource("../view/deliver.fxml"));
                    Stage stage=new Stage();
                    stage.setScene(new Scene(ui));
                    stage.show();
                    deliverController.getDeliverController().setDelivery(d);
                    return;
                }
            }
            new Alert(Alert.AlertType.ERROR,"Error").show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void login(ActionEvent actionEvent) {
        try {
            for (DelivaryDTO d1:delivaries) {
                if(d1.getDelvryBot().equalsIgnoreCase(nameText.getText())){
                    Parent ui=FXMLLoader.load(this.getClass().getResource("../view/deliver.fxml"));
                    Stage stage=new Stage();
                    stage.setScene(new Scene(ui));
                    stage.show();
                    deliverController.getDeliverController().setDelivery(d1);
                    return;
                }
            }
            new Alert(Alert.AlertType.ERROR,"Error ").show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
