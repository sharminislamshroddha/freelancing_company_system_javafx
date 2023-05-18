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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class FXMLStaffViewAssignTaskController implements Initializable {
    
    Staff s = null;
    void initData(User staff) {
        s = (Staff)staff;
    }
    
     @FXML    private TableView<TaskProposal> tableView;
    @FXML    private TableColumn<TaskProposal, String> taskIDCol;
    @FXML    private TableColumn<TaskProposal, String> customerIDCol;
    @FXML    private TableColumn<TaskProposal, String> taskTitleCol;
    @FXML    private TableColumn<TaskProposal, LocalDate> dueDateCol; 

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         taskIDCol.setCellValueFactory(new PropertyValueFactory<TaskProposal,String>("taskNo"));
        customerIDCol.setCellValueFactory(new PropertyValueFactory<TaskProposal,String>("customerID"));
        taskTitleCol.setCellValueFactory(new PropertyValueFactory<TaskProposal,String>("title"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<TaskProposal,LocalDate>("dueDate"));
        
        ArrayList<TakenTask>m = TakenTask.listOfTakenTask();
        ArrayList<TaskProposal>t = TaskProposal.listOfTaskProposal();
        for(TakenTask i: m){
            if(s.getId() == i.getStaffID()){
                for(TaskProposal j: t){
                    if(i.getTaskNo() == j.getTaskNo()){
                        tableView.getItems().add(j);
                    }
                }
            }
        }
        
        
    }    

    @FXML
    private void onClickHomeSceneButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLStaffHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXMLManagerHomeSceneController controller1 = loader1.getController();
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

   

    
    
}
