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
public class ProduceCans extends Factory {
    @Override
    public void run(){
        while(true){
            cans++;
            CansNumber++;
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Produced"+CansNumber+"can");
        }
    }
    
}
