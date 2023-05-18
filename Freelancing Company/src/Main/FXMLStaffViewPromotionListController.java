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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLStaffViewPromotionListController implements Initializable {

    @FXML
    private TableView<PromotionList> tableView;
    @FXML
    private TableColumn<PromotionList, String> idCol;
    @FXML
    private TableColumn<PromotionList, String> postCol;
    @FXML
    private TableColumn<PromotionList, String> reasonCol;
    @FXML
    private TableColumn<PromotionList, String> statusCol;
    @FXML
    private TableColumn<PromotionList, String> nameCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idCol.setCellValueFactory(new PropertyValueFactory<PromotionList,String>("empID"));
        postCol.setCellValueFactory(new PropertyValueFactory<PromotionList,String>("suggestedPost"));
        reasonCol.setCellValueFactory(new PropertyValueFactory<PromotionList,String>("reasonOfPromotion"));
        statusCol.setCellValueFactory(new PropertyValueFactory<PromotionList,String>("status"));
        nameCol.setCellValueFactory(new PropertyValueFactory<PromotionList,String>("empName"));
        
        ArrayList<PromotionList>pList = PromotionList.getPromotionList();
        for(PromotionList i: pList){
            tableView.getItems().add(i);
            System.out.println(i.toString());
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
