package com.dealership.server;

import java.util.ArrayList;

public class ShoppingCart {
	
	private ArrayList<Vehicle> items = new ArrayList<Vehicle>();
	
	//events
	public void onAddItem(Vehicle item) {
		
		items.add(item);
		item.setInCart(true); //set flag
		
	}
	
	
	public void onRemoveItem(Vehicle item) {
		
		items.remove(item);
		item.setInCart(false); //set flag
		
	}
	
	//getters
	public ArrayList<Vehicle> getItems() {
		
		return items;
		
	}
	
	public int getTotalCost() {
		
		int sum = 0;
		
		for (Vehicle vehicle : items) {
			
			sum += vehicle.getPrice(); //add to sum
			
		}
		
		return sum;
	}

}
