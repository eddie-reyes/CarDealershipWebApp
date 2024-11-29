package com.dealership.server;

enum BikeBodyStyle {

  SPORT,
  CRUISER,
  OFF_ROAD,
  TOURING,
  CUSTOM

}

public class Motorcycle extends Vehicle {

  BikeBodyStyle m_BodyStyle;

  public Motorcycle(String make, String model, String imageLink, int year, int price, double milesPerGallon, boolean preOwned, DriveTrainType driveTrain, BikeBodyStyle bodyStyle) {
		
		super(make, model, imageLink, year, price, milesPerGallon, preOwned);

    		m_BodyStyle = bodyStyle;

  }
}
		

  

  
  

