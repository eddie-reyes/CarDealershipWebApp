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
			CarBodyStyloe.COUPE));
		vehicles.add(new Car(
			"BMW",
			"M4",
			"https://s1.cdn.autoevolution.com/images/news/2021-bmw-m4-design-revealed-in-accurate-rendering-g82-is-one-strange-fish-146832_1.jpg",
			2021,
			80000,
			15,
			false,
			DriveTrainType.RWD,
			CarBodyStyle.Coupe));
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
			
			
		
		vehicles.get(1).setInStock(false);
		
	}
	
	public void destroy() {
		
		
	}
	
	
}
