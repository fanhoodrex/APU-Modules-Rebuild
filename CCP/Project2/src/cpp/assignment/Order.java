
package cpp.assignment;


public class Order {
	private int Order;
	private int CustomerNumber;
	private Table Table;
	private Barmaid Barmaid;
	
	public Order( int Order, int CustomerNumber, Table Table, Barmaid Barmaid ) {
		this.Order = Order;
		this.CustomerNumber = CustomerNumber;
		this.Table = Table;
		this.Barmaid = Barmaid;
	}
	
	public int getOrder() {
		return Order;
	}
	
	public int getCustomerNumber() {
		return CustomerNumber;
	}
	
	public String getOrderText() {
		if ( Order == 0 ) {
			return "Fruit Juice ";
		} else if ( Order == 1 ) {
			return "Cappuccino ";
		} 
		
		return "Water ";
	}
	
	public Barmaid getBarmaid() {
		return Barmaid;
	}
	
	public Table getTable() {
		return Table;
	}
}