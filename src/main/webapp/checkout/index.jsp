<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import= "com.dealership.server.CheckoutServlet" %>
<%@ page import= "com.dealership.server.Vehicle" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Checkout</title>
		<style><%@include file="index.css"%></style>
		<script>
			function onPurchase() {
			  alert("Thank you for your purchase!");
			}
		</script>
	</head>
	<body>
		<h1 class="header">Checkout</h1>
		<div class="cart-items">
			<c:forEach items="${CheckoutServlet.cart.items}" var="vehicle" varStatus="loop">
			
				<div class="cart-card">

					<img src=${ vehicle.getImageLink() } alt=${ vehicle.getMake() }>
					<ul>
						<li>${ vehicle.getYear()} ${ vehicle.getMake()} ${ vehicle.getModel()} <i>(${vehicle.getPreOwned()})</i></li>
						<li> &middot &middot &middot</li>
						<li>$${ vehicle.getPrice()}</li>
					</ul>
					
					
				</div>

			</c:forEach>
		</div>
		
		
		<div class="purchase">
			<h2>Total: $${CheckoutServlet.cart.getTotalCost() }</h2>
			<form method="post">
				<a href="./homepage">
					<button onclick="onPurchase()">Purchase</button>
				</a>
			</form>
		</div>
		
	</body>
</html>