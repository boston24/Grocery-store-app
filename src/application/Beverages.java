package application;
public class Beverages extends Product {
	
	private double capacity;  //litres

	public Beverages(String name, double price, int quantity, int numInCart, double capacity) {
		super(name, price, quantity, numInCart);
		this.capacity = capacity;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
}
