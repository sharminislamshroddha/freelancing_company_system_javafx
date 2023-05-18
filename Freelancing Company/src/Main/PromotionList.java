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

public class PromotionList {
    private int empID;
    private String suggestedPost;
    private String reasonOfPromotion;
    private String status,empName;

    public PromotionList(int empID, String suggestedPost, String reasonOfPromotion, String status, String name) {
        this.empID = empID;
        this.suggestedPost = suggestedPost;
        this.reasonOfPromotion = reasonOfPromotion;
        this.status = status;
        empName = name;
    }
    
    public void addPromotionList() {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("Promotion List.bin");
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
    
    public static ArrayList<PromotionList> getPromotionList(){
        ArrayList<PromotionList>uList = new ArrayList<>();
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("Promotion List.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            PromotionList u;
            try{
                while(true){
                    u = (PromotionList)ois.readObject();
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
    
    public static void editPromotionList(int empID, String newStatus){
        
    }
    public static void addEmployeeInList(int empID){
        
    }
}
