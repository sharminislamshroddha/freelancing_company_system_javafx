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

public class WorkingProgress {
    private int staffID,numOfCompletedProject;
    private float onTimeRate, behaviorRating, workRating;

    public WorkingProgress(int staffID) {
        this.staffID = staffID;
        int comProject = 0;
        float onTimeRate = 0.0f;
        float behaviorRate = 0.0f;
        float workingRate = 0.0f;
        
        ArrayList<ProjectReview>uList = ProjectReview.listOfProjectReview();
        for(ProjectReview i: uList){
            if(i.getStaffID()==staffID){
                comProject++;
                onTimeRate = onTimeRate+i.getOnTimeRating();
                behaviorRate = behaviorRate+i.getBehaviorRating();
                workingRate = workingRate+i.getProjectRating();
            }
        }
        numOfCompletedProject = comProject;
        this.onTimeRate = onTimeRate/comProject;
        behaviorRating = behaviorRate/comProject;
        workRating = workingRate/comProject;
    }

    public void addWorkingProgress() {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("Working Progress.bin");
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
    
    public static ArrayList<WorkingProgress> listOfWorkingProgress(){
        ArrayList<WorkingProgress>uList = new ArrayList<>();
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("Working Progress.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
           WorkingProgress u;
            try{
                while(true){
                    u = (WorkingProgress)ois.readObject();
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
        return "Staff ID:" + staffID + "\nNumOfCompletedProject: " + numOfCompletedProject + "\nOn TimeRate: " + onTimeRate +
                "\nBehavior Rating: " + behaviorRating + "\nWorkRating: " + workRating + "\n\n";
    }
    
}
