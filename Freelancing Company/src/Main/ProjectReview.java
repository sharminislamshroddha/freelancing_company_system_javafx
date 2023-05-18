package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectReview {
    private int onTimeRating;
    private int projectRating;
    private int behaviorRating;
    private int satisfactionRating;
    private int customerID;
    private int staffID;
    private int taskNo;
    private String comment;

    
    public ProjectReview(int onTimeRating, int projectRating, int behaviorRating, int satisfactionRating, int customerID, int staffID, int taskNo, String comment) {
        this.onTimeRating = onTimeRating;
        this.projectRating = projectRating;
        this.behaviorRating = behaviorRating;
        this.satisfactionRating = satisfactionRating;
        this.customerID = customerID;
        this.staffID = staffID; // auto from taskNo
        this.taskNo = taskNo;
        this.comment = comment;
    }
    
    public void addProjectReview() {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("Project Review.bin");
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
    
     public static ArrayList<ProjectReview> listOfProjectReview(){
        ArrayList<ProjectReview>uList = new ArrayList<>();
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("Project Review.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ProjectReview u;
            try{
                while(true){
                    u = (ProjectReview)ois.readObject();
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

    @Override
    public String toString() {
        return "onTimeRating=" + onTimeRating + ", projectRating=" + projectRating + ", behaviorRating=" + behaviorRating + ", "
                + "satisfactionRating=" + satisfactionRating + ", customerID=" + customerID + ", staffID=" + staffID 
                + ", taskNo=" + taskNo + ", comment=" + comment + '}';
    }
    
    public static float avgProjectRating(int staffID){
        return 0;
    }
    public static float avgOnTime(int staffID){
        return 0;
    }
    public static float avgSatisfactionRating(int  staffID){
        return 0;
    }
    public static float avgProjectRating(){
        return 0;
    }
    public static float avgOnTime(){
        return 0;
    }
    public static float avgSatisfactionRating(){
        return 0;
    }

    public int getOnTimeRating() {
        return onTimeRating;
    }

    public int getProjectRating() {
        return projectRating;
    }

    public int getBehaviorRating() {
        return behaviorRating;
    }

    public int getSatisfactionRating() {
        return satisfactionRating;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getStaffID() {
        return staffID;
    }

    public int getTaskNo() {
        return taskNo;
    }

    public String getComment() {
        return comment;
    }
    
}
