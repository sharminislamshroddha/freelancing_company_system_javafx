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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLViewCustomerFeedBackHeadController implements Initializable {

    @FXML
    private CheckBox projectReviewChkBox;
    @FXML
    private CheckBox sugChkBox;
    @FXML
    private TextArea viewField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
               
    }    

    @FXML
    private void onClickViewButton(ActionEvent event) {
        viewField.setText("");
        if(projectReviewChkBox.isSelected()){
            ArrayList<ProjectReview>p = ProjectReview.listOfProjectReview();
            for(ProjectReview i: p){
                viewField.appendText("Task No: "+i.getTaskNo()+"\n");
                ArrayList<TaskProposal>to = TaskProposal.listOfTaskProposal();
                for(TaskProposal j: to){
                    if(j.getTaskNo() == i.getTaskNo()){
                        viewField.appendText("Task Topic: "+j.getTitle()+"\n");
                    }
                }
                viewField.appendText("Staff ID: "+String.valueOf(i.getStaffID())+"\n");
                viewField.appendText("On Time: "+String.valueOf(i.getOnTimeRating())+"\n");
                viewField.appendText("Behavior Rating: "+String.valueOf(i.getBehaviorRating())+"\n");
                viewField.appendText("Project Rating: "+String.valueOf(i.getProjectRating())+"\n");
                viewField.appendText("Satisfaction Rating: "+String.valueOf(i.getSatisfactionRating())+"\n\n");
            }
        }
        if(sugChkBox.isSelected()){
             ArrayList<Suggestion>uList = Suggestion.listOfSuggestion();
             for(Suggestion i: uList){
                viewField.appendText("Customer ID: "+String.valueOf(i.getCusID())+"\n");
                ArrayList<User>user = UserList.listOfUser();
                for(User j: user){
                    if(j instanceof Customer){
                        if(j.getId() == i.getCusID()){
                            viewField.appendText("Customer Name: "+j.getName()+"\n");
                        }
                    }
                }
                viewField.appendText("Customer suggestion: "+i.getContent()+"\n\n");
            }
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
