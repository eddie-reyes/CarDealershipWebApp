package com.dealership.server;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class DealershipServer extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

	@Override
	public void init() throws ServletException {
		
		loadVehicles();
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("marketplace.jsp").forward(request, response);
		
	}
	
	public void loadVehicles() {
		
		vehicles.add(new Vehicle(
				"Toyota",
				"Corolla E10",
				"https://www.mycarpaint.net/wp-content/uploads/Toyota-Corolla-1995-1.jpg",
				1995,
				8625,
				30.8,
				true));
		vehicles.add(new Vehicle(
				"Volkswagen",
				"Beetle",
				"https://images.hgmsites.net/lrg/2015-volkswagen-beetle-convertible-2-door-auto-1-8t-angular-front-exterior-view_100488334_l.jpg",
				2015,
				9447,
				26,
				true));
		
	}
	
	public void destroy() {
		
		
	}
	
	
}