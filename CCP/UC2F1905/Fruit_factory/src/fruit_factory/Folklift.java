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
public class Folklift extends Factory {
    private Object obj = new Object();
    
    @Override
    public void run(){
        while(true){
            synchronized(obj){
                if(WaitingAreaBoxNumber>0){
                    WaitingAreaBoxNumber--;
                    try{
                        Thread.sleep(10);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() +" Transported a box");
                    
                    TrunkBoxNumber++;
                    System.out.println("box in Truck number"+TrunkBoxNumber);
                } else {
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
