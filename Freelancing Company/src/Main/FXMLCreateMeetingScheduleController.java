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

public class FXMLCreateMeetingScheduleController implements Initializable {

    @FXML
    private TextField meetingNo;
    @FXML
    private TextField meetingTime;
    @FXML
    private DatePicker meetingDate;
    @FXML
    private TextField roomNumber;
    @FXML
    private TextField topic;
    @FXML
    private TextArea about;
    @FXML
    private TextArea viewField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void clickOnSubmitButton(ActionEvent event) {
        MeetingSchedule c = new MeetingSchedule(
            meetingDate.getValue(),
            meetingTime.getText(),
            topic.getText(),
            roomNumber.getText(),
            about.getText(),
            Integer.parseInt(meetingNo.getText())
        );
        c.addMeetingSchedule();
        meetingDate.setValue(null);
        meetingTime.setText("");
        topic.setText("");
        roomNumber.setText("");
        about.setText("");
        meetingNo.setText("");
    }

    @FXML
    private void clickOnViewMeetingButton(ActionEvent event) {
        viewField.setText("");
        ArrayList<MeetingSchedule>m = new ArrayList<>();
        m = MeetingSchedule.listOfMeeting();
        if(m != null){
            for(MeetingSchedule i: m){
                viewField.appendText(i.toString());
            }
        }
        viewField.appendText("Completed!!!");
    }

    @FXML
    private void onClickHomeSceneButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLManagerHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXMLManagerHomeSceneController controller1 = loader1.getController();
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
    
}
