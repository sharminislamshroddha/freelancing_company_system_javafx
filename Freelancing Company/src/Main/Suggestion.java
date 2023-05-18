package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Suggestion {
    private int cusID;
    private LocalDate date;
    private String content;

    public Suggestion(int cusID, LocalDate date, String content) {
        this.cusID = cusID;
        this.date = date;
        this.content = content;
    }
    
    public void addSuggestion() {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("Suggestions From Customer.bin");
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
    public static ArrayList<Suggestion> listOfSuggestion(){
        ArrayList<Suggestion>uList = new ArrayList<>();
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("Project Review.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Suggestion u;
            try{
                while(true){
                    u = (Suggestion)ois.readObject();
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

    public int getCusID() {
        return cusID;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }
    
}
