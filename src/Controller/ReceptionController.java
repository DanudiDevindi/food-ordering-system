package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ReceptionController implements Initializable {

    @FXML
    private JFXTextField cusNametxt;

    @FXML
    private JFXTextField tptxt;

    @FXML
    private JFXTextField addtxt;

    @FXML
    private JFXTextField orderItemtxt;

    @FXML
    private JFXTextField qtytxt;

    @FXML
    private JFXTextField pricetxt;

    @FXML
    private TableView<?> ordertbl;

    @FXML
    private JFXButton addOrderbtn;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}


