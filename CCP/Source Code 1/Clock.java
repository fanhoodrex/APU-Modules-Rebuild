package assignment;

import java.util.Calendar;
import java.util.InputMismatchException;

public class Clock implements Runnable {
	
	private Barmaid barmaid;
	private Landlord landlord;
	private CustomerGeneration cg;
	private int timer = 30000; // must be greater then 20000
	private int notification = timer/(timer/10000);
	
	public Clock(Barmaid brm, Landlord llr, CustomerGeneration cg) {
		this.barmaid = brm;
		this.landlord = llr;
		this.cg = cg;
		if(notification*2 >= timer || timer < 20000)
			throw new InputMismatchException("Wrong settings in \"Clock\" class");
	}
	
	static public String get_time() {
		Calendar now = Calendar.getInstance();
		String time = now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);
		return " [at " + time + "]";
	}

	@Override
	public void run() {
		try {
			Thread.sleep(this.timer - this.notification);
			this.landlord.say_last_orders();
			
			Thread.sleep(this.notification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.landlord.set_closing_time();
		this.cg.set_closing_time();
		this.barmaid.set_closing_time();	
	}
}
