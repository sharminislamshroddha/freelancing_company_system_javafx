package Main;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class User implements Serializable{
    protected String name,user_type,email,password;
    protected LocalDate BoD;
    protected int id;
    
    public User(String name, int id, String user_type, String email, String password, LocalDate BoD){
       this.id = id;
       this.name = name;
       this.user_type = user_type;
       this.email = email;
       this.password = password;
       this.BoD = BoD;                
    }
    
    public abstract void addUser();

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", user_type=" + user_type + ", email=" + email + ", password=" + password + ", BoD=" + BoD + ", id=" + id + '}';
    }
    
    public static User login(int ID, String pass, String type){
        ArrayList<User>uList = UserList.listOfUser();
        for(User i: uList){
            if(i.getId()==ID && i.getUser_type().equals(type) && i.getPassword().equals(pass)){
                return i;
            }
        }
        return null;
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
