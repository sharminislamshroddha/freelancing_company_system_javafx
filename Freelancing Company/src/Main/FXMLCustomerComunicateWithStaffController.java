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
public class FXMLCustomerComunicateWithStaffController implements Initializable {

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
    
    Customer c = null;
    @FXML
    private TextArea staffMsg;
    void initData1(User customer) {
        c = (Customer)customer;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        staffMsg.setText("");
        ArrayList<User>mList = UserList.listOfUser();
        ArrayList<Message>uList = Message.listOfMessage();
        
        for(User n: mList){
            if(n instanceof Staff){
                for(Message m: uList){
                    if(m.getFromID() == n.getId()){
                        staffMsg.appendText(m.toString());
                    }
                }
            }
            
        }
        
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
        FXMLLoader loader3 = new FXMLLoader();
                loader3.setLocation(getClass().getResource("FXMLCustomerHomeScene.fxml"));
                Parent homeScene3 = loader3.load();
                Scene homepage3 = new Scene(homeScene3);
                Stage window3 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window3.setScene(homepage3);
                window3.show();
    }

    
    
}
