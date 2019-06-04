package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class deliverController implements Initializable {

    @FXML
    private JFXTextField deliverboynametxt;

    @FXML
    private TableView<?> delivertbl;

    @FXML
    private JFXButton logoutbtn;

    @FXML
    private JFXButton deliverbtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
