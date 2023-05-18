package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXMLTakenTaskController implements Initializable {

    @FXML    private TableView<TaskProposal> tableView;
    @FXML    private TableColumn<TaskProposal, String> taskIDCol;
    @FXML    private TableColumn<TaskProposal, String> customerIDCol;
    @FXML    private TableColumn<TaskProposal, String> taskTitleCol;
    @FXML    private TableColumn<TaskProposal, LocalDate> dueDateCol; 
    @FXML
    private TableView<Staff> table2;
    @FXML
    private TableColumn<Staff, String> staffIDCol;
    @FXML
    private TableColumn<Staff, String> staffNameCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        taskIDCol.setCellValueFactory(new PropertyValueFactory<TaskProposal,String>("taskNo"));
        customerIDCol.setCellValueFactory(new PropertyValueFactory<TaskProposal,String>("customerID"));
        taskTitleCol.setCellValueFactory(new PropertyValueFactory<TaskProposal,String>("title"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<TaskProposal,LocalDate>("dueDate"));
        
        staffNameCol.setCellValueFactory(new PropertyValueFactory<Staff,String>("name"));
        staffIDCol.setCellValueFactory(new PropertyValueFactory<Staff,String>("id"));
        
        ArrayList<TaskProposal>t = TaskProposal.listOfTaskProposal();
        for(TaskProposal i: t){
            if(LocalDate.now().isBefore(i.getDueDate())){
                tableView.getItems().add(i);
                System.out.println(i.toString());
            }
        }
        ArrayList<User>uList = UserList.listOfUser();
        for(User i : uList){
            if(i instanceof Staff){
                table2.getItems().add((Staff)i);
            }
        }
        
    }

    @FXML
    private void onClickAssignTask(ActionEvent event) {
        TaskProposal p = tableView.getSelectionModel().getSelectedItem();
        Staff s = table2.getSelectionModel().getSelectedItem();
        
        Manager.assignTaskToStaff(s.getId(), p.getCustomerID(), p.getTaskNo());
    }

    @FXML
    private void onClickHomeSceneButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLManagerHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXMLManagerHomeSceneController controller1 = loader1.getController();
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
    
    
    
}
