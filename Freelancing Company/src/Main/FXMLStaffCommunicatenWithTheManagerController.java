/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLStaffCommunicatenWithTheManagerController implements Initializable {

    @FXML
    private TextField fromID;
    @FXML
    private TextField toID;
    @FXML
    private DatePicker date;
    @FXML
    private TextField subject;
    @FXML
    private TextArea msgBody;
    @FXML
    private TextArea managerMsg;
    
    Staff c = null;
    void initData(User u) {
        c = (Staff)u;
    }
    
    int managerID = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<User>mList = UserList.listOfUser();
        for(User n: mList){
            if(n.getUser_type().equals("Manager")){
                managerID = n.getId();
            }
        }
        managerMsg.setText("");
        ArrayList<Message>uList = Message.listOfMessage();
        for(Message m: uList){
            if(m.getFromID() == managerID){
                managerMsg.appendText(m.toString());
            }
        }
        toID.setText(Integer.toString(managerID));
        fromID.setText(Integer.toString(c.getId()));
        date.setValue(LocalDate.now());
    }    

    @FXML
    private void onClickSubmitButton(ActionEvent event) {
         Message m = new Message(
            Integer.parseInt(toID.getText()),
                Integer.parseInt(fromID.getText()),
                date.getValue(),
                msgBody.getText(),
                subject.getText()
        );
        m.addMessage();
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
