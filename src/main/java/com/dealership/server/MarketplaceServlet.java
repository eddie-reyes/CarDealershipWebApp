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
			
			
		
		vehicles.get(1).setInStock(false);
		
	}
	
	public void destroy() {
		
		
	}
	
	
}
