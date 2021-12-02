package cpp.assignment;

import java.util.Date;
import java.awt.*;
import java.util.Random;

public class Customer implements Runnable{
    private int CustomerNumber;
    private Date ArrivalTime;
    public Cafe cafe;
    private int drink;    
    private boolean stillDrinking = false; 
    public Table Table;
    
    public Customer(int CustomerNumber, Cafe cafe)
    {
        this.CustomerNumber= CustomerNumber;
        this.cafe = cafe;
        this.drink = new Random().nextInt(1); 
        this.Table = Table;
    }
 
    public Date getArrivalTime() {
        return ArrivalTime;
    }
 
    public void setArrivalTime(Date ArrivalTime) {
        this.ArrivalTime = ArrivalTime;
    }
    
	public int getCustomerID() {
		return this.CustomerNumber;
	}
	public void setCustomerID(int CustomerNumber){
		this.CustomerNumber= CustomerNumber;
	}
        
	public Table getTable() {
		return this.Table;
	}
        public int getDrink(){
            return drink; 
        }
        
    
   public void run()
    {
     Arrive_Cafe();
        
    }
    private synchronized void Arrive_Cafe()
    {
        cafe.add(this);
    }
}