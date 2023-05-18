package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;

public class TaskProposal implements Serializable{
    private int taskNo,customerID;
    private String title,about;
    private LocalDate dueDate;

    public TaskProposal(int taskNo, int customerID, String title, String about, LocalDate dueDate) {
        this.taskNo = taskNo;
        this.customerID = customerID;
        this.title = title;
        this.about = about;
        this.dueDate = dueDate;
    }
    
    public void addTaskProposal() {
        File f = null;
        FileOutputStream fos = null;      
        java.io.ObjectOutputStream oos = null;
        
        try {
            f = new File("Task Proposal.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new java.io.ObjectOutputStream(fos);               
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
    
    public static ArrayList<TaskProposal> listOfTaskProposal(){
        ArrayList<TaskProposal>uList = new ArrayList<>();
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("Task Proposal.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            TaskProposal u;
            try{
                while(true){
                    u = (TaskProposal)ois.readObject();
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

    public String display() {
        return  "Task No: " + taskNo + "\nCustomer ID: " + customerID + "\nTitle: " + title 
                + "\nAbout: " + about + "\nDue Date: " + dueDate +"\n\n";
    }

    @Override
    public String toString() {
        return "TaskProposal{" + "taskNo=" + taskNo + ", customerID=" + customerID + ", title=" + title + ", about=" + about + ", dueDate=" + dueDate + '}';
    }

    public void setTaskNo(int taskNo) {
        this.taskNo = taskNo;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    
    

    public int getTaskNo() {
        return taskNo;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getTitle() {
        return title;
    }

    public String getAbout() {
        return about;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
    
    
    
    public TaskProposal foundTask(int taskNo){
        return null;
    } 
    
    public static String taskUpdate(){
        return "";
    }
    
    public static String taskProposal(){
        return "";
    }

    private static class ObjectOutputStream {

        public ObjectOutputStream() {
        }
    }
}
