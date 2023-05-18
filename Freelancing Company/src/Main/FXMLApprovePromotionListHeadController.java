package Main;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class FXMLApprovePromotionListHeadController implements Initializable {
    
    Head head = null;
    public void initDataPromotion(User u){
        head = (Head)u;
    }
        
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
    
    private void onClickDisapproveButton(ActionEvent event) {    
        head.approvePromotionList(false);
    }

    private void onClickApproveButton(ActionEvent event) {
        head.approvePromotionList(true);
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
