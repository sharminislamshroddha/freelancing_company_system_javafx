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

public class Message implements Serializable{
    private int toID;
    private int fromID;
    private LocalDate date;
    private String body, subject;

    public Message(int toID, int fromID, LocalDate date, String body, String subject) {
        this.toID = toID;
        this.fromID = fromID;
        this.date = date;
        this.body = body;
        this.subject = subject;
    }
    
    public void addMessage(){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("Message.bin");
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
    
    public static ArrayList<Message> listOfMessage(){
        ArrayList<Message>uList = new ArrayList<>();
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("Message.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Message u;
            try{
                while(true){
                    u = (Message)ois.readObject();
                    uList.add(u);
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
        return uList;
    
    }

    public int getToID() {
        return toID;
    }

    public int getFromID() {
        return fromID;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getBody() {
        return body;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "From ID: " + fromID + "\nDate: " + date + "\nSubject:" + subject + "\nBody: " + 
                body + "\n\n";
    }
    
}
