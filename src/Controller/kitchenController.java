package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class kitchenController implements Initializable {

    @FXML
    private TableView<?> kitchentbl;

    @FXML
    private JFXButton logoutbtn;

    @FXML
    private JFXButton cookbtn;

    @FXML
    private JFXTextField chefnametxt;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
