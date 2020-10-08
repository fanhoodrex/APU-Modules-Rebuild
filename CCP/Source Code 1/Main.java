package assignment;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Declare random amount of tables
		 */
		Table tbl[] = new Table[Main.getRandomNumberInRange(1, 10)];
		for(int i = 0; i < tbl.length; i++) {
			tbl[i] = new Table();
		}
		
		Cupboard cpb = new Cupboard();
		Statistics stt = new Statistics(cpb, tbl);
		Restaurant rst = new Restaurant(cpb, tbl, stt);	
		Assistant ast = new Assistant(cpb, rst);
		Landlord l = new Landlord(rst, ast);
		Barmaid b = new Barmaid(rst);
		
				
		Thread th_landlord = new Thread(l);
		Thread th_barmaid = new Thread(b);
		Thread th_ast = new Thread(ast);
		
		th_landlord.start();
		th_barmaid.start();
		th_ast.start();
		
		CustomerGeneration cg = new CustomerGeneration(rst);
		Thread th_cg = new Thread(cg);
		th_cg.start();
		
		Clock clock = new Clock(b, l, cg);
		Thread th_clock = new Thread(clock);
		th_clock.start();
	}

	public static int getRandomNumberInRange(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		return (int)(Math.random() * ((max - min) + 1)) + min;
	}
}

