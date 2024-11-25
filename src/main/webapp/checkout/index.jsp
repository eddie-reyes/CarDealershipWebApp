<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import= "com.dealership.server.MarketplaceServlet" %>
<%@ page import= "com.dealership.server.Vehicle" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Checkout</title>
		<style><%@include file="index.css"%></style>
	</head>
	<body>
		<h1>Items in Cart</h1>
		<div class="cart-items">
			<c:forEach items="${MarketplaceServlet.vehicles}" var="vehicle" varStatus="loop">
			
				<div class="cart-card">

					<img src=${ vehicle.getImageLink() } alt=${ vehicle.getMake() } width="300" height="300">
					<h2>${ vehicle.getYear()} ${ vehicle.getMake()} ${ vehicle.getModel()}</h2>
					<h2>$${ vehicle.getPrice()}</h2>
					
				</div>

			</c:forEach>
		</div>
		
	</body>
</html>