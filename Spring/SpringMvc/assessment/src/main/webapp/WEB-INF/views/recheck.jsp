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



				<div class="table-responsive">
					<table class="table table-hover mt-4 table-bordered">
						<thead class="thead-dark ">
							<tr>
								<th class="align-middle">#</th>
								<th class="align-middle">Name</th>
								<th class="align-middle">Email</th>
								<th class="align-middle">Roll no</th>
								<th class="align-middle">Class</th>
								<th class="col-2" class="text-middle">Applied recheck test
									No</th>
							</tr>

						</thead>
						<tbody>
						

							<%
							int Slno = 1;
							%>
							<c:forEach var="list" items="${recheckList }">
								<tr>
									<th scope="row"><%=Slno++%></th>
									<td>${list.user.name}</td>
									<td>${list.user.email}</td>
									<td>${list.user.rollno}</td>
									<td>${list.user.user_class}</td>
									<td>${list.test_no }</td>
								</tr>
							</c:forEach>
						</tbody>
						
					</table>
					
							<c:if test="${empty recheckList }">
								<div class="container text-center text-danger">
									<h2>No record found</h2>
								</div>
							</c:if>
				</div>


			</div>

			<div class="card-footer text-center">
				<a href="admin-dashboard"> <input type="button"
					class="btn btn-danger" value="Home">
				</a>
			</div>
		</div>

	</div>


</body>
</html>