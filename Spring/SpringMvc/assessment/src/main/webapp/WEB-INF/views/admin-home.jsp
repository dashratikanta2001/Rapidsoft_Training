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

<c:if test="${not empty msg }">
<script> alert("${msg}")</script>
</c:if>

	<div class="container mt-4">
		<div class="row mb-5 justify-content-center">
			<div class="container text-center">
				<a href="/assessment/home"> <input type="button"
					class="btn btn-danger btn-lg" value="Home">
				</a>
			</div>
		</div>
		<div class="row mb-5 justify-content-center">
			<div class="col-md-4 mb-4">
				<div class="card">
					<img src='<c:url value="/resources/images/question-image.jpg"/>'
						class="card-img-top" alt="Card Image">
					<div class="card-body">
						<h3 class="card-title text-center">Add questions</h3>

					</div>
					<div class="card-footer text-center">
						<a href="add-question" class="btn btn-success ">Add question</a>

					</div>
				</div>
			</div>

			<div class="col-md-4 mb-4">
				<div class="card">
					<img src='<c:url value="/resources/images/student-image.jpeg"/>'
						class="card-img-top" alt="Card Image">
					<div class="card-body">
						<h3 class="card-title text-center">Add Student</h3>

					</div>
					<div class="card-footer text-center">
						<a href="add-user" class="btn btn-primary">Add Student</a>
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

</body>
</html>