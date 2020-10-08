package assignment;

import java.util.concurrent.TimeUnit;

public class CustomerGeneration implements Runnable {
	
	private Restaurant restaurant;
	private boolean closed = false;
	private int limit = 4; // limitation of come in customers
	
	public CustomerGeneration(Restaurant rst) {
		this.restaurant = rst;
	}

	@Override
	public void run() {
		while(!closed) {
			if (limit == 0)
				break;
			
            Customer customer = new Customer(restaurant);
            Thread th_customer = new Thread(customer);
            customer.set_name("Customer " + th_customer.getId());        
            this.restaurant.add(customer);
 
            try {
                TimeUnit.SECONDS.sleep((long)(Math.random()*20));
            } catch(InterruptedException iex) {
                iex.printStackTrace();
            }
            
            limit--;
        }
		
        if (closed) {
        	return;
        }
	}
	
	public synchronized void set_closing_time() {
        this.closed = true;
        System.out.println("***Restaurant is closed***");
        /*
         * Notify barmaid and landlord about closing time, if there is no queue and visitors
         */
        if(this.restaurant.queue.isEmpty() && this.restaurant.visitors.isEmpty()) {
        	synchronized(this.restaurant.queue) {
        		this.restaurant.queue.notifyAll();
        	}
        }
    }

}
