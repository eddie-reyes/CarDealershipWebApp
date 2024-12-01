package com.dealership.server;

import java.util.ArrayList;

public class ShoppingCart {
	
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
	
	public int getTotalCost() {
		
		int sum = 0;
		
		for (Vehicle vehicle : items) {
			
			sum += vehicle.getPrice();
			
		}
		
		return sum;
	}

}
