package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MeetingSchedule implements Serializable{
    private String time,topic,meetingRoomNo,aboutTheMeeting;
    private LocalDate date;
    private int meetingNo;

    public MeetingSchedule(LocalDate date, String time, String topic, String meetingRoomNo, String aboutTheMeeting, int meetingNo) {
        this.date = date;
        this.time = time;
        this.topic = topic;
        this.meetingRoomNo = meetingRoomNo;
        this.aboutTheMeeting = aboutTheMeeting;
        this.meetingNo = meetingNo;
    }
    
    public void addMeetingSchedule() {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("Meeting Schedule.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(this);

        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String toString() {
        return "Meeting No: " + meetingNo +"\nDate: " + date+"\nTime: " + time + "\nMeeting Room No: " + meetingRoomNo +"\nTopic=" + topic +
                 "/nAbout The Meeting: " + aboutTheMeeting + "\n";
    }
    
    public static ArrayList<MeetingSchedule> listOfMeeting(){
        ArrayList<MeetingSchedule>mList = new ArrayList<>();
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("Meeting Schedule.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            MeetingSchedule m;
            try{
                while(true){
                    m = (MeetingSchedule)ois.readObject();
                    mList.add(m);
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch                 
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }    
        return mList;
    }
}
