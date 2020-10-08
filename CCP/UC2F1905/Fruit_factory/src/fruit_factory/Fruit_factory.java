/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit_factory;

/**
 *
 * @author shasha
 */
public class Fruit_factory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProduceCans pc = new ProduceCans();
        SealCans sc = new SealCans();
        PutInBox pib = new PutInBox();
        Folklift fl1 = new Folklift();
        Folklift fl2 = new Folklift();
        Folklift fl3 = new Folklift();
        Truck tk1 = new Truck();
        Truck tk2 = new Truck();
        Truck tk3 = new Truck();



        
        Thread t1 = new Thread(pc);
        
        Thread t2 = new Thread(sc);
        
        Thread t3 = new Thread(pib);
        
        Thread t4 = new Thread(fl1,"Folklift 1");
        
        Thread t5 = new Thread(fl2,"Folklift 2");
        
        Thread t6 = new Thread(fl3,"Folklift 3");
        
        Thread t7 = new Thread(tk1,"Truck 1");
        
        Thread t8 = new Thread(tk2,"Truck 2");
        
        Thread t9 = new Thread(tk3,"Truck 3"); 

        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
    }
    
}
