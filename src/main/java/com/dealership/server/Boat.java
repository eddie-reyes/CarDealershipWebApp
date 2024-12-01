package com.dealership.server;

enum BoatBodyStyle {

  SPEED,
  YACHT,
  SAILBOAT,
  CRUISER,
  FLYBRIDGE,
  BOWRIDER

}

public class Boat extends Vehicle {


  private BoatBodyStyle m_BodyStyle;

	
	//Possibly have to take out "double milesPerGallon" and "DriveTrainType driveTrain" inside this parentheses if code doesn’t work.
	
	public Boat(String make, String model, String imageLink, int year, int price, double milesPerGallon, boolean preOwned, BoatBodyStyle bodyStyle ) {

		
		super(make, model, imageLink, year, price, milesPerGallon, preOwned);

    		m_BodyStyle = bodyStyle;

	}


	//Only included Body Style since Drive Train not avaliable for both Bikes and Boats.
    @Override
    public String getSpecialFeatures() {
        String retval = "Type: ";

        switch (m_BodyStyle) {
            case SPEED:
                retval += "Speed Boat";
                break;
            case YACHT:
                retval += "Yacht";
                break;
            case SAILBOAT:
                retval += "Sailboat";
                break;
            case CRUISER:
                retval += "Cruiser";
                break;
            case FLYBRIDGE:
                retval += "Flybridge";
                break;
            case BOWRIDER:
                retval += "Bowrider";
                break;
            default:
                retval += "Unknown";
        }

        return retval;
    }
	
}
