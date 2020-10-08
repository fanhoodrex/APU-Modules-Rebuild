
package cpp.assignment;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CustomerGenerator implements Runnable {
    
    Cafe cafe;
    public boolean ClosingTime = false;
    public boolean lastOrders = false;
    public int max = 8;  // Maximum number of customers allowed
    int CustomerNumber = 0;
    public CustomerGenerator(Cafe cafe){
        this.cafe = cafe;
    }
    
    @Override
    public void run()
    { 
        while(!ClosingTime)
        {
            Customer Customer = new Customer(CustomerNumber ,cafe);
            Customer.setArrivalTime(new Date());
            
            Thread ThreadCustomer = new Thread(Customer);
            System.out.println("Customer - " +CustomerNumber + " Arrived at the Cafe.");
            CustomerNumber++; // Increase the Customer number
           
            ThreadCustomer.start();
             try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10)); // Customers come in a period of 0 to ten seconds
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
        if (ClosingTime) { try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return;}
    }
    
    public synchronized void setclosingTime()
    { 
        ClosingTime = true;
            System.out.println("Customers: You are Closing ?? Okay We will hurry");
    }
    public synchronized void setLastOrders()
    { 
        lastOrders = true;
            System.out.println("Customers: Last Orders ?? Okay Sure ");
    }
    
}
