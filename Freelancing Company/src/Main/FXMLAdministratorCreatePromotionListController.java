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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLAdministratorCreatePromotionListController implements Initializable {

    @FXML
    private TableView<WorkingProgress> tableView;
    @FXML
    private TableColumn<WorkingProgress, String> idCol;
    @FXML
    private TableColumn<WorkingProgress, String> projectRateCol;
    @FXML
    private TableColumn<WorkingProgress, String> onTimeRateCol;
    @FXML
    private TableColumn<WorkingProgress, String> behaveRateCol;
    @FXML
    private TableColumn<WorkingProgress, String> workingRateCol;
    @FXML
    private TextField id;
    @FXML
    private TextField post;
    @FXML
    private TextField reason;
    @FXML
    private TextField status;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        idCol.setCellValueFactory(new PropertyValueFactory<WorkingProgress,String>("staffID"));
        projectRateCol.setCellValueFactory(new PropertyValueFactory<WorkingProgress,String>("numOfCompletedProject"));
        onTimeRateCol.setCellValueFactory(new PropertyValueFactory<WorkingProgress,String>("onTimeRate"));
        behaveRateCol.setCellValueFactory(new PropertyValueFactory<WorkingProgress,String>("behaviorRating"));
        workingRateCol.setCellValueFactory(new PropertyValueFactory<WorkingProgress,String>("workRating"));
        
        ArrayList<WorkingProgress>pList = WorkingProgress.listOfWorkingProgress();
        for(WorkingProgress i: pList){
            tableView.getItems().add(i);
            System.out.println(i.toString());
        }
        
    }    

    @FXML
    private void clickOnHomeScreenButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLAdministratorHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void onClickAddEmployeeButton(ActionEvent event) {
        ArrayList<User>u = UserList.listOfUser();
        String name="";
        if(u != null){
            for(User i: u){
                if(i.getId() == Integer.parseInt(id.getText())){
                    name = i.getName();
                }
            }
        }      
                
        PromotionList p = new PromotionList(
                Integer.parseInt(id.getText()),
                post.getText(),
                reason.getText(),
                status.getText(),
                name
        );
        p.addPromotionList();
    }
    
}
