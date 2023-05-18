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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLAdminitratorKeepWorkingProgressController implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, String> satffCol;
    @FXML
    private TableColumn<User, String> nameCol;
    @FXML
    private TextArea workingP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameCol.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
        satffCol.setCellValueFactory(new PropertyValueFactory<User,String>("id"));
        ArrayList<User>u = UserList.listOfUser();
        if(u != null){
            for(User i: u){
                if(i instanceof Staff){
                    tableView.getItems().add(i);
            
                }
            }
        }
    }  

    @FXML
    private void onClickKeepWorkingProgress(ActionEvent event) {
        WorkingProgress w = new WorkingProgress(Integer.parseInt(idField.getText()));
        w.addWorkingProgress();
        workingP.setText("");
        workingP.appendText(w.toString());
    }

    @FXML
    private void onCLickHomeScene(ActionEvent event) throws IOException {
       FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLAdministratorHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show(); 
    }
       
}
