package com.dealership.server;

enum CarBodyStyle {
	
	CONVERTIBLE,
	SEDAN,
	COUPE,
	VAN,
	TRUCK,
	HATCHBACK
	
}

enum DriveTrainType {
	
	AWD,
	FWD,
	RWD
	
}

public class Car extends Vehicle {

	CarBodyStyle m_BodyStyle;
	
	DriveTrainType m_DriveTrain;
	
	public Car(String make, String model, String imageLink, int year, int price, double milesPerGallon, boolean preOwned, DriveTrainType driveTrain, CarBodyStyle bodyStyle ) {
	
		//call base constructor
		super(make, model, imageLink, year, price, milesPerGallon, preOwned);
		
		m_DriveTrain = driveTrain;
		m_BodyStyle = bodyStyle;
		
	}
	
	//special features related to car
	@Override
	public String getSpecialFeatures() {
		
		String retval = "Drive Train: ";
		
		switch(m_DriveTrain) {
		
			case AWD: 
				retval += "AWD";
				break;
			case FWD: 
				retval += "FWD";
				break;
			case RWD: 
				retval += "RWD";
				break;
				
			default: 

		}
		
		retval += " - Body: ";
		
		switch(m_BodyStyle) {
		
			case CONVERTIBLE: 
				retval += "Convertible";
				break;
			case SEDAN: 
				retval += "Sedan";
				break;
			case COUPE: 
				retval += "Coupe";
				break;
			case VAN: 
				retval += "Van";
				break;
			case TRUCK: 
				retval += "Truck";
				break;
			case HATCHBACK: 
				retval += "Hatchback";
				break;
				
			default: 

		}
		
		return retval;
		
	}
	
	
	
	
}
