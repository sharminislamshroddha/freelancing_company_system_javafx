package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;

public class TakenTask implements Serializable{
    private int staffID;
    private int customerID;
    private boolean isComplete;
    private int taskNo;
    private String taskUpdate;

    public TakenTask(int staffID,int customerID, boolean isComplete, int taskNo, String taskUpdate) {
        this.staffID = staffID;
        this.customerID = customerID;
        this.isComplete = isComplete;
        this.taskNo = taskNo;
        this.taskUpdate = taskUpdate;
    }
    
    public void addTaskenTask() {
        File f = null;
        FileOutputStream fos = null;      
        java.io.ObjectOutputStream oos = null;
        
        try {
            f = new File("Taken Task.bin");
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
    
    public static ArrayList<TakenTask> listOfTakenTask(){
        ArrayList<TakenTask>uList = new ArrayList<>();
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("Taken Task.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            TakenTask u;
            try{
                while(true){
                    u = (TakenTask)ois.readObject();
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
    
    public void setStaffID(int staffID){
        this.staffID = staffID;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public void setTaskNo(int taskNo) {
        this.taskNo = taskNo;
    }
    
    public static int numberOfCompletedTask(){
        
        return 0;
    }
    public static int getTotal_isCompletedTask(){
        
        return 0;
    }
    public static int totalTaskDoneByAStaff(int staffID){
        return 0;
    }
    public static String viewAssignTask(int staffID){
        return "";
    }    

    public int getStaffID() {
        return staffID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public boolean isIsComplete() {
        return isComplete;
    }

    public int getTaskNo() {
        return taskNo;
    }

    public String getTaskUpdate() {
        return taskUpdate;
    }

    @Override
    public String toString() {
        return "Task No:" + taskNo +"\nStaff ID: " + staffID + "\nCustomer ID: " + customerID + "\nisComplete: " + isComplete +  "\n\n";
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setTaskUpdate(String taskUpdate) {
        this.taskUpdate = taskUpdate;
    }
    
    
}
