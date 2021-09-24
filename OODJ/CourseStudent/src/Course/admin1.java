package Course;

import com.sun.istack.internal.logging.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LLB
 */
public class admin1 {
    
    private String username;
    private String password;

    public admin1(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public admin1() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /*
    (stackoverflow, 2013)
    https://stackoverflow.com/questions/15754523/how-to-write-text-file-java
    */
public void login (String username, String password) {
    boolean testing = false;
    File file = new File("login.txt");
    InputStreamReader read = null;
    
    try{
        read = new InputStreamReader(new FileInputStream(file));
        BufferedReader in = new BufferedReader(read);
        String line = null;
        
        while ((line = in.readLine()) != null){
            String[] temp = line.split("\t");
            
            if (temp[3].equals(username) && (temp[4].equals(password))){
                testing = true;
                login_page lg = new login_page();
                lg.setVisible(true);
                
            }   
        }
    }catch (IOException ex) {
        
    }
    if(!testing){
        JOptionPane.showMessageDialog(null,"Please cheack your Username or Password", "Invaild Login Details",JOptionPane.ERROR_MESSAGE);
        admin ad = new admin();
        ad.setVisible(true);
    }
}
    
}
