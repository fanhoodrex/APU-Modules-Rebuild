package cpp.assignment;

public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
         System.out.println(" ************************ RESTAURANT STARTED ************************ ");
        Cupboard Cupboard = new Cupboard();
         Cafe cafe = new Cafe(Cupboard);

            Assistant Assistant = new Assistant(Cupboard, cafe);
	        Landlord Landlord = new Landlord(cafe, Assistant);
            Barmaid Barmaid = new Barmaid(cafe);
	        CustomerGenerator CustGen = new CustomerGenerator(cafe);
	        
	        Thread ThreadLandlord = new Thread(Landlord);
            Thread ThreadBarmaid = new Thread(Barmaid);
            Thread ThreadAssistant = new Thread(Assistant);
                 
            ThreadLandlord.start();
            ThreadBarmaid.start();
            ThreadAssistant.start(); 
            Thread ThreadCustomerGenerator = new Thread(CustGen);
            ThreadCustomerGenerator.start();
            Clock clock = new Clock(Landlord, Barmaid, CustGen);
            clock.start();   
    }  
}