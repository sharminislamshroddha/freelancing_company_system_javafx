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

public class Head extends Employee implements Serializable{
    
    public Head(String name, int id, String user_type, String email, String password, LocalDate BoD, float salary, String department, float workHour, LocalDate appointmentDate, String post) {
        super(name, id, user_type, email, password, BoD, salary, department, workHour, appointmentDate, post);
    }
    
    public void approvePromotionList(boolean flag){
        ArrayList<User>uList = UserList.listOfUser();
        if(flag == true){
            int managerID = 0;
            for(User i: uList){
                if(i.getUser_type().equals("Manager")){
                    managerID = i.getId();
                }
            }
            Message m = new Message(managerID, id, LocalDate.now(), "Promotion List has approved!", "Promotion List Status");
            m.addMessage();
        }
        else{
            int managerID = 0;
            for(User i: uList){
                if(i.getUser_type().equals("Manager")){
                    managerID = i.getId();
                }
            }
            Message m = new Message(managerID,id, LocalDate.now(), "Promotion List has disapproved!", "Promotion List Status");
            m.addMessage();
        }
    }
    
    public void approveCandidateJobList(boolean flag){
        ArrayList<User>uList = UserList.listOfUser();
        if(flag == true){
            int managerID = 0;
            for(User i: uList){
                if(i.getUser_type().equals("Manager")){
                    managerID = i.getId();
                }
            }
            Message m = new Message(managerID, id, LocalDate.now(), "Candidate job List has approved!", "Job List Status");
            m.addMessage();
        }
        else{
            int managerID = 0;
            for(User i: uList){
                if(i.getUser_type().equals("Manager")){
                    managerID = i.getId();
                }
            }
            Message m = new Message(managerID,id, LocalDate.now(), "Candidate job List has disapproved!", "Job List Status");
            m.addMessage();
        }
    }
    
    public void approveJobList(){
        
    }
    public String viewMeetingSchedule(){
        
        return "";
    }
    public void viewTaskUpdate(int taskNo){
        
    }
    public String showFeedback(){
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

    @Override
    public String toString() {
        return "Employee{Name: " + name +  "\nID: " + id + "\nUser type: " + user_type + "\nPassword=" + password 
                + "\nEmail: " + email + "\nBirth of Date: " + BoD + "\n" + "Salary: " + salary + "\nDepartment=" + department +
                "\nWorkHour=" + workHour + "\nAppointmentDate=" + appointmentDate + "\nPost=" + post + "\n";
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

    
    
}
