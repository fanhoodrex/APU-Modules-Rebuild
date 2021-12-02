/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

/**
 *
 * @author jinhern
 */
public class ReadWriteLinkedListObject {
    
    private static final String CHAIN_OBJFILE = "master/chainobj.dat";
    
    public static void main(String[] args) {
        
        LinkedList<String> lst = new LinkedList();
        lst.add("abc");
        lst.add("efg");
        System.out.println("--- Write Object ---");
        tst1( lst );
        System.out.println( lst );
        System.out.println("--- Read Object ---");
        LinkedList<String> newLst = tst2();
        System.out.println( newLst );
        System.out.println("--- Add new entry ---");
        newLst.add("xyz");
        System.out.println( newLst );
        
        
    }
    
    static void tst1( LinkedList<String> chain ){
        
        try(FileOutputStream fos = new FileOutputStream( CHAIN_OBJFILE );
                ObjectOutputStream out = new ObjectOutputStream( fos ) 
                ) {
            out.writeObject( chain );
        } catch (Exception e) {
        }
        
    }
    
    static LinkedList<String> tst2(){
        
        try(FileInputStream fis = new FileInputStream( CHAIN_OBJFILE );
                ObjectInputStream in = new ObjectInputStream( fis )) {
            return (LinkedList<String>)in.readObject();
        } catch (Exception e) {
            return null;
        }
        
    }
    
}
