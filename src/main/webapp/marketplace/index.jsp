<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import= "com.dealership.server.MarketplaceServlet" %>
<%@ page import= "com.dealership.server.CheckoutServlet" %>
<%@ page import= "com.dealership.server.Vehicle" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Marketplace</title>
		<style><%@include file="index.css"%></style>
	</head>
	<body>
		<h1 class="header">Marketplace</h1>
		<div class="marketplace-lot">
			<c:forEach items="${MarketplaceServlet.vehicles}" var="vehicle" varStatus="loop">
			
				<c:if test = "${ vehicle.getClass().getSimpleName().toLowerCase() == MarketplaceServlet.sortQuery || MarketplaceServlet.sortQuery.isEmpty()}">
					<div class="marketplace-card">
						<h2>Lot #${ loop.count }</h2>
						<img src=${ vehicle.getImageLink() } alt=${ vehicle.getMake() } >
						<ul>
							<li class="vehicle-name">${ vehicle.getMake()} ${vehicle.getModel()}</li>
							<li>${ vehicle.getPreOwned() }</li>
							<li>Year: ${ vehicle.getYear() }</li>
							<li>${ vehicle.getMilesPerGallon() } MPG</li>
							<li>${ vehicle.getSpecialFeatures() }</li>
							<c:if test= "${ vehicle.getInStock()  }">
								<form method="post">
									<c:if test= "${ vehicle.getInCart() }">
										<button name="lotIndex" value="${ loop.index }">Remove from Cart</button>
									</c:if>
									<c:if test= "${ !vehicle.getInCart() }">
										<button name="lotIndex" value="${ loop.index }">Add to Cart</button>
									</c:if>
									<span class = "vehicle-name lot-price">$${ vehicle.getPrice() }</span>
								</form>
							</c:if>
							<c:if test= "${ !vehicle.getInStock()  }"><button disabled>Sold Out</button></c:if>
							
						</ul>
						
					</div>
				</c:if>
					
			</c:forEach>
		</div>
		
		<div class="cart">
			<h2 class="cart-text">Items in cart: ${ CheckoutServlet.cart.getItems().size() }&nbsp&nbsp<a href="./checkout"><button>Go to Checkout</button></a></h2>
			
		</div>
	</body>
</html>