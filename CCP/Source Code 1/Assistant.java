package assignment;

import java.util.Random;

public class Assistant implements Runnable {
	private Cupboard cupboard;
	private Restaurant restaurant;
	
	private int wash_cups = 0;
	private int wash_glasses = 0;
	private int time_to_wash;
	private int cycle_time;
	private boolean inWork;
	private Random random = new Random();

	public Assistant(Cupboard cpb, Restaurant rst) {
		this.cupboard = cpb;
		this.restaurant = rst;
		this.time_to_wash = (random.nextInt(2)+1) * 1000;
		this.cycle_time = (random.nextInt(6)+10) * 1000;
		this.inWork = true;
	}
	
	public boolean isWorking() {
		return this.inWork;
	}

	@Override
	public void run() {
		System.out.println("{Assistant} starts working" + Clock.get_time());
		
		while(this.restaurant.amount_of_glasses() > 0 || this.restaurant.amount_of_cups() > 0 || !this.restaurant.queue.isEmpty() || !this.restaurant.visitors.isEmpty() || !this.restaurant.isClosed()) {
			try {
				Thread.sleep(this.cycle_time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(this.restaurant.isTablesEmpty()) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(this.restaurant.isTablesEmpty() && this.restaurant.queue.isEmpty() && this.restaurant.visitors.isEmpty() && this.restaurant.isClosed()) {
					System.out.println("{Assistant} completed work and leaving home..." + Clock.get_time());
					this.inWork = false;
					synchronized(this.restaurant.queue) {
						this.restaurant.queue.notifyAll();
					}
					return;
				}
			}
			
			System.out.println("{Assistant} is ready to clean tables" + Clock.get_time());
			
			wash_glasses = this.restaurant.amount_of_glasses();
			wash_cups = this.restaurant.amount_of_cups();
			this.restaurant.clean_tables();
			
			System.out.println("{Assistant} started to wash " + wash_cups + " cups and " + wash_glasses + " glasses" + Clock.get_time());
			for(int i = 1; i <= wash_cups; i++) {
				try {
					Thread.sleep(time_to_wash);
					this.cupboard.put_cup();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			for(int i = 1; i <= wash_glasses; i++) {
				try {
					Thread.sleep(time_to_wash);
					this.cupboard.put_glass();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("{Assistant} is having rest.." + Clock.get_time());
	
		}
		
		if(this.restaurant.isClosed() ) {
			System.out.println("{Assistant} completed work and leaving home" + Clock.get_time());
			this.inWork = false;
			synchronized(this.restaurant.queue) {
				this.restaurant.queue.notifyAll();
			}
			return;
		}
	}
}
