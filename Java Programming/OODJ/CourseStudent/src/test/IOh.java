package test;

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
 * @author Administrator
 */
public class IOh {
    
    public void write(String filename,String content,boolean contin,boolean enter){
        FileWriter f = null;
        try{
            f = new FileWriter("src/database/"+filename+".txt",contin);
            if(enter){
                f.write(content);
                f.write("\r\n");
            }else{
                f.write(content);
            }
            f.close();
        }    
        catch(IOException ex){
            Logger.getLogger(IOh.class.getName()).log(Level.SEVERE,null,ex);
        }
        JOptionPane.showMessageDialog(null, "File Written Successfully");
    }
    
    public List<String> read(String filename){
        List<String> result = new ArrayList<String>();
        try {
            File myObj = new File("src/database/"+filename+".txt"); 
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                result.add(myReader.nextLine().toString());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public void del(String id,String filename){
    List<String> l = this.read(filename);
    //System.out.println(l);
    this.write(filename,"",false,false);
    
    for(int i=0 ;i<l.size();i++){
        String[]s = l.get(i).split("/");
        if(s[0].equals(id)){
            continue;
        }
        else{
            this.write(filename, l.get(i), true, true);
        }
    }   
    JOptionPane.showMessageDialog(null,"Success Delete");
    }
    
    public void modify(String id,String filename,String content){
    List<String> l = this.read(filename);
    //System.out.println(l);
    this.write(filename,"",false,false);
    
    for(int i=0 ;i<l.size();i++){
        String[] s = l.get(i).split("/");
        if(s[1].equals(id)){
            this.write(filename, content, true, true);
        }
        else{
            this.write(filename, l.get(i), true, true);
        }
    }   
   
    }
 
    public void cha (String id, String filename) {
    List<String> l = this.read(filename);
    //System.out.println(l);
    this.write(filename, "", false,false);
    
    for(int i=0;i<l.size();i++){
        String[] s = l.get(i).split("/");
        if(s[0].equals(id)){
            continue;
        }else{
            this.write(filename, l.get(i), true,true);
        }
    }
    //JOptionPane.showMessageDialog(null, "Please enter new course information");
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
