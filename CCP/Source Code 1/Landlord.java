package assignment;

public class Landlord implements Runnable {

	private Restaurant restaurant;
	private Assistant assistant;
	private boolean closed = false;

	public Landlord(Restaurant rst, Assistant ast) {
		this.assistant = ast;
		this.restaurant = rst;
	}

	@Override
	public void run() {
        System.out.println("Landlord get started to work" + Clock.get_time());
        
        /*
         * Landlord is able to server customers
         * if restaurant is open or restaurants has visitors inside
         */
        while(!closed || !restaurant.visitors.isEmpty() || assistant.isWorking()) {
            this.restaurant.serve("Landlord");
        }
        
        /*
         * If restaurant is closed and all customers assistant left restaurant
         * Landlord can leave work place too
         */
        while (closed && restaurant.visitors.isEmpty() && !assistant.isWorking()) {
        	this.restaurant.print_statistics();
        	System.out.println("Landlord left.." + Clock.get_time());
        	return;
        }	
	}
	
	public synchronized void set_closing_time(){
        while(true) {
        	// NOTICE: Landlord must wait for customers and assistant to leave
        	this.closed = true;
            break;	
        }
    }
	
	public void say_last_orders() {
		System.out.println("Landlord says: 'Last Orders'" + Clock.get_time());
		this.restaurant.set_close_soon(true);
		synchronized(this.restaurant.visitors) {
			for(Customer cst : this.restaurant.visitors) {
				if(cst.isDrinking() && !this.restaurant.isClosed() && this.restaurant.isCloseSoon() && cst.get_drink() == 0 && cst.get_amount() > 1) {
					cst.set_last_order(true);
					
				}
			}
		}
	}
}

