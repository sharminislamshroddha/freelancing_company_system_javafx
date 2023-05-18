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
public class FXMLAdministrationCreateNewCandidateShortListController implements Initializable {

    @FXML
    private TableView<Candidate> tableView;
    @FXML
    private TableColumn<Candidate, String> idCol;
    @FXML
    private TableColumn<Candidate, String> nameCol;
    @FXML
    private TextField candID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idCol.setCellValueFactory(new PropertyValueFactory<Candidate,String>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Candidate,String>("name"));
        
         ArrayList<User>u = UserList.listOfUser();
        if(u != null){
            for(User i: u){
                if(i instanceof Candidate){
                    Candidate c = (Candidate)i;
                    tableView.getItems().add(c);
                }
            }
        }
        
    }    

    @FXML
    private void onClickAddCandidate(ActionEvent event) {
        int canID = Integer.parseInt(candID.getText());
        ArrayList<User>u = UserList.listOfUser();
        if(u != null){
            for(User i: u){
                if(i.getId() == canID){
                    Candidate c = (Candidate)i;
                    c.setCanStatus(true);
                }
            }
        }
    }

    @FXML
    private void onCLickOnHomeScene(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLAdministratorHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
    
}
