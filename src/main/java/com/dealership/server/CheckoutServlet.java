package com.dealership.server;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static ShoppingCart cart = new ShoppingCart();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("checkout/index.jsp").forward(request, response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//update homepage
		HomepageServlet.recentPurchase = new ArrayList<Vehicle>(cart.getItems());
		
		for (Vehicle vehicle : cart.getItems()) {
			
			vehicle.setInStock(false); //all vehicles purchased should be sold out
		
		}
		
		cart.getItems().clear(); //empty cart
		
		
		request.getRequestDispatcher("homepage/index.jsp").forward(request, response); //forward back to homepage
	}
	
	
	
	
}