package Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Candidate extends User implements Serializable{
    private boolean status;

    public Candidate(boolean status, String name, int id, String user_type, String email, String password, LocalDate BoD) {
        super(name, id, user_type, email, password, BoD);
        this.status = status;
    }
    
    public void setCanStatus(boolean st){
        status = st;
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
        return "Name: " + name +  "\nID: " + id + "\nUser type: " + user_type + "\nPassword=" + password 
                + "\nEmail: " + email + "\nBirth of Date: " + BoD + "\n" + "Working Hour: " +"\nStatus: "+ status + "\n";
    }

    public boolean isStatus() {
        return status;
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
