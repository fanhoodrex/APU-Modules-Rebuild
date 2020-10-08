
package cpp.assignment;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Assistant implements Runnable{
    
        private Cupboard Cupboard;
	private Cafe Cafe;
	
	public int wash_cups = 0;
	public int wash_glasses = 0;
	public int washing_time;
	public int rest_time;
	private boolean isWorking;
        public boolean closingTime = false;
        
        public Assistant(Cupboard Cupboard, Cafe Cafe) {
		this.Cupboard = Cupboard;
		this.Cafe = Cafe;
		this.washing_time = 500;
		this.rest_time = 500;
		this.isWorking = true;
	}
        
        public boolean isWorking() {
		return this.isWorking;
	}
        
        @Override
	public void run() {
		System.out.println(" Assistant started working.......... ");
                
                System.out.println(" Assistant washed all the Cups and Glasses and placed them in the Cupboard.......... ");
                
                
                try {
                        Thread.sleep(15000);
                        System.out.println("Assistant:  is cleaning tables....");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Assistant.class.getName()).log(Level.SEVERE, null, ex);
                    }
                try {
                        Thread.sleep(15000);
                        System.out.println("Assistant:  is cleaning tables....");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Assistant.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                
		if(this.Cafe.isCafeclosed() ) {
			
                    System.out.println(" Assistant is leaving now.........");
			
			synchronized(this.Cafe.ListCustomers) {
				this.Cafe.ListCustomers.notifyAll();
			}
			return;
		}
                
        }
}
