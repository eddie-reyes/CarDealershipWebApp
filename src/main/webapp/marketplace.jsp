<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import= "com.dealership.server.DealershipServer" %>
<%@ page import= "com.dealership.server.Vehicle" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Marketplace</title>
		<style><%@include file="marketplace.css"%></style>
	</head>
	<body>
		<h1 class="header">SMC Dealership</h1>
		<div class="marketplace-lot">
			<c:forEach items="${DealershipServer.vehicles}" var="vehicle">
			
				<div class="marketplace-card">
					<h2>Lot #${ DealershipServer.vehicles.indexOf(vehicle) + 1 }</h2>
					<img src=${ vehicle.getImageLink() } alt=${ vehicle.getMake() } width="300" height="300">
					<h2>Make: ${ vehicle.getMake() }</h2>
					<h2>Model: ${ vehicle.getModel() }</h2>
					<h2>Year: ${ vehicle.getYear() }</h2>
					<h2>Price: $${ vehicle.getPrice() }</h2>
				</div>
	
			</c:forEach>
		</div>
		
	</body>
</html>