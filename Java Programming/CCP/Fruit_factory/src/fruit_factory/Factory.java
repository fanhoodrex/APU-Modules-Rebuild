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
public class Factory implements Runnable{
   public volatile static int cans = 0;
    public volatile static int seal = 0;
     public volatile static int bag = 0;
      public volatile static int box = 0;
       public volatile static int CansNumber = 0;
        public volatile static int SealNumber = 0;
         public volatile static int WaitingAreaBoxNumber = 0;
          public volatile static int TrunkBoxNumber = 0;
    @Override
    public void run(){
        
    }
}
