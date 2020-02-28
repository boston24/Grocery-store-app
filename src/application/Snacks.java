package application;

public class Snacks extends Product{
	
	private int size;  //grams

	public Snacks(String name, double price, int quantity, int numInCart, int size) {
		super(name, price, quantity, numInCart);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
