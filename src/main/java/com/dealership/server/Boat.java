package com.dealership.server;

enum BoatBodystyle {

  SPEED,
  YACHT,
  SAILBOAT,

}

public class Boat extends Vehicle {

  BoatBodystyle m_BodyStyle;

  public Boat(String make, String model, String imageLink, int year, int price, boolean preOwned, CarBodyStyle bodyStyle ) {
		
		super(make, model, imageLink, year, price, preOwned);

    m_BodyStyle = bodyStyle;

  }
  
