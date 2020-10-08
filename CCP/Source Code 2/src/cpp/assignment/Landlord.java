
package cpp.assignment;


public class Landlord  implements Runnable {
    
    Cafe cafe;
    Assistant Assistant;
    public boolean closingTime = false; // used to check if it is the closing time
    public boolean lastOrders = false;  // used to check if it the cafe will  close soon
    public Landlord(Cafe cafe, Assistant Assistant)
    {
        this.cafe = cafe;
        this.Assistant= Assistant;
    }
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(200);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Landlord Started to Work .............");
        while(!closingTime || Assistant.isWorking() )
        {
            cafe.ServeDrinks("Landlord");
        }
        if (closingTime) { try {
     			Thread.sleep(5000);
                        while (cafe.ListCustomers.size() !=0) cafe.ServeDrinks("Landlord");
                        System.out.println("**************** THE CAFE IS CLOSED ******************");
     		} catch (InterruptedException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		} return;}
    }
    
    public synchronized void setclosingTime()
    { 
        closingTime = true;
            System.out.println("Landlord : The cafe is Closing now! \nNo more Orders.....");
    }
    public synchronized void setLastOrders()
    { 
        lastOrders = true;
            System.out.println("Landlord : We are about to close \n Landlord: Last Orders Please ........");
    }
    
}
