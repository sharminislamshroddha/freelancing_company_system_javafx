package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLTakenTask.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLTaskProposal.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLCreateCustomer.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("FXMLCreateEmployee.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLLoginScene.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }    
}