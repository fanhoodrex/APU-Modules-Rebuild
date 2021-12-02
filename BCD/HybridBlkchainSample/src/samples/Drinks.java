/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jinhern
 */
public class Drinks {
 
    private final String FILENAME = "data/drinks.txt";
    
    protected int id;
    protected String name;
    protected String quantity;
    protected String supplier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    public List<String> getAll(){
        List<String> lst = null;
        try {
            lst = Files.readAllLines(Paths.get(FILENAME));
        } catch (IOException ex) {
            Logger.getLogger(Drinks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
    
    public static void main(String[] args) {
        System.out.println( new Drinks().getAll() );
    }
    
}
