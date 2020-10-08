
package cpp.assignment;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Cafe {
    
    private Cupboard Cupboard; 
    private TablesManager tables;
    
    private Table Table; // not used
    public String name;
    int ntables = 5;
    int numTables;
    ReentrantLock lock;
     public Queue<Customer> ListCustomers; // Queue for the Customers enering the cafe
    public Queue<Table> TablesQueue;    // List for the tables that will be avaialble in the cafe
   
    private static boolean[] TableStatus;
    private boolean Cafeclosed = false;
    
    
    public Cafe(Cupboard Cupboard )
    {
        
       this.Cupboard= Cupboard;
       
        ListCustomers = new LinkedList<>();
        TablesQueue = new LinkedList<>();
        
        for (int id = 0; id < ntables; id++) {
            Table newTable = new Table(id);
            TablesQueue.add(newTable);
        }
        
    }
 
    public void ServeDrinks(String staff) // Serve the Drinks to the Customers
    {
        Customer Customer;
        
        synchronized (ListCustomers)
        {
 
            while(ListCustomers.size()==0)
            {
                System.out.println("Cafe Crew is waiting for Customers ......");
                try
                {
                    ListCustomers.wait(); // Waits until being called by another thread
                
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
            System.out.println("There are Customers Waiting for Service in the queue"); // To check if there are any customers w
            Customer = (Customer)((LinkedList<?>)ListCustomers).poll(); // Removes the first Customer in the List
            
        }
        long duration=0;
        // Used to made customers orders
        String[] Item = {"Juice", "Cappuccino"};
	String order = Item[new Random().nextInt(Item.length)];
        System.out.println(staff + " received order from Customer - " + Customer.getCustomerID() + " for a "  + order +" Drink ");
        
        // For the drinks : 0 for juice and 1 for cappuccino
        if(order=="Juice") {
        	this.Cupboard.Make_juice(staff, Customer);
        } else {
        	this.Cupboard.Make_cappuccino(staff, Customer);
        }
         
         
        try
        {    
            System.out.println("Serving Customer : "+Customer.getCustomerID());
            duration = (long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Finished Serving Customer : "+Customer.getCustomerID() + " in "+duration+ " seconds.");
        System.out.println("Customer - "+Customer.getCustomerID()+" leaves the Cafe");
    }
 
    public void add(Customer customer) // Add a Customer to the Waiting Queue
    {
        System.out.println("Customer : "+customer.getCustomerID()+ " entering the Cafe "+customer.getArrivalTime());
 
        synchronized (ListCustomers)
        {
            if(ListCustomers.size() == 8)
            {
            	
            	System.out.println("There are no available Tables for customer "+customer.getCustomerID());
                System.out.println("Customer "+customer.getCustomerID()+"leaves the Cafe......");
                return ;
            }
 
            ((LinkedList<Customer>)ListCustomers).offer(customer); // Adds the Customer to the end of the queue
            System.out.println("Customer : "+customer.getCustomerID()+ " is waiting on the queue to seat");
            
            
            //if(ListCustomers.size()==1)
                ListCustomers.notify();
        }
    }
    public Table seatCustomer(Customer Customer) throws InterruptedException {
		Table table = null;
		//try {
			System.out.println("Hostess is trying to seat customer " + Customer.getCustomerID());
			
			table = tables.getTable();
			
			System.out.println("Customer " + Customer.getCustomerID() + " is seated at table " + table.getTableId());
			
			
			
			System.out.println("Hostess seated customer " +  Customer.getCustomerID() + " at table " + table.getTableId());
		
			table.seatTable(Customer);
                //}
                return table;
    }
    
    public boolean TableAvailable(){ // Checks if there are any Tables Available
        return TablesQueue.size() > 0 && TablesQueue.peek() != null;    //in a test Queue had size but null elements.
    }
    
    public synchronized boolean occupyTable(Customer customer){ // Customer Occupies a table
        if(!TableAvailable())
            return false;

        //TODO (Remove Assert after testing)
        assert customer == ListCustomers.peek();

        //Pull customer from Queue
        ListCustomers.poll();

        //Pull Table from Queue and Link with customer
        Table table = TablesQueue.poll();
        customer.Table = table;
        return true;
    }
    
    public synchronized boolean leaveTable(Customer customer){ // Customers Leave a table 
        //Put Table back to queue.
        TablesQueue.add(customer.Table);
        customer.Table = null;

        //Call-in First Customer in the Queue
        Customer newCustomer = ListCustomers.peek();
        if(newCustomer != null){
            synchronized (newCustomer)  //TODO check Intellij warning.
            {
                newCustomer.notify();
            }
        }
        return true;
    }
    
    // To return if Cafe is closed
    public void setCafeclosed(boolean Cafeclosed) {
		this.Cafeclosed = Cafeclosed;
	}
	
	public boolean isCafeclosed() {
		return this.Cafeclosed;
	}
}
