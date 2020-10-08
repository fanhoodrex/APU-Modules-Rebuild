
package cpp.assignment;


public class Barmaid implements Runnable{
    
     Cafe cafe;
    public boolean closingTime = false; // used to check if it is the closing time
    
    public Barmaid(Cafe cafe)
    {
        this.cafe = cafe;
    }
    
     @Override
    public void run()
    {
        try
        {
            Thread.sleep(500);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();        }
        System.out.println("Barmaid Started to Work ....");
        while(!closingTime)
        {
             cafe.ServeDrinks("Barmaid");
        }
        if (closingTime) { 
            try
        {
            Thread.sleep(5000); // The Barmaid waits for this time before leaving
            while (cafe.ListCustomers.size() !=0) cafe.ServeDrinks("Landlord");
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
                        System.out.println("Barmaid: I am leaving the Cafe now............");
                        return;    }  
    }
    public synchronized void setclosingTime()
    {       
        closingTime = true;
        System.out.println("Barmaid stopped working.......... "); // The barmaid leaves a few seconds after the Closing time is called
    }
    
    /*this.cafe.setCafeclosed(true);;
        while(true) {
        	this.closingTime = true;
            break;	
        }*/
}
