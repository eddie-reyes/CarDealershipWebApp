package com.dealership.server;

enum BoatBodyStyle {

  SPEED,
  YACHT,
  SAILBOAT,

}

public class Boat extends Vehicle {

  private BoatBodystyle bodyStyle;

  public Boat(String make, String model, String imageLink, int year, int price, boolean preOwned, BoatBodyStyle bodyStyle ) {
		
		super(make, model, imageLink, year, price, preOwned);

    this.bodyStyle = bodyStyle;

  }
  
  public String getSpecialFeatures() {
	  
	  return "";
  }

}
