/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLViewMeetingScheduleHeadController implements Initializable {

    @FXML
    private TableView<MeetingSchedule> tableView;
    @FXML
    private TableColumn<MeetingSchedule, String> meetingNoCol;
    @FXML
    private TableColumn<MeetingSchedule, LocalDate> dateCol;
    @FXML
    private TableColumn<MeetingSchedule, String> timeCol;
    @FXML
    private TableColumn<MeetingSchedule, String> topicCol;
    @FXML
    private TableColumn<MeetingSchedule, String> roomCol;
    @FXML
    private TableColumn<MeetingSchedule, String> aboutCol;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        meetingNoCol.setCellValueFactory(new PropertyValueFactory<MeetingSchedule,String>("meetingNo"));
        dateCol.setCellValueFactory(new PropertyValueFactory<MeetingSchedule,LocalDate>("date"));
        timeCol.setCellValueFactory(new PropertyValueFactory<MeetingSchedule,String>("time"));
        topicCol.setCellValueFactory(new PropertyValueFactory<MeetingSchedule,String>("topic"));
        roomCol.setCellValueFactory(new PropertyValueFactory<MeetingSchedule,String>("meetingRoomNo"));
        aboutCol.setCellValueFactory(new PropertyValueFactory<MeetingSchedule,String>("aboutTheMeeting"));
        
        ArrayList<MeetingSchedule>pList = MeetingSchedule.listOfMeeting();
        for(MeetingSchedule i: pList){
            tableView.getItems().add(i);
            System.out.println(i.toString());
        }
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
