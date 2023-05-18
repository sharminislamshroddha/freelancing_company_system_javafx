/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLCustomerGiveProjectReviewController implements Initializable {
    
    Customer c=null;
    @FXML
    private TextField taskNo;
    @FXML
    private TextField cusID;
    @FXML
    private TextField stafID;
    @FXML
    private ComboBox<String> projectRating;
    @FXML
    private ComboBox<String> behavior;
    @FXML
    private ComboBox<String> onTime;
    @FXML
    private ComboBox<String> satisfaction;
    @FXML
    private TextArea cmnt;
    @FXML
    private TextArea viewTask;
    void initDataAdm(User customer) {
        c = (Customer)customer;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        viewTask.setText("");
         ArrayList<TakenTask>uList = TakenTask.listOfTakenTask();
         for(TakenTask i: uList){
             if(i.getCustomerID() == c.getId()){
                 viewTask.appendText(i.toString());
             }
         }
         
    }    

    @FXML
    private void onClickHomeSceneButton(ActionEvent event) throws IOException {
        FXMLLoader loader3 = new FXMLLoader();
                loader3.setLocation(getClass().getResource("FXMLCustomerHomeScene.fxml"));
                Parent homeScene3 = loader3.load();
                Scene homepage3 = new Scene(homeScene3);
                Stage window3 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window3.setScene(homepage3);
                window3.show();
    }

    @FXML
    private void onClickSubmitButton(ActionEvent event) {
        ProjectReview p = new ProjectReview(
                 Integer.parseInt(onTime.getValue().toString()),
                 Integer.parseInt(projectRating.getValue().toString()),
                 Integer.parseInt(behavior.getValue().toString()),
                 Integer.parseInt(satisfaction.getValue().toString()),
                 Integer.parseInt(cusID.getText()),
                 Integer.parseInt(stafID.getText()),
                 Integer.parseInt(taskNo.getText()),
                cmnt.getText()
        
        );
        p.addProjectReview();
    }

    
    
}
