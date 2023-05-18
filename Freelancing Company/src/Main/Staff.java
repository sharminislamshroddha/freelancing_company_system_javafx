package Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Staff extends Employee implements Serializable{
    
    public Staff(String name, int id, String user_type, String email, String password, LocalDate BoD, float salary, String department, float workHour, LocalDate appointmentDate, String post) {
        super(name, id, user_type, email, password, BoD, salary, department, workHour, appointmentDate, post);
    }
    
    public String viewMeetingSchedule(){
        
        return "";
    }
    public void communicateWithManager(int toID, String message){
        
    }
    public String viewThePromotionList(){
        return "";
    }
    public void sendCustomerMsg(int toID, String message){
        
    }
    public String viewCustomerMsg(int toID){
        return "";
    }
    public String viewTheAssignTask(){
        return "";
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

    public float getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public float getWorkHour() {
        return workHour;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public String getPost() {
        return post;
    }

    public String getName() {
        return name;
    }

    public String getUser_type() {
        return user_type;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBoD() {
        return BoD;
    }

    public int getId() {
        return id;
    }
    
    

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
