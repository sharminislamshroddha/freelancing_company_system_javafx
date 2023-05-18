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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXMLApproveJobListOfNewEmployee_HeadController implements Initializable {
    Head head = null;
    void initDataJobList(Head h){
        head =h;
    }
    
    @FXML
    private TableView<Candidate> tableView;
    @FXML
    private TableColumn<Candidate, String> nameCol;
    @FXML
    private TableColumn<Candidate, String> idCol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameCol.setCellValueFactory(new PropertyValueFactory<Candidate,String>("name"));
        idCol.setCellValueFactory(new PropertyValueFactory<Candidate,String>("id"));
        
        ArrayList<User>u = UserList.listOfUser();
        if(u != null){
            for(User i: u){
                if(i instanceof Candidate){
                    System.out.println(u.toString());
                    tableView.getItems().add((Candidate)i);
            
                }
            }
        }
    }    

    @FXML
    private void onClickDisappoveButton(ActionEvent event) {
        head.approveCandidateJobList(false);
    }

    @FXML
    private void onClickApproveButton(ActionEvent event) {
        head.approveCandidateJobList(true);
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
