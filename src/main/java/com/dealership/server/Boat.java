package com.dealership.server;

enum BoatBodystyle {

  SPEED,
  YACHT,
  SAILBOAT,
  CRUISER,
FLYBRIDGE,
BOWRIDER

}

public class Boat extends Vehicle {

  private BoatBodystyle bodyStyle;

  public Boat(String make, String model, String imageLink, int year, int price, boolean preOwned, CarBodyStyle bodyStyle ) {
		
		super(make, model, imageLink, year, price, preOwned);

    this.bodyStyle = bodyStyle;

  }

}
