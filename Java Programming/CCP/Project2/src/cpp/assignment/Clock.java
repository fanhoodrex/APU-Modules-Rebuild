package cpp.assignment;

public class Clock extends Thread {
    
    public Landlord Landlord;
    public Barmaid Barmaid;
    public CustomerGenerator CustGen; 
     
    public boolean closingTime ;
    public boolean lastOrders;
    public Clock(Landlord Landlord, Barmaid Barmaid, CustomerGenerator CustGen)
    {
        this.Landlord= Landlord;
        this.CustGen = CustGen;
        this.Barmaid = Barmaid;
        closingTime = false;
        lastOrders = false; 
    }
    
    public void run(){
        try {
        Thread.sleep(30000);
        notifylastorders();
        }
        catch(InterruptedException e) 
                { }
        try {
        Thread.sleep(5000);
        notifyclosingTime();
        }
        catch(InterruptedException e) 
                { }
        
    }
        
        public void notifyclosingTime()
        {
            System.out.println("Clock: Is the Cafe CLOSING TIME NOW !");
            Landlord.setclosingTime();
            CustGen.setclosingTime();
            Barmaid.setclosingTime();
            
        }
        public void notifylastorders()
        {
            System.out.println("Clock: The Cafe is Closing soon !");
            Landlord.setLastOrders();
            CustGen.setLastOrders();
            
        }   
            
}
