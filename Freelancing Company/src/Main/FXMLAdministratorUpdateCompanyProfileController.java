/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLAdministratorUpdateCompanyProfileController implements Initializable {
    Administrator add = null;
    @FXML
    private TextField clientName;
    @FXML
    private TextField projectName;
    @FXML
    private TextField aboutTheProject;
    @FXML
    private TextField review;
     
    void initData(User administrator) {
        add = (Administrator)administrator;
     }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObjectInputStream ois=null;
         try {
             RemarkableWork s;
            ois = new ObjectInputStream(new FileInputStream("Remarkable Work.bin"));
            s = (RemarkableWork) ois.readObject();
            clientName.setText(s.getClientName());
            projectName.setText(s.getProjectName());
            aboutTheProject.setText(s.getAboutTheProject());
            review.setText(s.getShortReview());
            
        } catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        }    
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

    @FXML
    private void onClickUpdateButton(ActionEvent event) {
        RemarkableWork r = new RemarkableWork(
                clientName.getText(),
                projectName.getText(),
                aboutTheProject.getText(),
                review.getText()
            
        );
        r.addRemarkableWork();
    }

   
    
}
