package viewController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.ReceptionDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import orderController.OrderController;
import serverConnect.ServerConnector;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReceptionistLoginController implements Initializable {
    @FXML
    private JFXTextField nameText;

    @FXML
    private JFXButton logBtn;

    @FXML
    private JFXTextField passwordText;

    private ArrayList<ReceptionDTO>receptions=new ArrayList<>();
    private OrderController orderController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            this.orderController=ServerConnector.getInstance().getOrderController();
            receptions=orderController.getAllReceptions();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void login(ActionEvent event) {
        try {
            for (ReceptionDTO r : receptions) {
                if (r.getName().equalsIgnoreCase(nameText.getText())) {
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(this.getClass().getResource("/view/Reception.fxml"));
                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    primaryStage.setResizable(false);
                    primaryStage.show();
                    ReceptionController.getReceptionController().setReception(r);
                    return;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void requesPw(ActionEvent event) {
        passwordText.requestFocus();
    }
}
