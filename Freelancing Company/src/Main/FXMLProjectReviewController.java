package Main;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TextArea;


public class FXMLProjectReviewController implements Initializable {

    @FXML
    private TextField taskField;
    @FXML
    private ComboBox satisfactionCombo;
    @FXML
    private ComboBox onTimeCombo;
    @FXML
    private TextArea commentField;
    @FXML
    private ComboBox behaviorRatingCombo;
    @FXML
    private ComboBox projectRatingCombo;
    @FXML
    private TextArea viewTaskField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        viewTaskField.setText("");
        
        int custID = 123;
        ArrayList<TakenTask>t = TakenTask.listOfTakenTask();
        for(TakenTask i: t){
            if(i.getCustomerID() == custID && i.isIsComplete()== true){
                viewTaskField.appendText(t.toString());
            }
        }
        viewTaskField.appendText("All completed task information are loaded successfully...\n");
        
    }
    
    @FXML
    private void clickOnSubmitButton(ActionEvent event) {
        ArrayList<TakenTask> t = TakenTask.listOfTakenTask();
        int taskNo = Integer.parseInt(taskField.getText());
        int customerID=0, staffID =0;
        boolean flag = false;
        for(TakenTask i: t){
            if(i.getTaskNo() == taskNo){
                flag = true;
                customerID = i.getCustomerID();
                staffID = i.getStaffID();
            }
        }
        if(flag == true){
            ProjectReview p = new ProjectReview(
                Integer.parseInt(onTimeCombo.getValue().toString()),
                Integer.parseInt(projectRatingCombo.getValue().toString()),
                Integer.parseInt(behaviorRatingCombo.getValue().toString()),
                Integer.parseInt(satisfactionCombo.getValue().toString()),
                customerID, staffID,
                Integer.parseInt(taskField.getText()),
                commentField.getText()
            );
            p.addProjectReview();
        }
    }
    
}
