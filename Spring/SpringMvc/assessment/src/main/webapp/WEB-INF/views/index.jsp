<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<style>
.card-img-top {
	height: 200px;
}

.card {
	min-height: 50vh;
}
</style>

<%@include file="./plugins.jsp"%>

</head>

<body>

<c:set var="actionURL" value="newActionURL" />
	<!-- Navbar Started -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand ml-5" href="#">Quiz App</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav m-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home</a>
				</li>
				<li class="nav-item"><a href="#" class="nav-link" onclick="startAssessment()"
					 data-toggle="modal"
					data-target="#exampleModalCenter">Start Assessment</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Result </a>
					<div class="dropdown-menu bg-dark" aria-labelledby="navbarDropdown">
						<a class="dropdown-item text-white" onclick="resultById()" href="#"  data-toggle="modal"
					data-target="#exampleModalCenter">Result by ID</a> <a
							class="dropdown-item text-white" href="student-result">Result by Class</a> <a
							class="dropdown-item text-white" onclick="applyRecheck()" href="#" data-toggle="modal"
					data-target="#exampleModalCenter">Apply for Recheck</a>
					</div></li>
			</ul>

			<ul class="navbar-nav ">
				<li class="nav-item"><a class="nav-link" href="admin-dashboard">Admin</a></li>
			</ul>
		</div>
	</nav>

	<!-- Navbar Ended -->
	<!-- Your page content goes here -->

	<c:if test="${not empty msg }">
		<script>
			$(document).ready(function() {
				var msgg ="${msg}";
				alert(msgg);
			});
		</script>
	</c:if>

	<div class="container mt-4">
		<!-- Modal -->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<form  method="post" id="assessmentForm">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle"></h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label for="exampleInputEmail1 ">Email address</label> <input
									required type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter email" name="email"> <small
									id="emailHelp" class="form-text text-muted">We'll never
									share your email with anyone else.</small>
							</div>
							<div class="form-group" id="testnodiv">
								<label for="inputState">Select Test No</label> <select id="inputState"
									name="testNo" class="form-control">
									<option selected>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
								</select>
							</div>
							

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary" id="modalSubmit">Start
								assessment</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<c:set var="msg" value="" scope="request" />

		<!-- Modal closed here -->

		<div class="row mb-5">
			<div class="col-md-4 mb-4">
				<div class="card ">
					<img src='<c:url value="/resources/images/assessment-image.jpeg"/>'
						class="card-img-top" alt="Card Image">
					<div class="card-body">
						<h5 class="card-title">Get Ready to Begin Your Assessment!</h5>
						<p class="card-text">Embark on your journey to knowledge and
							discovery. Click the button below to start your assessment and
							unlock a world of learning.</p>
					</div>
					<div class="card-footer text-center">
						<a href="#" class="btn btn-success "
							data-toggle="modal" data-target="#exampleModalCenter" onclick="startAssessment()">Start
							Assessment</a>

					</div>
				</div>
			</div>

			<div class="col-md-4 mb-4">
				<div class="card">
					<img src='<c:url value="/resources/images/result-image.jpeg"/>'
						class="card-img-top" alt="Card Image">
					<div class="card-body">
						<h5 class="card-title">Your Assessment Results</h5>
						<p class="card-text">Congratulations on completing the
							assessment! Your results are now available.</p>
					</div>
					<div class="card-footer text-center">
						<a href="#" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter" onclick="resultById()">View Results</a>
					</div>
				</div>
			</div>

			<div class="col-md-4 mb-4">
				<div class="card">
					<img src='<c:url value="/resources/images/recheck-image.png"/>'
						class="card-img-top" alt="Card Image">
					<div class="card-body">
						<h5 class="card-title">Recheck Your Assessment</h5>
						<p class="card-text">If you believe there might be an error or
							would like a reevaluation, you can apply for a recheck of your
							assessment.</p>
					</div>
					<div class="card-footer text-center">
						<a href="#" class="btn btn-primary" onclick="applyRecheck()" data-toggle="modal"
					data-target="#exampleModalCenter">Apply for Recheck</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer class="footer"
		style="background-color: rgba(255, 255, 255, 0.7);">
		<div class="container text-center">
			<p>
				&copy; 2023 <a href="home">Quizapp.</a> All rights reserved.
			</p>
		</div>
	</footer>

<script>

function startAssessment() {
	document.getElementById("testnodiv").style.display = "inline";
	var form = document.getElementById("assessmentForm");
	form.action = "startAssessment";
	document.getElementById("exampleModalLongTitle").innerText="Enter Email Id to start assessment";
	document.getElementById("modalSubmit").innerText="Start Assesment";
	
}

function resultById() {
	
	document.getElementById("testnodiv").style.display = "none";
	var form = document.getElementById("assessmentForm");
	form.action = "student-result";
	document.getElementById("exampleModalLongTitle").innerText="Enter Email Id to show result";
	document.getElementById("modalSubmit").innerText="Show Result";

}
function applyRecheck() {
	
	document.getElementById("testnodiv").style.display = "inline";
	var form = document.getElementById("assessmentForm");
	form.action = "recheck-apply";
	document.getElementById("exampleModalLongTitle").innerText="Enter Email Id to Apply for Recheck";
	document.getElementById("modalSubmit").innerText="Apply";

}


</script>
</body>
</html>
