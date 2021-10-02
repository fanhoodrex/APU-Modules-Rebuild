 package Course;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class tool {
    
    /*
    (Pankaj, 2013)
    https://www.journaldev.com/878/java-write-to-file
    */
    public void write(String filename,String content, boolean contin, boolean enter){
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename +".txt",contin);
            if(enter){
                writer.write(content+"\r\n");
            }else{
                writer.write(content);
            }
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(tool.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /*
    (geeksforgeeks, 2018)
    https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
    */
    public List<String> read(String filename){
        List<String> result = new ArrayList<String>();
        try {
            File myObj = new File(filename+".txt"); 
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                result.add(myReader.nextLine().toString());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(tool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    /*
    (stackoverflow, 2017)
    https://stackoverflow.com/questions/1377279/find-a-line-in-a-file-and-remove-it
    */
    public void del (String id, String filename) {
    List<String> l = this.read(filename);
    //System.out.println(l);
    this.write(filename, "", false,false);
     
    for(int i=0;i<l.size();i++){
        String[] s = l.get(i).split("\t");
        if(s[0].equals(id)){
            continue;
        }else{
            this.write(filename, l.get(i), true,true);
        }
    }
    JOptionPane.showMessageDialog(null, "Success Delete");
    }

    
    public void cha (String id, String filename) {
    List<String> l = this.read(filename);
    //System.out.println(l);
    this.write(filename, "", false,false);
     
    for(int i=0;i<l.size();i++){
        String[] s = l.get(i).split("\t");
        if(s[0].equals(id)){
            continue;
        }else{
            this.write(filename, l.get(i), true,true);
        }
    }
    JOptionPane.showMessageDialog(null, "Please enter new course information");
    }
   
    public static void main(String args[]){
        tool t = new tool();


        
    }
}
