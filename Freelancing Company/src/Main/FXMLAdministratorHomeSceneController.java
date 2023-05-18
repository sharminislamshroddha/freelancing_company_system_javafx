/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLAdministratorHomeSceneController implements Initializable {
    
    User administrator = null;
    public void initDataAdm(User u){
        administrator = u;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClickCreateStaffID(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLCreateEmployee.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void onClickUpdateCompanyProfileButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLAdministratorUpdateCompanyProfile.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void onClickKeepWorkingProgressRecordButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLAdminitratorKeepWorkingProgress.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void onClickCreatePromotionListButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLAdministratorCreatePromotionList.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void onClickHireNewEmployeeButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLAdministrationCreateNewCandidateShortList.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void onCLickLogoutButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLLoginScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXMLLoginSceneController controller1 = loader1.getController();
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void onClickCreateCutomerAcoountButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLCreateCustomer.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void onClickCreateCandidateAccountButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLCreateCandidate.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
    
}
