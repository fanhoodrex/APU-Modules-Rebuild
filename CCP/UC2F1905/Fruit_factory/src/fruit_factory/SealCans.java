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
public class SealCans extends Factory {

    @Override
    public void run() {
        while (true) {
            if (cans >= 12) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                seal = 12 * (cans / 12);
                cans = cans % 12;
                SealNumber += seal / 12;
                System.out.println("finished" + SealNumber + "seal");
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
