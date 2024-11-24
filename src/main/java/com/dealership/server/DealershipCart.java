package com.dealership.server;

import java.util.ArrayList;

public class DealershipCart {
	
	private ArrayList<Vehicle> items = new ArrayList<Vehicle>();
	
	
	public void onAddItem(Vehicle item) {
		
		items.add(item);
		item.setInCart(true);
		
	}
	
	
	public void onRemoveItem(Vehicle item) {
		
		
		items.remove(item);
		item.setInCart(false);
		
		
	}
	
	public ArrayList<Vehicle> getItems() {
		
		
		return items;
		
	}

}
