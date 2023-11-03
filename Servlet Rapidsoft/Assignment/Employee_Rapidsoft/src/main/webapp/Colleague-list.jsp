<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>


<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

</head>
<body style="background: #4db6ac; font-size: 20px;">

	<div class="container">

		<div class="row" style="margin-top: auto; margin-bottom: auto;">
			<div class="col m8 offset-m2">

				<div class="card">
					<div class="card-content indigo lighten-1 center white-text">
						<h2 class="red-text">Employee detail</h2>
						<table class="responsive-table">
							<thead>
								<tr>
									<th>Name</th>
									<th>Employee Code</th>
									<th>Phone No</th>
									<th>Age</th>
									<th>Experience in this company</th>
								</tr>
							</thead>

							<tbody>
								<tr>
									<td>Alvin</td>
									<td>Alan</td>
									<td>Jonathan</td>
									<td>Alvin</td>
									<td>Alan</td>
								</tr>
								<tr>
									<td>Alvin</td>
									<td>Alan</td>
									<td>Jonathan</td>
									<td>Alvin</td>
									<td>Alan</td>
								</tr>
								<tr>
									<td>Alvin</td>
									<td>Alan</td>
									<td>Jonathan</td>
									<td>Alvin</td>
									<td>Alan</td>
								</tr>
								<tr>
									<td>Alvin</td>
									<td>Alan</td>
									<td>Jonathan</td>
									<td>Alvin</td>
									<td>Alan</td>
								</tr>
								<tr>
									<td>Alvin</td>
									<td>Alan</td>
									<td>Jonathan</td>
									<td>Alvin</td>
									<td>Alan</td>
								</tr>
							</tbody>
						</table>
						<form action="Colleague-list" method="post">
							<button type="submit"
								class="waves-effect waves-light btn-large red"
								style="margin-top: 5em;">Colleague List</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>