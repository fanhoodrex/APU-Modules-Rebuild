package assignment;

import java.util.InputMismatchException;

public class Table {
	private int CAPACITY;
	private Object glasses;
	private Object cups;
	private int put;
	private int pick;

	public Table() {
		glasses = 0;
		cups = 0;
		CAPACITY = Main.getRandomNumberInRange(10, 20);
		put = Main.getRandomNumberInRange(1, 4) * 1000;
		pick = Main.getRandomNumberInRange(1, 4) * 1000;
		if(CAPACITY < 2) throw new InputMismatchException("Capacity of table must be greater than 1");
	}
	
	public boolean can_put_glass() {
		return ((int)glasses+((int)cups*2) < CAPACITY);
	}
	
	public boolean can_put_cup() {
		return ((int)glasses+((int)cups*2) < CAPACITY-1);
	}
	
	/*
	 * NOTICE: Method calls when customer is putting glass -  put_glass()
	 * if customer is able to put the glass increase its value and return true
	 * else return false
	 */
	private boolean check_put_glass() {
		synchronized(cups) {
			synchronized(glasses) {
				boolean res = ((int)glasses+((int)cups*2) < CAPACITY);
				if(res) glasses = (int)glasses + 1;
				return res;
			}
		}
	}
	
	/*
	 * NOTICE: Method calls when customer is putting cup - put_cup()
	 * if customer is able to put the cup increase its value and return true
	 * else return false
	 */
	private boolean check_put_cup() {
		synchronized(cups) {
			synchronized(glasses) {
				boolean res = ((int)glasses+((int)cups*2) < CAPACITY-1);
				if(res) cups = (int)cups + 1;
				return res;
			}
		}
	}
	
	public void put_glass(Customer cst) {
		if(!check_put_glass()) {
			System.out.println(cst.get_name() + " is wating {assistant} to clean the table" + Clock.get_time());
			while(!check_put_glass()) {
				try {
					synchronized(this) {
						this.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(cst.get_name() + " is putting glass to the table" + Clock.get_time());
		try {
			Thread.sleep(put);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void put_cup(Customer cst) {
		if(!check_put_cup())  {
			System.out.println(cst.get_name() + " is wating {assistant} to clean the table" + Clock.get_time());
			while(!check_put_cup()) {
				try {
					synchronized(this) {
						this.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
			
		System.out.println(cst.get_name() + " is putting cup to the table" + Clock.get_time());
		try {
			Thread.sleep(put);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized int get_glasses() {
		return (int)this.glasses;
	}
	
	public synchronized int get_cups() {
		return (int)this.cups;
	}
	
	public void pick()  {
		synchronized(cups) {
			synchronized(glasses) {
				for(int i = 1; i <= (int)cups; i++) {
					try {
						Thread.sleep(pick);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				
				for(int i = 1; i <= (int)glasses; i++){
					try {
						Thread.sleep(pick);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				synchronized(this) {
					this.notify();
				}
				glasses = 0;
				cups = 0;
			}
		}
	}
}
