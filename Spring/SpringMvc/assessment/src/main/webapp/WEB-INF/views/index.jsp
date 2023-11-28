<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body style="background: darkslategray !important;">

	<!-- Navbar Started -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Quiz App</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav m-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Start
						Assessment</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Result </a>
					<div class="dropdown-menu bg-dark" aria-labelledby="navbarDropdown">
						<a class="dropdown-item text-white" href="#">Result by ID</a> <a
							class="dropdown-item text-white" href="#">Result by Class</a> <a
							class="dropdown-item text-white" href="#">Apply for Recheck</a>
					</div></li>
			</ul>
		</div>
	</nav>

	<!-- Navbar Ended -->
	<div class="container mt-4">
		<!-- Your page content goes here -->
		<div class="container mt-4">
			<div class="row text-center" >
				<div class="col-md-4 mb-4">
					<div class="card ">
						<img src='<c:url value="/resources/images/assessment-image.jpeg"/>' class="card-img-top"
							alt="Card Image">
						<div class="card-body">
							<h5 class="card-title">Get Ready to Begin Your Assessment!</h5>
							<p class="card-text">Embark on your journey to knowledge and discovery. Click the button below to start your assessment and unlock a world of learning.</p>
							<a href="#" class="btn btn-primary">Start Assessment</a>
						</div>
					</div>
				</div>

				<div class="col-md-4 mb-4">
					<div class="card">
						<img src='<c:url value="/resources/images/result-image.jpeg"/>' class="card-img-top"
							alt="Card Image">
						<div class="card-body">
							<h5 class="card-title">Your Assessment Results</h5>
							<p class="card-text">Congratulations on completing the assessment! Your results are now available.</p>
							<a href="#" class="btn btn-primary">View Results</a>
						</div>
					</div>
				</div>

				<div class="col-md-4 mb-4">
					<div class="card">
						<img src="https://via.placeholder.com/150" class="card-img-top"
							alt="Card Image">
						<div class="card-body">
							<h5 class="card-title">Card 3</h5>
							<p class="card-text">This is some sample content for Card 3.
								You can add more details here.</p>
							<a href="#" class="btn btn-primary">Learn More</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer class="footer">
		<div class="container text-center">
			<p>&copy; 2023 Your Website. All rights reserved.</p>
		</div>
	</footer>

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
