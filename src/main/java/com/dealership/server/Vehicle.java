package com.dealership.server;

public abstract class Vehicle {

	private String m_Make;
	private String m_Model;
	private String m_ImageLink; //src link for img tag
	private int m_Year;
	private int m_Price;
	private double m_MilesPerGallon; //mpg
	private boolean m_PreOwned;
	private boolean m_InStock = true; //all vehicles start as in stock
	private boolean m_InCart = false;

	public Vehicle(String make, String model, String imageLink, int year, int price, double milesPerGallon, boolean preOwned) {
		
		m_Make = make;
		m_Model = model;
		m_ImageLink = imageLink;
		m_Year = year;
		m_Price = price;
		m_MilesPerGallon = milesPerGallon;
		m_PreOwned = preOwned;
		
	}
	//getters
	public String getMake() {
		return m_Make;
	}

	public String getModel() {
		return m_Model;
	}
	
	public String getImageLink() {
		return m_ImageLink;
	}
	
	public int getYear() {
		return m_Year;
	}

	public int getPrice() {
		return m_Price;
	}
	
	public double getMilesPerGallon() {
		return m_MilesPerGallon;
	}
	
	public String getPreOwned() {
		
		if (m_PreOwned) {
			
			return "Pre-Owned";
			
		} else {
			
			return "New";
		}
	}
	
	public boolean getInStock() {
		return m_InStock;
	}
	
	public boolean getInCart() {
		
		return m_InCart;
		
	}
	
	//setters
	public void setInStock(boolean input) {
		
		m_InStock = input;
		
	}
	
	public void setInCart(boolean input) {
		
		m_InCart = input;
		
	}
	
	//must be overwritten in card, boat, and motorcycle
	public abstract String getSpecialFeatures();
	
}
