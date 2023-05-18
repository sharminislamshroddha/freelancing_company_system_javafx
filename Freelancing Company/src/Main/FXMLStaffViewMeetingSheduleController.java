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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLStaffViewMeetingSheduleController implements Initializable {

    @FXML
    private TableColumn<MeetingSchedule, String> meetingNoCol;
    @FXML
    private TableColumn<MeetingSchedule, LocalDate> dateCol;
    @FXML
    private TableColumn<MeetingSchedule, String> timeCol;
    @FXML
    private TableColumn<MeetingSchedule, String> topicCol;
    @FXML
    private TableColumn<MeetingSchedule, String> roomNoCol;
    @FXML
    private TableColumn<MeetingSchedule, String> aboutCol;
    @FXML
    private TableView<MeetingSchedule> tableView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         meetingNoCol.setCellValueFactory(new PropertyValueFactory<MeetingSchedule, String>("meetingNo"));
        dateCol.setCellValueFactory(new PropertyValueFactory<MeetingSchedule, LocalDate>("date"));
         timeCol.setCellValueFactory(new PropertyValueFactory<MeetingSchedule, String>("time"));
        topicCol.setCellValueFactory(new PropertyValueFactory<MeetingSchedule, String>("topic"));
         roomNoCol.setCellValueFactory(new PropertyValueFactory<MeetingSchedule, String>("meetingRoomNo"));
        aboutCol.setCellValueFactory(new PropertyValueFactory<MeetingSchedule, String>("abouTheMeeting"));
        
        ArrayList<MeetingSchedule>mList = MeetingSchedule.listOfMeeting();
        if(mList != null){
            for(MeetingSchedule i: mList){
                    System.out.println(i.toString());
                    tableView.getItems().add(i);
      
          
            }
        }
    }    

    @FXML
    private void onCLickHomeSceneButton(ActionEvent event) throws IOException {
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
