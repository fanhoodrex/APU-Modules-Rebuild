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
public class PutInBox extends Factory {
    @Override
    public void run(){
        while(true){
            if(seal>=6){
                bag+=seal/6;
                seal=seal%6;
                
                System.out.println("finished"+bag+"package");
                
                if(bag>=27){
                    box+=bag/27;
                    bag=bag%27;
                    System.out.println("finished"+box+"boxing");
                    WaitingAreaBoxNumber++;
                }
            }
        }
    }
}
