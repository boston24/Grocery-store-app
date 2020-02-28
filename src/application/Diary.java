package application;
public class Diary extends Product {
	
	private int capacity;   // mililitres

	public Diary(String name, double price, int quantity, int numInCart, int capacity) {
		super(name, price, quantity, numInCart);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
