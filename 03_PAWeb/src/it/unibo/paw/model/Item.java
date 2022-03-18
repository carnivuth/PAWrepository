package it.unibo.paw.model;

public class Item {
	private int codeItem;
	private String description;
	private double price;
	private int quantity;
	public int getCodeItem() {
		return codeItem;
	}
	public void setCodeItem(int codeItem) {
		this.codeItem = codeItem;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Item() {}

}
