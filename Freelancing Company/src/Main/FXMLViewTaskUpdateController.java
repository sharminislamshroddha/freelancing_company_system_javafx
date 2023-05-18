/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLViewTaskUpdateController implements Initializable {

    @FXML
    private TextArea viewField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<TakenTask>tList = TakenTask.listOfTakenTask();
        viewField.setText("");
        String s = "";
        for(TakenTask t: tList){
            s = String.valueOf(t.getTaskNo())+"\n";
            viewField.appendText("Task No: "+s);
            ArrayList<TaskProposal>to = TaskProposal.listOfTaskProposal();
            for(TaskProposal i: to){
                if(i.getTaskNo() == t.getTaskNo()){
                    viewField.appendText("Task Topic: "+i.getTitle()+"\n");
                    System.out.println(i.toString());
                }
            }
            viewField.appendText("Task Update: "+t.getTaskUpdate()+"\n");
            
        }

    }    


    @FXML
    private void onClickHomeSceneButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLHeadHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXMLHeadHomeSceneController controller1 = loader1.getController();
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
    
}
