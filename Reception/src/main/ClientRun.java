package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import viewController.ReceptionController;

public class ClientRun extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Reseptionist loging.fxml"));
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            ReceptionController.getReceptionController().removeOrderObserve();
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}



