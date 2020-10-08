package assignment;

public class Customer implements Runnable{
	private String name;
	private int drink;
	private int amount;
	private boolean last_order = false;
	private boolean isDrinking = false;
    private Restaurant restaurant;

	public Customer(Restaurant rst) {
		this.restaurant = rst;
		this.amount = Main.getRandomNumberInRange(1, 3);
		this.drink = Main.getRandomNumberInRange(0, 1);
	}
	
	public void set_name(String name) {
		this.name = name;
	}
	
	public String get_name() {
		return name;
	}
	
	public int get_amount() {
		return amount;
	}
	
	public int get_drink() {
		return drink;
	}
	
	public void set_last_order(boolean arg) {
		this.last_order = arg;
		synchronized(this){
			this.notify();
		}
	}
	
	public boolean isDrinking() {
		return this.isDrinking;
	}
	
	@Override
	public void run() {
		if(amount >= 1) {
			amount -= 1; // decrease amount of left drinks
			
			System.out.println("["+this.get_name() + "] is drinking on the table. " + amount + " drinks left" + Clock.get_time());

			int duration = (Main.getRandomNumberInRange(5, 10)) * 1000; 
			isDrinking = true;
			try {
				synchronized(this) {
					this.wait(duration);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			isDrinking = false;

	        if(this.get_drink() == 1)
	        	this.restaurant.get_table_for_cup().put_cup(this);
	        else
	        	this.restaurant.get_table_for_glass().put_glass(this);
	        
	        /*
	         * If Landlord said "last orders", customers who ordered juice
	         * and not drinking current cup must order one more next time
	         * 
	         * EITHER customer would like to order more, let him
	         * 
	         * OTHERWISE customer leaves restaurant
	         */
	        if(this.last_order) {
	        	this.amount += 1;
		        System.out.println(this.get_name() + " decided to order one more juice" + Clock.get_time());
		        go_to_restaurant();
		        restaurant.visitors.remove(this);
		        this.last_order = false;
	        } else if(this.amount > 0){
	        	go_to_restaurant();
	        	restaurant.visitors.remove(this);
	        } else if (amount == 0) {
				System.out.println("[" + this.get_name() + "] left restaurant"  + Clock.get_time());
				restaurant.visitors.remove(this);
				
				// notify restaurant about leaving
				if(restaurant.visitors.isEmpty()) {
					synchronized (restaurant.queue) {
						restaurant.queue.notify();
			        }
				}
			}
		} 
	}
	
	private synchronized void go_to_restaurant() {
		restaurant.add(this);
	}

}
