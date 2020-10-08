package assignment;

public class Barmaid implements Runnable{
	
	private Restaurant restaurant;
	private boolean closed = false;

	public Barmaid(Restaurant rst) {
		this.restaurant = rst;
	}

	@Override
	public void run() {
		System.out.println("Barmaid get started to work" + Clock.get_time());
        
        while(!closed) {
        	this.restaurant.serve("Barmaid");
        }
        
        if (closed) { 
        	System.out.println("Barmaid left" + Clock.get_time());
        	return;
        }	
	}
	
	public synchronized void set_closing_time() { 
    	this.restaurant.set_closed(true);;
        while(true) {
        	this.closed = true;
            break;	
        }
    }
}
