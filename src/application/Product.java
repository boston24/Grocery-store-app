package application;

import javafx.scene.control.Button;

class Product {
	
	private String name;
	private double price;
	private int quantity;
	private int numInCart;
	private double priceSum;

	public Product(String name, double price, int quantity, int numInCart) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.numInCart = numInCart;
		this.priceSum = numInCart*price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getNumInCart() {
		return numInCart;
	}

	public void setNumInCart(int numInCart) {
		this.numInCart = numInCart;
	}
	
	public double setPriceSum(double priceSum) {
		return priceSum;
	}
	
	public double getPriceSum(int numInCart, double price) {
		return numInCart*price;
	}

	public double getPriceSum() {
		return numInCart*price;
	}


}
