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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXMLCreateCustomerController implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private ComboBox userTypeField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passField;
    @FXML
    private TextArea outputTextArea;
    @FXML
    private DatePicker dateField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userTypeField.getItems().add("Select");
        userTypeField.getItems().addAll("Customer","Head","Manager","Administrator","Staff","Candidate");
        userTypeField.setValue("Customer");           
    }    
    
    @FXML
    private void clickOnReadButton(ActionEvent event) {
        outputTextArea.setText("");
        
        ArrayList<User>u = UserList.listOfUser();
        if(u != null){
            for(User i: u){
                System.out.println(u.toString());
                outputTextArea.appendText(i.toString());
            }
        }
        outputTextArea.appendText("All objects are loaded successfully...\n");
    }

    @FXML
    private void clickOnSubmitButton(ActionEvent event) {
        Customer c = new Customer(
            nameField.getText(),
            Integer.parseInt(idField.getText()),
            userTypeField.getValue().toString(),
            emailField.getText(),
            passField.getText(),
            dateField.getValue()
        );
        c.addUser();
        nameField.setText("Enter Name");
        idField.setText("Enter ID");
        emailField.setText("Enter Email");
        passField.setText("Enter Password");
        userTypeField.setValue("Customer");
        dateField.setValue(null);
    }

    @FXML
    private void idTextOnMouseClicked(MouseEvent event) {
        idField.setText(null);
    }

    @FXML
    private void nameTextOnMouseClicked(MouseEvent event) {
        nameField.setText(null);
    }

    @FXML
    private void emailTextOnMouseClicked(MouseEvent event) {
        emailField.setText(null);
    }

    @FXML
    private void passwordTextOnMouseClicked(MouseEvent event) {
        passField.setText(null);
    }

    @FXML
    private void onClickHomeScene(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLAdministratorHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
    
}
