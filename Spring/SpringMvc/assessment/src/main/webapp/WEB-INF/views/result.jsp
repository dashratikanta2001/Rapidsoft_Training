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


.borderless th, .borderless td {
    border: none !important;
  }
  
  
</style>

<%@include file="./plugins.jsp"%>

</head>

<body>
	<div class="container mt-4">

		<div class="card" style="min-height: fit-content;">
			<div class="card-body">

				<div class="card" style="min-height: fit-content">
					<div class="card-body">

						<div class="table-responsive">
							<table class="table borderless mt-4">
								<tbody>
									<tr>
										<th scope="row" class="text-left ">Student Name:</th>
										<td class="text-left">${marks.name}</td>
									</tr>
									<tr>
										<th scope="row" class="text-left">Student Email id:</th>
										<td class="text-left ">${marks.email}</td>
									</tr>
									<tr>
										<th scope="row" class="text-left">Student Class:</th>
										<td class="text-left ">${marks.userClass}</td>
									</tr>
								</tbody>
							</table>
						</div>
						
						
					</div>
				</div>

				<div class="table-responsive">
					<table class="table table-hover mt-4">
						<thead class="thead-dark ">
							<tr>
								<th scope="col">Test No.</th>
								<th scope="col">Total Mark</th>
								<th scope="col">Obtained Mark</th>
								<th scope="col">Grade</th>
							</tr>
						</thead>

						<tbody>

							<c:forEach var="m" items="${marks.testDetails }">
								<tr>
									<th scope="row">Assessment- ${m.testNo }</th>

									<td>${m.totalMark }</td>
									<td>${m.obtainedMark }</td>
									<td>${m.grade }</td>
								</tr>

							</c:forEach>


						</tbody>
					</table>
					<h2 class="text-center text-danger">${msg }</h2>
				</div>
			</div>
			
			<div class="card-footer text-center">
			<a href="home">
				<input type="button" class="btn btn-danger" value="Home">
			</a>
			</div>
		</div>

	</div>
</body>
</html>