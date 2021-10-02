/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author TP049606
 */
public class IOhelper {
    
    private FileWriter writer;
    
    private Scanner myReader;
    
    public IOhelper(){
    
    }
    
    public IOhelper(FileWriter writer){
        this.writer = writer;
    }
    
    public IOhelper(FileWriter writer, Scanner reader){
        this.writer = writer;
        this.myReader = reader;
    }
    
    public void initializeFile(String filename){
        try{
            writer = new FileWriter("src/database/"+filename+".txt",false);
            writer.write("");
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOhelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(IOhelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IOhelper.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public void write(String filename,String content,boolean continueWriting){
        try{
            writer = new FileWriter("src/database/"+filename+".txt",continueWriting);
            writer.write(content+"\r\n");
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOhelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(IOhelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IOhelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,"Successfully");
    }
    
    
    
    public List<String> read(String filename){
        List<String> result = new ArrayList<String>();
        try{
            File myObj = new File("src/database/"+filename+".txt");
            myReader = new Scanner(myObj); 
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                result.add(data);
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(IOhelper.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(IOhelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        myReader.close();
        return result;
    }   
}
