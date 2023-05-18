package Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class RemarkableWork implements Serializable{
    private String clientName,projectName,aboutTheProject,shortReview;

    public RemarkableWork(String clientName, String projectName, String aboutTheProject, String shortReview) {
        this.clientName = clientName;
        this.projectName = projectName;
        this.aboutTheProject = aboutTheProject;
        this.shortReview = shortReview;
    }
    
    public void addRemarkableWork() {
        File f = null;
        FileWriter fw = null;
        try {
            f = new File("Remarkable Work.txt");
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
                clientName+","+projectName+","+aboutTheProject+","+shortReview+"\n"
            );           
  
        } catch (IOException ex) {
            //Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                //Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getClientName() {
        return clientName;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getAboutTheProject() {
        return aboutTheProject;
    }

    public String getShortReview() {
        return shortReview;
    }
    
    
}