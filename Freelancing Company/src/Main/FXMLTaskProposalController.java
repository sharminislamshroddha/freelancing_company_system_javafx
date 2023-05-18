package Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLTaskProposalController implements Initializable {

    @FXML
    private TextField taskIDField;
    @FXML
    private TextField customerIDNo;
    @FXML
    private TextField taskTitle;
    @FXML
    private TextArea aboutField;
    @FXML
    private DatePicker dateField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void clickOnSubmitButton(ActionEvent event) {
        TaskProposal c = new TaskProposal(
            Integer.parseInt(taskIDField.getText()),
            Integer.parseInt(customerIDNo.getText()),
            taskTitle.getText(),
            aboutField.getText(),
            dateField.getValue()
        );
        c.addTaskProposal();
        customerIDNo.setText("");
        taskIDField.setText("");
        taskTitle.setText("");
        aboutField.setText("");
        dateField.setValue(null);
        
        ArrayList<TaskProposal>t = TaskProposal.listOfTaskProposal();
        for(TaskProposal i: t){
            System.out.println(i.toString());
        }
        
        
    }
    
}
