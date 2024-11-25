<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import= "com.dealership.server.MarketplaceServlet" %>
<%@ page import= "com.dealership.server.Vehicle" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Marketplace</title>
		<style><%@include file="index.css"%></style>
	</head>
	<body>
		<h1 class="header">SMC Dealership</h1>
		<div class="marketplace-lot">
			<c:forEach items="${MarketplaceServlet.vehicles}" var="vehicle">
				<c:set var="vehicleIdx" value = "${ MarketplaceServlet.vehicles.indexOf(vehicle) }"></c:set>
			
				<div class="marketplace-card">
					<h2>Lot #<span id="lot-id">${ vehicleIdx + 1 }</span></h2>
					<img src=${ vehicle.getImageLink() } alt=${ vehicle.getMake() } width="300" height="300">
					<h2>Make: ${ vehicle.getMake() }</h2>
					<h2>Model: ${ vehicle.getModel() }</h2>
					<h2>Year: ${ vehicle.getYear() }</h2>
					<h2>Price: $${ vehicle.getPrice() }</h2>
					<c:if test= "${ vehicle.getInStock()  }">
							<form method="post">
								<c:if test= "${ vehicle.getInCart() }">
									<button name="lotIndex" value="${ vehicleIdx }">Remove from Cart</button>
								</c:if>
								<c:if test= "${ !vehicle.getInCart() }">
									<button name="lotIndex" value="${ vehicleIdx }">Add to Cart</button>
								</c:if>
								
							</form>
						</c:if>
					<c:if test= "${ !vehicle.getInStock()  }"><button disabled>Sold Out</button></c:if>
				</div>

			</c:forEach>
		</div>
		
		<div class="cart">
			<h2>Items in cart: ${ MarketplaceServlet.cart.getItems().size() }</h2>
			<a href="./checkout"><button>Go to Checkout</button></a>
		</div>
	</body>
</html>