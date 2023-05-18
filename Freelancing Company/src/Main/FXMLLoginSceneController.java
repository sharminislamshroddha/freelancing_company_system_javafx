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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLLoginSceneController implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private TextField passwordField;
    @FXML
    private ComboBox comboUserType;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboUserType.getItems().addAll("Customer","Staff","Manager","Administrator","Head");
        comboUserType.setValue("Head");
    }    

    @FXML
    private void onClickLoginButton(ActionEvent event) throws IOException {
        /*ArrayList<User>uList = UserList.listOfUser();
        int inputID = Integer.parseInt(idField.getText());
        User u = null;
        for(User i: uList){
            if(i.getId() == inputID && i.getPassword().equals(passwordField.getText()) && i.getUser_type().equals(comboUserType.getValue())){
                u = i;
            }
        }
        */User u = User.login(
                Integer.parseInt(idField.getText()),
                passwordField.getText(),
                comboUserType.getValue().toString()
                );
        
        if(u==null){
            label.setText("User-ID, Password and User Type combination failed. Try again!");
        }
        else{
            
            if(u instanceof Customer){
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("FXMLCustomerHomeScene.fxml"));
                Parent homeScene1 = loader1.load();
                Scene homepage1 = new Scene(homeScene1);
                FXMLCustomerHomeSceneController controller1 = loader1.getController();
                controller1.initDataCus(u);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(homepage1);
                window1.show();
            }
            else if(u instanceof Staff){
                FXMLLoader loader2 = new FXMLLoader();
                loader2.setLocation(getClass().getResource("FXMLStaffHomeScene.fxml"));
                Parent homeScene2 = loader2.load();
                Scene homepage2 = new Scene(homeScene2);
                FXMLStaffHomeSceneController controller2 = loader2.getController();
                controller2.initDataSta(u);
                Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window2.setScene(homepage2);
                window2.show();
            }
            else if(u instanceof Administrator){
                FXMLLoader loader3 = new FXMLLoader();
                loader3.setLocation(getClass().getResource("FXMLAdministratorHomeScene.fxml"));
                Parent homeScene3 = loader3.load();
                Scene homepage3 = new Scene(homeScene3);
                FXMLAdministratorHomeSceneController controller3 = loader3.getController();
                controller3.initDataAdm(u);
                Stage window3 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window3.setScene(homepage3);
                window3.show();
            }
            else if(u instanceof Head){
                FXMLLoader loader4 = new FXMLLoader();
                loader4.setLocation(getClass().getResource("FXMLHeadHomeScene.fxml"));
                Parent homeScene4 = loader4.load();
                Scene homepage4 = new Scene(homeScene4);
                FXMLHeadHomeSceneController controller4 = loader4.getController();
                controller4.initDataHea(u);
                Stage window4 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window4.setScene(homepage4);
                window4.show();
            }
            else if(u instanceof Manager){
                FXMLLoader loader5 = new FXMLLoader();
                loader5.setLocation(getClass().getResource("FXMLManagerHomeScene.fxml"));
                Parent homeScene5 = loader5.load();
                Scene homepage5 = new Scene(homeScene5);
                FXMLManagerHomeSceneController controller5 = loader5.getController();
                controller5.initDataMan(u);
                Stage window5 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window5.setScene(homepage5);
                window5.show();
            }
           
        }
    }
    
}
