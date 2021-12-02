/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples.adapter;

import java.util.*;
import samples.Coke;
import samples.Drinks;

/**
 *
 * @author jinhern
 */
public class DrinksAdapter {
    
    public static List<Drinks> getDrinks(){
        Drinks drinksAll = new Drinks();
        List<String> drks = drinksAll.getAll();
        
        //temp collection
        List<Drinks> temp = new ArrayList();
        
        for (String line : drks) {
            String[] split = line.split("\\|");
            Drinks newDrinks = new Drinks();
            newDrinks.setId( Integer.parseInt(split[0]) );
            newDrinks.setName( split[1] ); // split[2],[3]
            temp.add(newDrinks);
        }
        return temp;
    }
    
    public static List<Coke> getCoke(){
        Coke cokeAll = new Coke();
        List<String> drks = cokeAll.getAll();
        
        //temp collection
        List<Coke> temp = new ArrayList();
        
        for (String line : drks) {
            String[] split = line.split("\\|");
            Coke newCoke = new Coke();
            newCoke.setId( Integer.parseInt(split[0]) );
            newCoke.setName( split[1] ); // split[2],[3]
            newCoke.setSlogan(split[4]);
            temp.add(newCoke);
        }
        return temp;
    }
    
}
