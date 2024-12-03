<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import= "com.dealership.server.HomepageServlet" %>
<%@ page import= "com.dealership.server.Vehicle" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Homepage</title>
		<style><%@include file="index.css"%></style>
	</head>
	<body>
		<nav class="nav-header">
			<c:if test="${ !HomepageServlet.recentPurchase.isEmpty() }">
				<div class="recent-purchase">

					<ul>
						<li>A customer has just recently purchased:</li>
						<c:forEach  items="${HomepageServlet.recentPurchase}" var="vehicle" >
								<li>x1 ${ vehicle.getYear()} ${ vehicle.getMake()} ${ vehicle.getModel()}</li>			
						</c:forEach>
					</ul>
					
				</div>
			</c:if>
			<h1>AutoMax</h1>
			<div class="nav-links">
				<a href="./marketplace?sort=car">Cars</a>
				<a href="./marketplace?sort=motorcycle">Motorbikes</a>
				<a href="./marketplace?sort=boat">Boats</a>
				<a href="./marketplace?sort=none">All Vehicles</a>
			</div>
			
		</nav>

		<header class="main-header">
			<p class="hero-text">
				Your journey, your choice - by land or sea. Navigate life your way.
			</p>
		</header>
		<section class="main-bike">
			<p class="hero-text">Experience the thrill of two wheels</p>
		</section>
		<section class="main-boat">
			<p class="hero-text">Set sail for new horizons</p>
		</section>

		<main>
			<header>
				<h2>Browse vehicles</h2>
				<ul>
					<li>
						<img src="img/car.jpg" alt="Car" width="300" height="200" />
						<a href="./marketplace?sort=car">Cars</a>
					</li>
					<li>
						<img
							src="img/motorbike.jpg"
							alt="Motorcycle"
							width="300"
							height="200"
						/>
						<a href="./marketplace?sort=motorcycle">Motorbikes</a>
					</li>
					<li>
						<img src="img/boat.jpg" alt="Boat" width="300" height="200" />
						<a href="./marketplace?sort=boat">Boats</a>
					</li>
				</ul>
			</header>
		</main>

		<footer>
			<p id="copyright">Copyright &copy; AutoMax 2024.</p>
		</footer>
		
	</body>
</html>