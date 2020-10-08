
package cpp.assignment;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.InputMismatchException;

public class Table {
    
        private int TableId; // ID of the Table
        private Object glasses;
        private Object cups;
    
        private Customer Customer; // Customer ID
	private Barmaid Barmaid; // Barmaid
	private Lock lock = new ReentrantLock(); // Used to lock the table
	private Condition readyCondition = lock.newCondition();

	
	public Table(int TableId) {
		this.TableId = TableId;
	}
	
	public int getTableId() { // Gets table ID
		return this.TableId;
	}

	public Customer getCustomer() {
		return Customer;
	}
	
	public Barmaid getBarmaidThread() {
		return Barmaid;
	}
	
	public Lock getLock() {
		return lock;
	}
	
	public Condition getReadyCondition() {
		return readyCondition;
	}

	public void seatTable(Customer Customer) {  // Seats the Customer
		this.Customer = Customer;
		
//		
	}
}