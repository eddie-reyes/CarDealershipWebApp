package com.dealership.server;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/marketplace")
public class MarketplaceServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public static ShoppingCart cart = new ShoppingCart();

	public void init() throws ServletException {
		
		loadVehicles();
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("marketplace/index.jsp").forward(request, response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int lotIndex = Integer.parseInt(request.getParameter("lotIndex"));
		
		Vehicle selectedVehicle = vehicles.get(lotIndex);
		
		
		if (cart.getItems().contains(selectedVehicle)) {
			
			cart.onRemoveItem(selectedVehicle);
			
		} else {
			
			cart.onAddItem(selectedVehicle);
		}
	
		
		request.getRequestDispatcher("marketplace/index.jsp").forward(request, response);
	}
	
	public void loadVehicles() {
		//cars
		vehicles.add(new Car(
				"Toyota",
				"Corolla E10",
				"https://www.mycarpaint.net/wp-content/uploads/Toyota-Corolla-1995-1.jpg",
				1995,
				8625,
				30.8,
				true,
				DriveTrainType.AWD,
				CarBodyStyle.HATCHBACK));
		vehicles.add(new Car(
				"Volkswagen",
				"Beetle",
				"https://images.hgmsites.net/lrg/2015-volkswagen-beetle-convertible-2-door-auto-1-8t-angular-front-exterior-view_100488334_l.jpg",
				2015,
				9447,
				26,
				false,
				DriveTrainType.AWD,
				CarBodyStyle.COUPE));
		vehicles.add(new Car(
			"Mercedes",
			"E350",
			"https://preview.redd.it/one-of-the-last-w211s-made-2009-e350-daily-driver-in-the-v0-qhexj8k7yzla1.jpg?width=1080&crop=smart&auto=webp&s=743a2477fc32c9b817955ed9e58eb2f1def92d8d",
			2006,
			5500,
			18,
			true,
			DriveTrainType.RWD,
			CarBodyStyle.SEDAN));
		vehicles.add(new Car(
			"Toyota",
			"Camry",
			"https://www.motorbiscuit.com/wp-content/uploads/2023/01/2004-Toyota-Camry.jpg",
			2004,
			3250,
			25,
			true,
			DriveTrainType.FWD,
			CarBodyStyle.SEDAN));
		vehicles.add(new Car(
			"Ford",
			"Mustang GT",
			"https://hips.hearstapps.com/hmg-prod/images/2024-ford-mustang-gt-111-64e6608fce997.jpg?crop=0.546xw:0.615xh;0.0737xw,0.325xh&resize=768:*",
			2024,
			48000,
			13,
			false,
			DriveTrainType.RWD,
			CarBodyStyle.COUPE));
		vehicles.add(new Car(
			"BMW",
			"M4",
			"https://s1.cdn.autoevolution.com/images/news/2021-bmw-m4-design-revealed-in-accurate-rendering-g82-is-one-strange-fish-146832_1.jpg",
			2021,
			80000,
			15,
			false,
			DriveTrainType.RWD,
			CarBodyStyle.COUPE));
		vehicles.add(new Car(
			"Honda",
			"Odyssey",
			"https://www.iihs.org/cdn-cgi/image/width=636/api/ratings/model-year-images/1820/",
			2012,
			3800,
			16,
			true,
			DriveTrainType.FWD,
			CarBodyStyle.VAN));
		vehicles.add(new Car(
			"Ferrari",
			"LaFerrari",
			"https://www.charlottemotorspeedway.com/images/La-Ferrari--Hendrick-lg.JPG",
			2017,
			4000000,
			12,
			true,
			DriveTrainType.RWD,
			CarBodyStyle.COUPE));
		vehicles.add(new Car(
			"Porsche",
			"918 Spyder",
			"https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Porsche_918_Spyder_IAA_2013.jpg/1200px-Porsche_918_Spyder_IAA_2013.jpg",
			2016,
			2000000,
			16,
			true,
			DriveTrainType.AWD,
			CarBodyStyle.COUPE));
		vehicles.add(new Car(
			"Mercedes",
			"C63 AMG",
			"https://bringatrailer.com/wp-content/uploads/2020/04/2012_mercedes-benz_c63_amg_15970725257d1dc9f9ab8e8B0C08B2D-95B9-4A20-B74D-FD057599AAD4.jpeg",
			2012,
			23000,
			14,
			true,
			DriveTrainType.RWD,
			CarBodyStyle.SEDAN));
		vehicles.add(new Car(
			"Mazda",
			"3",
			"https://cars.usnews.com/static/images/Auto/izmo/338625/2012_mazda_mazda3_angularfront.jpg",
			2012,
			2800,
			16,
			true,
			DriveTrainType.FWD,
			CarBodyStyle.HATCHBACK));
		Vehicles.add(new Car(
			"Ford",
			"Raptor",
			"https://bringatrailer.com/wp-content/uploads/2023/09/2021_ford_f-150-raptor_img_2810-09483.jpeg?fit=940%2C626",
			2021,
			64000,
			8,
			false,
			DriveTrainType.AWD,
			CarBodyStyle.TRUCK));
		vehicles.add(new Car(
			"Ford",
			"Mustang Ecoboost",
			"https://di-uploads-pod39.dealerinspire.com/towncountryfordoflou/uploads/2021/05/2021-Ford-Mustang-Ecoboost-Premium-Model-Left.jpeg",
			2021,
			36000,
			18,
			true,
			DriveTrainType.RWD,
			CarBodyStyle.COUPE));
		//motorcycles
		vehicles.add(new Motorcycle(
			"Honda",
			"VTX 1300 R",
			"https://www.webbikeworld.com/honda-vtx1300r/vtx1300r-09c/",
			2007,
			3300,
			45,
			true,
			BikeBodyStyle.CRUISER));
		vehicles.add(new Motorcycle(
			"Honda",
			"CL 70",
			"https://cdn.dealeraccelerate.com/street/1/362/15142/1920x1440/1970-honda-cl70-restored-for-office-display-super-slick",
			1966,
			3000,
			43,
			true,
			BikeBodyStyle.CUSTOM));
		vehicles.add(new Motorcycle(
			"Harley-Davidson",
			"Iron 1200",
			"https://cdn.dealerspike.com/imglib/products/harley-showroom/2019/sportster-iron-1200/high-res-jpg-19-x-l1200-ns-r-v2-853x435.png",
			2011,
			14950,
			52,
			true,
			BikeBodyStyle.SPORT));
		vehicles.add(new Motorcycle(
			"Triumph",
			"Tiger 800 XC",
			"https://cdn.dealerspike.com/imglib/v1/800x600/imglib/trimsdb/11166621-0-71182891.jpg",
			2014,
			4500,
			43,
			true,
			BikeBodyStyle.SPORT));
		vehicles.add(new Motorcycle(
			"Triumph",
			"Bonneville T120"
			"https://media.triumphmotorcycles.co.uk/image/upload/f_auto/q_auto:eco/sitecoremedialibrary/media-library/images/motorcycles/t120%20black%202025/bonneville_t120_black_my25_graphite_rhs_1080px.png",
			2019,
			1200,
			65,
			false,
			BikeBodyStyle.CRUISER));
		vehicles.add(new Motorcycle(
			"Yamaha",
			"FJ-09",
			"https://adventuremotorcycle.com/images/ARTICLES/Bikes/Yamaha_FJ09/gallery/2015-FJ-09-Gallery1.jpg",
			2015,
			2585,
			46,
			true,
			BikeBodyStyle.SPORT));
		vehicles.add(new Motorcycle(
			"BMW",
			"R 1200 GS",
			"https://mediapool.bmwgroup.com/cache/P9/201609/P90235547/P90235547-the-new-bmw-r-1200-gs-11-2016-600px.jpg",
			2011,
			8350,
			59,
			true,
			BikeBodyStyle.SPORT));
		vehicles.add(new Motorcycle(
			"BMW",
			"T Ninet 719",
			"https://cdn.dealerspike.com/imglib/v1/800x600/imglib/trimsdb/19223621-0-119339971.jpg",
			2018,
			12600,
			41,
			true,
			BikeBodyStyle.CUSTOM));
		vehicles.add(new Motorcycle(
			"Honda",
			"Gold Wing Tour",
			"https://cdnmedia.endeavorsuite.com/images/ThumbGenerator/Thumb.aspx?img=%2F%2Fcdnmedia.endeavorsuite.com%2Fimages%2Fcatalogs%2F21278%2Fproducts%2Fdetail%2F51dab43c-23e8-4c01-a30f-f719147151f9.jpg&mw=1000&mh=563&f=1",
			2024,
			30000,
			67,
			false,
			BikeBodyStyle.CRUISER));
		vehicles.add(new Motorcycle(
			"Honda",
			"Rebel 1100",
			"https://cloudfront-us-east-1.images.arcpublishing.com/octane/3LYCJ75HVRCABCSADTY7AHKTIA.jpg",
			2024,
			10000,
			53,
			false,
			BikeBodyStyle.CRUISER));
		vehicles.add(new Motorcycle(
			"Honda",
			"Fireblade SP",
			"https://www.slashgear.com/img/gallery/honda-cbr1000rr-r-fireblade-sp-review-turns-every-road-into-a-track/l-intro-1695055262.jpg",
			2024,
			30000,
			50,
			false,
			BikeBodyStyle.SPORT));
		//Boats
		vehicles.add(new Boat(
			"Sunseeker",
			"Predator 61",
			"https://cdn.denisonyachtsales.com/wp-content/uploads/2011/05/61-Sunseeker-Predator-Review.jpg",
			2002,
			475000,
			true,
			BoatBodyStyle.CRUISER));
		vehicles.add(new Boat(
			"Johnson",
			"63 Flybridge",
			"https://images.boatsgroup.com/resize/1/30/29/1991-johnson-63-flybridge-power-9443029-20240625102954395-1_XLARGE.jpg",
			1991,
			199000,
			true,
			BoatBodyStyle.FLYBRIDGE));
		vehicles.add(new Boat(
			"Sea Ray",
			"SPX 230",
			"https://www.searay.com/content/dam/searay/2024/model-images/spx/spx-230/2024-SPX-230-SPX230-running-starboard-stern-08674.jpg.transform/small/image.jpg",
			2024,
			78999,
			true,
			BoatBodyStyle.BOWRIDER));
		vehicles.add(new Boat(
			"Yamaha",
			"Jeanneau",
			"https://yamahaoutboards.com/getmedia/248ce268-92ef-4f40-a89d-d988adf4b843/Leader_12-5_2020_TomKing_04128_Edit.jpg",
			2020,
			110000,
			false,
			BoatBodyStyle.CRUISER));
		vehicles.add(new Boat(
			"Benetti",
			"Oasis",
			"https://images.boatsgroup.com/resize/1/23/56/2024-benetti-oasis-34m-power-9452356-20240731162651446-1_XLARGE.jpg?w=200&h=146&t=1727294169000&exact&format=webp",
			2025,
			4984663,
			false,
			BoatBodyStyle.YACHT));
		
		
		vehicles.get(1).setInStock(false);
		
	}
	
	public void destroy() {
		
		
	}
	
	
}
