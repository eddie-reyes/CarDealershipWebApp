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

  public Motorcycle(String make, String model, String imageLink, int year, int price, double milesPerGallon, boolean preOwned, BikeBodyStyle bodyStyle) {
		
	  	//call base constructor
		super(make, model, imageLink, year, price, milesPerGallon, preOwned);
		
			//special features
    		m_BodyStyle = bodyStyle;

  }

    @Override
    public String getSpecialFeatures() {
        String retval = "Type: ";

        switch (m_BodyStyle) {
            case SPORT:
                retval += "Sport";
                break;
            case CRUISER:
                retval += "Cruiser";
                break;
            case OFF_ROAD:
                retval += "Off-Road";
                break;
            case TOURING:
                retval += "Touring";
                break;
            case CUSTOM:
                retval += "Custom";
                break;
            default:
                retval += "Unknown";
        }

        return retval;
    }

}
		

  

  
  

