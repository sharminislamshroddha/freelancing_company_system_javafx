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
import javafx.stage.Stage;

public class FXMLCustomerHomeSceneController implements Initializable {
    
    User customer = null;
    public void initDataCus(User u){
        customer = u;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClickGiveTaskProposalButton(ActionEvent event) throws IOException {
                FXMLLoader loader3 = new FXMLLoader();
                loader3.setLocation(getClass().getResource("FXMLTaskProposal.fxml"));
                Parent homeScene3 = loader3.load();
                Scene homepage3 = new Scene(homeScene3);
                Stage window3 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window3.setScene(homepage3);
                window3.show();
    }

    @FXML
    private void onCLickCommunicateWithManagerButton(ActionEvent event) throws IOException {
        FXMLLoader loader3 = new FXMLLoader();
                loader3.setLocation(getClass().getResource("FXMLCustomerComunicationWithManager.fxml"));
                Parent homeScene3 = loader3.load();
                Scene homepage3 = new Scene(homeScene3);
                FXMLCustomerComunicationWithManagerController controller3 = loader3.getController();
                controller3.initDataAdm(customer);
                Stage window3 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window3.setScene(homepage3);
                window3.show();
    }

    @FXML
    private void onClickCommunicateWithStaffButton(ActionEvent event) throws IOException {
        FXMLLoader loader3 = new FXMLLoader();
                loader3.setLocation(getClass().getResource("FXMLCustomerComunicateWithStaff.fxml"));
                Parent homeScene3 = loader3.load();
                Scene homepage3 = new Scene(homeScene3);
                FXMLCustomerComunicateWithStaffController controller3 = loader3.getController();
                controller3.initData1(customer);
                Stage window3 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window3.setScene(homepage3);
                window3.show();
    }

    @FXML
    private void onClickGiveProjectReviewButton(ActionEvent event) throws IOException {
        FXMLLoader loader3 = new FXMLLoader();
                loader3.setLocation(getClass().getResource("FXMLCustomerGiveProjectReview.fxml"));
                Parent homeScene3 = loader3.load();
                Scene homepage3 = new Scene(homeScene3);
                FXMLCustomerGiveProjectReviewController controller3 = loader3.getController();
                controller3.initDataAdm(customer);
                Stage window3 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window3.setScene(homepage3);
                window3.show();
    }

    @FXML
    private void onClickGiveSuggestionButton(ActionEvent event) throws IOException {
        FXMLLoader loader3 = new FXMLLoader();
                loader3.setLocation(getClass().getResource("FXMLCustomerGiveSuggestion.fxml"));
                Parent homeScene3 = loader3.load();
                Scene homepage3 = new Scene(homeScene3);
                FXMLCustomerGiveSuggestionController controller3 = loader3.getController();
                controller3.initData(customer);
                Stage window3 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window3.setScene(homepage3);
                window3.show();
    }

    @FXML
    private void onClickLogOutButton(ActionEvent event) throws IOException {
        FXMLLoader loader3 = new FXMLLoader();
                loader3.setLocation(getClass().getResource("FXMLLoginScene.fxml"));
                Parent homeScene3 = loader3.load();
                Scene homepage3 = new Scene(homeScene3);
                Stage window3 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window3.setScene(homepage3);
                window3.show();
    }
    
    
    
    
}
