/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blkchain.core;

import blkchain.demo.BlockchainTest;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jinhern
 */
public class Blockchain {

    private static final String CHAIN_OBJFILE = "master/chainobj.dat";

    public static void persist(LinkedList<Block> chain) {

        try (FileOutputStream fos = new FileOutputStream(CHAIN_OBJFILE);
                ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(chain);
        } catch (Exception e) {
        }

    }

    public static LinkedList<Block> get() {

        try (FileInputStream fis = new FileInputStream(CHAIN_OBJFILE);
                ObjectInputStream in = new ObjectInputStream(fis)) {
            return (LinkedList<Block>) in.readObject();
        } catch (Exception e) {
            return null;
        }

    }

    public static void distribute( String temp ){
        try {
            Files.write(Paths.get("bc.txt"), temp.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException ex) {
            Logger.getLogger(BlockchainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
