package assignment;

public class Cupboard {
	private Object cups;
	private Object glasses;

	public Cupboard() {
		cups = Main.getRandomNumberInRange(10, 20);
		glasses = Main.getRandomNumberInRange(10, 20);
	}

	private synchronized void take_cup(String server, Customer cst) {
		if((int)cups == 0) {
			try {
				System.out.println(server + " is waiting cup for [" + cst.get_name() + "]" + Clock.get_time());
				synchronized(cups) {
					while(((int)cups == 0)) {
						cups.wait();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(server + " is taking cup for ["  + cst.get_name() + "]" + Clock.get_time());
		
		synchronized(cups) {
			cups = (int)cups - 1;
		}
		
		waiting();	
	}
	
	private synchronized void take_glass(String server, Customer cst) {
		if((int)glasses == 0) {
			try {
				System.out.println(server + " is waiting glass for [" + cst.get_name() + "]" + Clock.get_time());
				synchronized(glasses) {
					while((int)glasses == 0) {
						glasses.wait();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(server + " is taking glass for ["  + cst.get_name() + "]" + Clock.get_time());
		
		synchronized(glasses) {
			glasses = (int)glasses - 1;
		}

		waiting();
	}
	
	public void put_cup() {
		synchronized(cups) {
			cups.notify();
			cups = (int)cups + 1;
		}
	}
	
	public void put_glass() {
		synchronized(glasses) {
			glasses.notify();
			glasses = (int)glasses + 1;
		}
	}
	
	private synchronized void take_juice_tap(String server, Customer cst) {
		System.out.println(server + " is taking juice tap for [" + cst.get_name() + "]" + Clock.get_time());
		waiting();
	}
	
	private synchronized void take_coffee(String server, Customer cst) {
		System.out.println(server + " is taking coffee for [" + cst.get_name() + "]" + Clock.get_time());
		waiting();
	}
	
	private synchronized void take_milk(String server, Customer cst) {
		System.out.println(server + " is taking milk for [" + cst.get_name() + "]" + Clock.get_time());
		waiting();
	}
	
	private void waiting() {
		try {
			Thread.sleep(Main.getRandomNumberInRange(1, 3) * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int get_glasses() {
		return (int)glasses;
	}
	
	public int get_cups() {
		return (int)cups;
	}
	
	public void make_juice(String server, Customer cst) {
		int time_to_fill = 2000;
		int time_to_serve = 5000;
	
		this.take_glass(server, cst);
		this.take_juice_tap(server, cst);
		try {
			System.out.println(server + " is filling glass for [" + cst.get_name() + "]" + Clock.get_time());
			Thread.sleep(time_to_fill);			
			System.out.println(server + " is serving [" + cst.get_name() + "]" + Clock.get_time());
			Thread.sleep(time_to_serve);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public void make_cappuccino(String server, Customer cst) {
		int time_to_fill = 2000;
		int time_to_serve = 5000;
		
		this.take_cup(server, cst);
		this.take_coffee(server, cst);
		this.take_milk(server, cst);
		try {
			System.out.println(server + " is filling cup for [" + cst.get_name() +"]" + Clock.get_time());
			Thread.sleep(time_to_fill);			
			System.out.println(server + " is serving [" + cst.get_name() + "]" + Clock.get_time());
			Thread.sleep(time_to_serve);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
