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
public class Truck extends Factory {

    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {//to avoid more than 1 thread to access these block of code
                if (CansNumber >= 3240&& TrunkBoxNumber>=20) {
                    
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    TrunkBoxNumber = TrunkBoxNumber - 20;
                    System.out.println("Truck removed 20 cartons of goods");
                   
                } else {
                    try {
                        Thread.sleep(10);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
