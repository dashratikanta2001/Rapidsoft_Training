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

	<div class="container mt-4">

		<div class="card">
		<div class="card-header">
		<h2 class="text-center">Add Student details</h2>
		</div>
			<div class="card-body">
				<form action="add-user" method="post" >
				<div class="form-group">
						<label for="name">Name</label> <input type="text"
							class="form-control" id="name" placeholder="Enter Name" name="name" required>
					</div>
					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email"
							placeholder="Apartment, studio, or floor" name="email" required>
					</div>
					<div class="form-group">
						<label for="rollno">Roll No</label> <input type="text"
							class="form-control" id="rollno"
							placeholder="Roll no" name="rollno" required>
					</div>
					
						<div class="form-group">
							<label for="class">State</label> <select id="class"
								class="form-control" name="user_class" required>
								<option selected value="">Choose...</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
								<option>8</option>
								<option>9</option>
								<option>10</option>
							</select>
						</div>
					
					<button type="submit" class="btn btn-primary">Register</button>
				</form>
			</div>
		</div>

	</div>
</body>
</html>