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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLCreateEmployeeController implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passField;
    @FXML
    private TextArea outputTextArea;
    @FXML
    private TextField salaryField;
    @FXML
    private TextField departmentField;
    @FXML
    private TextField workHourField;
    @FXML
    private TextField postField;
    @FXML
    private DatePicker appointField;
    @FXML
    private DatePicker birthDateField;
    @FXML
    private ComboBox userTypeField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userTypeField.getItems().add("Select");
        userTypeField.getItems().addAll("Head","Manager","Administrator","Staff","Candidate");
        userTypeField.setValue("Select");
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
        if(userTypeField.getValue().toString() == "Head"){
            Head h = new Head(
                nameField.getText(),
                Integer.parseInt(idField.getText()),
                userTypeField.getValue().toString(),
                emailField.getText(),
                passField.getText(),
                birthDateField.getValue(),
                Float.parseFloat(salaryField.getText()),
                departmentField.getText(),
                Integer.parseInt(workHourField.getText()),
                appointField.getValue(),
                postField.getText()
            );
            h.addUser();
        }
        else if(userTypeField.getValue().toString() == "Manager"){
            Manager h = new Manager(
                nameField.getText(),
                Integer.parseInt(idField.getText()),
                userTypeField.getValue().toString(),
                emailField.getText(),
                passField.getText(),
                birthDateField.getValue(),
                Float.parseFloat(salaryField.getText()),
                departmentField.getText(),
                Integer.parseInt(workHourField.getText()),
                appointField.getValue(),
                postField.getText()
            );
            h.addUser();
        }
        else if(userTypeField.getValue().toString() == "Staff"){
            Staff h = new Staff(
                nameField.getText(),
                Integer.parseInt(idField.getText()),
                userTypeField.getValue().toString(),
                emailField.getText(),
                passField.getText(),
                birthDateField.getValue(),
                Float.parseFloat(salaryField.getText()),
                departmentField.getText(),
                Integer.parseInt(workHourField.getText()),
                appointField.getValue(),
                postField.getText()
            );
            h.addUser();
        }
        else if(userTypeField.getValue().toString() == "Administrator"){
            Administrator h = new Administrator(
                nameField.getText(),
                Integer.parseInt(idField.getText()),
                userTypeField.getValue().toString(),
                emailField.getText(),
                passField.getText(),
                birthDateField.getValue(),
                Float.parseFloat(salaryField.getText()),
                departmentField.getText(),
                Integer.parseInt(workHourField.getText()),
                appointField.getValue(),
                postField.getText()
            );
            h.addUser();
        }
        nameField.setText("Enter Name");
        idField.setText("Enter ID");
        emailField.setText("Enter Email");
        passField.setText("Enter Password");
        salaryField.setText("Enter Salary");
        workHourField.setText("Enter Working Hour");
        departmentField.setText("Enter Department");
        appointField.setValue(null);
        userTypeField.setValue("Select");
        postField.setText("Enter Post");
    }

    @FXML
    private void idTextOnMouseClick(MouseEvent event) {
        idField.setText(null);
    }

    @FXML
    private void nameTextOnMouseClick(MouseEvent event) {
        nameField.setText(null);
    }

    @FXML
    private void emailTextOnMouseClick(MouseEvent event) {
        emailField.setText(null);
    }

    @FXML
    private void passTextOnMouseClick(MouseEvent event) {
        passField.setText(null);
    }

    @FXML
    private void salaryTextOnMouseClick(MouseEvent event) {
        salaryField.setText(null);
    }

    @FXML
    private void deptTextOnMouseClick(MouseEvent event) {
        departmentField.setText(null);
    }

    @FXML
    private void workHTextOnMouseClick(MouseEvent event) {
        workHourField.setText(null);
    }

    @FXML
    private void postTextOnMouseClick(MouseEvent event) {
        postField.setText(null);
    }

    @FXML
    private void onClickHomeSceneButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLAdministratorHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
    
}
