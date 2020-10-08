package assignment;

import java.util.ArrayList;

public class Statistics {
	private int i_cups, i_glasses, f_cups, f_glasses, total, min, max, average;
	private ArrayList<Integer> waiting_time;
	private Object customers;
	private Cupboard cupboard;
	private Table tables[];
	
	public Statistics(Cupboard cpb, Table tbl[]) {
		this.cupboard = cpb;
		this.tables = tbl;
		this.waiting_time = new ArrayList<Integer>();
		this.customers = 0;
		this.total = 0;
		this.max = 0;
		this.min = 0;
		this.i_cups = cupboard.get_cups();
		this.i_glasses = cupboard.get_glasses();
	}
	
	private void count_cupboard() {
		this.f_cups = cupboard.get_cups();
		this.f_glasses = cupboard.get_glasses();
	}
	
	private void count_time() {
		if(!waiting_time.isEmpty()) {
			min = waiting_time.get(0);
			max = waiting_time.get(0);
		}
		
		for(int time : waiting_time) {
			if(time < min) min = time;
			if(time > max) max = time;
			total += time;
		}
		try {
			average = total / waiting_time.size();
		} catch (java.lang.ArithmeticException e) {
			average = 0;
		}
		
	}
	
	public void plus_customer() {
		synchronized(customers) {
			customers = (int)customers + 1;
		}
	}
	
	public void add_time(int time) {
		waiting_time.add(time);
	}
	
	// Check which table is not empty
	public void checkout_tables() {
		boolean allclear = true;
		for(Table tbl : tables) {
			if(tbl.get_cups() > 0 || tbl.get_glasses() > 0) {
				System.out.println("Table " + tbl + "is not empty. cups: " + tbl.get_cups() + " | glasses: " + tbl.get_glasses());
				allclear =  false;
			}
		}
		
		if(allclear) {
			System.out.println("All " + tables.length + " tables is empty");
		}
	}

	public void print_statistics() {
		this.count_cupboard();
		this.count_time();
		System.out.println("\n---------- Statistics ----------");
		System.out.println("Initial amount | cups: " + i_cups + ", glasses: " + i_glasses);
		System.out.println("Final   amount | cups: " + f_cups + ", glasses: " + f_glasses);
		this.checkout_tables();
		System.out.println("Total waiting time for customer: " + total + " | Average: " + average + " | Minimum: " + min + " | Maximum: " + max);
		System.out.println("Amount of served customers: " + customers);
		System.out.println("--------------------------------\n");
	}
}
