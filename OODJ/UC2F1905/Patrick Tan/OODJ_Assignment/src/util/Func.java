/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileNotFoundException;
import static Classes.FileController.ReadLastLineOfTheFile;
import java.io.IOException;

/**
 *
 * @author Ken
 */
public class Func {
    public static String generateID(String target){ 
       try{
            String stdid = ReadLastLineOfTheFile(new File("DATA\\" + target + ".txt"));
            String[] SplitArray = stdid.split("\\|");
            String sRole;
            switch (target){
                case "Lecturer":
                    sRole = "LECT";
                    break;
                case "Student":
                    sRole = "STD";
                    break;
                default:
                    sRole = null;
                    break;
            }
            int newid = Integer.parseInt(SplitArray[0].replace(sRole,"")) +1;
            //return sRole + String.valueOf(newid);
            return sRole + String.format("%04d", newid);
       }
       catch (FileNotFoundException FEX){
         return "File not found!";
       }
       catch (IOException E){
           return "Found file but fail to read!";
       }
    }
}
