package it.unibo.paw.db;

import java.util.ArrayList;
import java.util.List;

import it.unibo.paw.model.Item;

public class Cart {
	private int codeCart;
	private List<Item> items;
	public int getCodeCart() {
		return codeCart;
	}
	public void setCodeCart(int codeCart) {
		this.codeCart = codeCart;
	}
	public List<Item> getCart() {
		return items;
	}
	public void setCart(List<Item> items) {
		this.items = items;
	}
	public Cart() {
		this.items=new ArrayList<Item>();
	}

}
