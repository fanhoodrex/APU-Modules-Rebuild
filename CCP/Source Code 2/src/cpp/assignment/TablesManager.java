
package cpp.assignment;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TablesManager {
    
        private int numTables;
	private int numTakenTables;
	private Table[] TablesArray;
	private Lock lock = new ReentrantLock();
	private Condition noTablesAvailable = lock.newCondition();
	
	public TablesManager(int numTables) {
		this.numTables = 5;
		this.TablesArray = new Table[numTables];
		this.numTakenTables = 0;
	}
	
	public Table getTable() throws InterruptedException {
		lock.lock(); // Acquires the table for a customer and locks the table
		Table TableToReturn = null;
		try {
			while(this.numTakenTables == this.numTables) {
                            System.out.println("No Tables are Available for the Customers");
				// Restaurant.addMessage("No tables available.");
				
				noTablesAvailable.await(); // wait for a table to become available
				// Restaurant.addMessage("Table became available.");
                            System.out.println("No Tables are Available for the Customers");

			}
			// when this thread is signalled, find the table that is available
			for (int i=0; i < this.numTables; i++) { 
				if (TablesArray[i] == null) {
					TablesArray[i] = new Table(i);
					TableToReturn = TablesArray[i];
					numTakenTables++;
					break;
				}
			}
		} finally {
			lock.unlock(); // The customer leaves the table, and the table in unlocked
		}
		// Restaurant.changeTableStatus(TableToReturn.getTableId()); // Changes the Table status
		return TableToReturn;
	}
	
	public void returnTable(Table Table) {
		lock.lock();
		try {
			for (int i=0; i < this.numTables; i++) {
				if (i == Table.getTableId()) {
					TablesArray[i] = null;
					numTakenTables--;
					//Restaurant.addMessage("Table " + Table.getTableId() + " is now available.");
                                        System.out.println("Table - " +Table.getTableId() + " is now Available ");

					// Restaurant.changeTableStatus(Table.getTableId());
					noTablesAvailable.signal();  // notifies that a table is now available
				}
			}
		} finally {
			lock.unlock(); // Unlocks and Returns the Table
		}
	}
}
