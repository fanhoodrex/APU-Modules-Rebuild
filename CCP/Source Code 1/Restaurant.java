package assignment;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Restaurant {
    private boolean closed = false; 
    private boolean close_soon = false;
    private Cupboard cupboard;
    private Statistics statistics;
    public Table table[];
    public Queue<Customer> queue;
    public HashSet<Customer> visitors;

	public Restaurant(Cupboard cpb, Table tbl[], Statistics stt) {
		this.table = tbl;
		this.cupboard = cpb;
		this.statistics = stt;
		this.queue = new LinkedList<Customer>();
		this.visitors = new HashSet<Customer>();
	}
	
	public Table get_table_for_cup() {
		for(Table tbl : table) {
			if(tbl.can_put_cup()) {
				return tbl;
			}
		}
		return table[Main.getRandomNumberInRange(0, table.length-1)];
	}
	
	public Table get_table_for_glass() {
		for(Table tbl : table) {
			if(tbl.can_put_glass()) {
				return tbl;
			}
		}
		return table[Main.getRandomNumberInRange(0, table.length-1)];
	}
	
	public int amount_of_glasses() {
		int result = 0;
		for(Table tbl : table) {
			result += tbl.get_glasses();
		}
		return result;
	}
	
	public int amount_of_cups() {
		int result = 0;
		for(Table tbl : table) {
			result += tbl.get_cups();
		}
		return result;
	}
	
	public boolean isTablesEmpty() {
		if(this.amount_of_cups() == 0 && this.amount_of_glasses() == 0)
			return true;
		else
			return false;
	}
	
	public void clean_tables() {
		System.out.println("{Assistant} is picking all glasses and cups up. cups: " + this.amount_of_cups() + ", glasses: " + this.amount_of_glasses() + Clock.get_time());
		
		for(Table tbl : table) {
			tbl.pick();
		}
		
		System.out.println("{Assistant} completed cleaning." + Clock.get_time());
		
	}
	
	public void print_statistics() {
		this.statistics.print_statistics();
	}
	
	public void serve(String server) {
		Customer customer;
		synchronized (queue) {
			long startTime = System.nanoTime();
            while(queue.isEmpty()) {
            	System.out.println(server + " is waiting for customers.." + Clock.get_time());
                try {
                    queue.wait();
                    
                    /*
                     * if Barmaid is not serving customer and restaurant is closed
                     * he is able to leave workspace
                     */
                    if(server == "Barmaid" && closed) {
                    	queue.notify();
                    	return;
                    }
                    
                    /*
                     * if restaurant is closed, nobody inside and no queue
                     * Barmaid and/or Landlord get work done
                     */
                    if(closed && queue.isEmpty() && visitors.isEmpty()) return;
                } catch(InterruptedException iex) {
                    iex.printStackTrace();
                }
            }   
            long endTime = System.nanoTime();      
            long duration = endTime - startTime;
            duration = TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS);
            if((int)duration > 0) this.statistics.add_time((int)duration); // add waiting time to Statistics class
            
            customer = queue.element();
            visitors.add(customer);
            queue.remove();
            this.statistics.plus_customer();
		}
        
		String order = (customer.get_drink() == 0) ? "Juice" : "Cappuccino";
        System.out.println(server + " received order from " + customer.get_name() + ": " + customer.get_amount() + "x" + order  + Clock.get_time());
        
        /*
         * Choose drink option:
         * 0 for juice and 1 for cappuccino
         */
        if(customer.get_drink() == 0) {
        	this.cupboard.make_juice(server, customer);
        } else {
        	this.cupboard.make_cappuccino(server, customer);
        }
        
        Thread th_cs = new Thread(customer);
        th_cs.start();
	}
	
	public void add(Customer customer) {
		/*
		 * Only able to add customer to queue
		 * if restaurant is open (for all customers)
		 * or restaurant has customers inside (for customers who inside only)
		 */
		if(!closed || !this.visitors.isEmpty()) {
	        synchronized (queue) {
	            queue.add(customer);
	            System.out.println(customer.get_name() + " stood to the queue" + Clock.get_time());
	            queue.notify();
	        }
	    }
	}
	
	public void set_closed(boolean cls) {
		this.closed = cls;
	}
	
	public boolean isClosed() {
		return this.closed;
	}
	
	public void set_close_soon(boolean cls) {
		this.close_soon = cls;
	}
	
	public boolean isCloseSoon() {
		return this.close_soon;
	}
}
