package Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager extends Employee implements Serializable{
    
    public Manager(String name, int id, String user_type, String email, String password, LocalDate BoD, float salary, String department, float workHour, LocalDate appointmentDate, String post) {
        super(name, id, user_type, email, password, BoD, salary, department, workHour, appointmentDate, post);
    }

    public static void assignTaskToStaff(int staffID,int cusID, int taskNo){
        TakenTask t = new TakenTask(staffID,cusID,false,taskNo,"");
        t.addTaskenTask();
    }

    @Override
    public void addUser() {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("User.bin");
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
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
