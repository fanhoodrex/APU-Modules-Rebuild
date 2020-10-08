
package cpp.assignment;


public class Cupboard {
    
    private Object cups;
    private Object glasses;
    Customer customer;
    
    public Cupboard(){
            cups = 5;
	glasses = 5;
}
    private void await() { // Used to make threads wait before doing their next action
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
    private synchronized void TakeCup(String staff, Customer customer) {
		if((int)cups == 0) {
			try {
				System.out.println(staff + " is waiting for cup to make drink for Customer -  [" + customer.getCustomerID() + "]");
				synchronized(cups) {
					while(((int)cups == 0)) {
						cups.wait();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(staff + " is taking cup to make the Cappuccino for Customer - ["  + customer.getCustomerID() + "]");
		
		synchronized(cups) {
			cups = (int)cups - 1;
		}
		
		await();	
	}
    
    private synchronized void TakeGlass(String staff, Customer customer) {
		if((int)glasses == 0) {
			try {
				System.out.println(staff + " is waiting glass to make drink for Customer - [" + customer.getCustomerID() + "]");
				synchronized(glasses) {
					while((int)glasses == 0) {
						glasses.wait();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(staff + " is taking glass to make the Juice for Customer - ["  + customer.getCustomerID() + "]");
		
		synchronized(glasses) {
			glasses = (int)glasses - 1;
		}

		await();
	}
    
    // Acquires the objects in ingredients area to make the drinnks
    private synchronized void acquire_JuiceTap(String staff, Customer customer) {
		System.out.println(staff + " is using the Juice Tap to make drink for Customer - " + customer.getCustomerID());
		await();
	}
	
	private synchronized void acquire_Coffee(String staff , Customer customer) {
		System.out.println(staff + " acquired coffee ingredient to make drink for Customer - " + customer.getCustomerID() );
		await();
	}
	
	private synchronized void acquire_Milk(String staff, Customer customer) {
		System.out.println(staff + " acquired milk ingredient to make drink for Customer " + customer.getCustomerID());
		await();
                
	}
	
	
        
        // Gets the Glasses from the CupBoard
        public int getGlass() {   
		return (int)glasses;
	}
	// Gets the Cups from the Cupboard
	public int getCup() {
		return (int)cups;
	}
        
        // Returns the cups to the cupboard
        public void returnCup() {
		synchronized(cups) {
			cups.notify();
                        
			cups = (int)cups + 1;
		}
	}
	// Returns the glasses to the cupboard
	public void returnGlass() {
		synchronized(glasses) {
			glasses.notify();
			glasses = (int)glasses + 1;
		}
                
        
	}
        // Make the Juice
        public void Make_juice(String staff, Customer customer) {
		
                int fill_time = 200;
		int serve_time = 500;
	
		this.TakeGlass(staff, customer);
		this.acquire_JuiceTap(staff, customer);
		try {
			System.out.println(staff + ": is filling the glass with Juice for Customer - " + customer.getCustomerID() );
			Thread.sleep(fill_time);			
			System.out.println(staff + ": is taking Juice to Customer -  " + customer.getCustomerID() );
			Thread.sleep(serve_time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	// Make Cappucino
	public void Make_cappuccino(String staff, Customer customer) {
		int mix_time = 200;
		int serve_time = 500;
		
		this.TakeCup(staff, customer);
		this.acquire_Coffee(staff, customer);
		this.acquire_Milk(staff, customer);
		try {
			System.out.println(staff + ": is mixing Coffee and milk to make Cappucino for Customer - " + customer.getCustomerID() );
			Thread.sleep(mix_time);			
			System.out.println(staff + ": is taking Cappucino to Customer - " + customer.getCustomerID());
			Thread.sleep(serve_time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
