package viewController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.ChefDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import orderController.OrderController;
import serverConnect.SeverConnector;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChefLogingController implements Initializable {
    @FXML
    private JFXTextField nameText;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXTextField passwordText;

    private ArrayList<ChefDTO>chefs=new ArrayList<>();
    private OrderController orderController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            orderController=SeverConnector.getSeverConnector().getOrderController();
            chefs=orderController.getAllchefs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void login(ActionEvent event) {
        try {
            for (ChefDTO c : chefs) {
                System.out.println(c.getCheff()+c.getPassword());
                if (c.getCheff().equalsIgnoreCase(nameText.getText()) && c.getPassword().equals(passwordText.getText())) {
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(this.getClass().getResource("/view/Kitchen.fxml"));
                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    primaryStage.setResizable(false);
                    primaryStage.show();
                    KitchenController.getKitchenController().setChef(c);
                    return;
                }
            }
            new Alert(Alert.AlertType.ERROR,"Wrong login info").show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void requestPw(ActionEvent event) {
        passwordText.requestFocus();
    }

}
