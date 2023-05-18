/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
public class FXMLCustomerGiveSuggestionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Customer c =null;
    @FXML
    private TextArea suggestion;
    @FXML
    private TextField cusID;
    @FXML
    private DatePicker date;
    
    void initData(User customer) {
        c = (Customer)customer;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cusID.setText(String.valueOf(c.getId()));
        date.setValue(LocalDate.now());
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

    @FXML
    private void onClickSubmitButton(ActionEvent event) {
        Suggestion s = new Suggestion(
                Integer.parseInt(cusID.getText()),
                date.getValue(),
                suggestion.getText()
        );
        s.addSuggestion();
    }
}
