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
			<c:forEach items="${MarketplaceServlet.vehicles}" var="vehicle" varStatus="loop">
			
				<div class="marketplace-card">
					<h2>Lot #<span id="lot-id">${ loop.count }</span></h2>
					<img src=${ vehicle.getImageLink() } alt=${ vehicle.getMake() } width="300" height="300">
					<h2>Make: ${ vehicle.getMake() }</h2>
					<h2>Model: ${ vehicle.getModel() }</h2>
					<h2>Year: ${ vehicle.getYear() }</h2>
					<h2>Price: $${ vehicle.getPrice() }</h2>
					<h2>${ vehicle.getSpecialFeatures() }</h2>
					<c:if test= "${ vehicle.getInStock()  }">
							<form method="post">
								<c:if test= "${ vehicle.getInCart() }">
									<button name="lotIndex" value="${ loop.index }">Remove from Cart</button>
								</c:if>
								<c:if test= "${ !vehicle.getInCart() }">
									<button name="lotIndex" value="${ loop.index }">Add to Cart</button>
								</c:if>
								
							</form>
						</c:if>
					<c:if test= "${ !vehicle.getInStock()  }"><button disabled>Sold Out</button></c:if>
				</div>

			</c:forEach>
		</div>
		
		<<!-- nav class="nav-header">
			<h1>AutoMax</h1>
			<div class="nav-links">
				<a href="#">Cars</a>
				<a href="#">Motorbikes</a>
				<a href="#">Boats</a>
				<input
					type="text"
					placeholder="Search by make, model, or body style..."
				/>
			</div>
			<div class="topcorner">
				<button>View Cart</button>
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
				<h2>Research vehicles</h2>
				<ul>
					<li>
						<img src="img/car.jpg" alt="Car" width="300" height="200" />
						<a href="#">Cars</a>
					</li>
					<li>
						<img
							src="img/motorbike.jpg"
							alt="Motorcycle"
							width="300"
							height="200"
						/>
						<a href="#">Motorbikes</a>
					</li>
					<li>
						<img src="boat.jpg" alt="Boat" width="300" height="200" />
						<a href="#">Boats</a>
					</li>
				</ul>
			</header>
		</main>

		<aside>
			<h3>Shop vehicles your way</h3>
			<ul class="shop-options">
				<li class="dropdown">
					<a href="#" class="dropbtn">By Body Type</a>
					<div class="dropdown-content">
						<div class="vehicle-category">
							<h4>Cars</h4>
							<a href="#">Convertible</a>
							<a href="#">Sedan</a>
							<a href="#">Coupe</a>
							<a href="#">Hatchback</a>
							<a href="#">Sports</a>
							<a href="#">SUV</a>
							<a href="#">Van</a>
							<a href="#">Truck</a>
						</div>
						<div class="vehicle-category">
							<h4>Motorbikes</h4>
							<a href="#">Sports</a>
							<a href="#">Cruiser</a>
							<a href="#">Off Road</a>
							<a href="#">Touring</a>
						</div>
						<div class="vehicle-category">
							<h4>Boats</h4>
							<a href="#">Speed</a>
							<a href="#">Yacht</a>
							<a href="#">Sailboat</a>
						</div>
					</div>
				</li>

				<li class="dropdown">
					<a href="#" class="dropbtn">By Price Range</a>
					<div class="dropdown-content price-ranges">
						<div class="vehicle-category">
							<h4>Cars</h4>
							<a href="#">Under $10,000</a>
							<a href="#">$10,000 - $30,000</a>
							<a href="#">$30,000 - $50,000</a>
							<a href="#">$50,000 - $100,000</a>
							<a href="#">$100,000+</a>
						</div>
						<div class="vehicle-category">
							<h4>Motorbikes</h4>
							<a href="#">Under $5,000</a>
							<a href="#">$5,000 - $10,000</a>
							<a href="#">$10,000 - $20,000</a>
							<a href="#">$20,000+</a>
						</div>
						<div class="vehicle-category">
							<h4>Boats</h4>
							<a href="#">Under $25,000</a>
							<a href="#">$25,000 - $100,000</a>
							<a href="#">$100,000 - $500,000</a>
							<a href="#">$500,000+</a>
						</div>
					</div>
				</li>
				<li><a href="#">New Arrivals</a></li>
			</ul>
		</aside>

		<footer>
			<p id="copyright">Copyright &copy; AutoMax 2024.</p>
		</footer> -->
		
		<div class="cart">
			<h2>Items in cart: ${ MarketplaceServlet.cart.getItems().size() }</h2>
			<a href="./checkout"><button>Go to Checkout</button></a>
		</div>
	</body>
</html>