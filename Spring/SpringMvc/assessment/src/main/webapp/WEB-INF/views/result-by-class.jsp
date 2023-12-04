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

/* .borderless th, .borderless td {
	border: none !important;
} */
</style>

<%@include file="./plugins.jsp"%>

</head>

<body>
	<div class="container mt-4">
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<form method="post" id="assessmentForm"
						action="student-result-by-class">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle"></h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">

							<div class="form-group" id="testnodiv">
								<label for="inputState">Select Class</label> <select
									id="inputState" name="stdClass" class="form-control">
									<c:forEach items="${classList}" var="classno">
										<option>${classno }</option>
									</c:forEach>

								</select>
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary" id="modalSubmit">Show
								Result</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<c:set var="msg" value="" scope="request" />

		<!-- Modal closed here -->

		<div class="card" style="min-height: fit-content;">
		<c:if test="${not empty classList }">
			<script>
				$(document).ready(function() {
					$('#exampleModalCenter').modal('show');
				});
			</script>
			<div class="card-header text-center">
				<h2>Select Class to show result</h2>
				<input type="button" class="btn btn-primary" value="Select Class"
					data-toggle="modal" data-target="#exampleModalCenter">
			</div>
		</c:if>

			<c:if test="${not empty userList }">

				<div class="card-body">



					<div class="table-responsive">
						<table class="table table-hover mt-4 table-bordered">
							<thead class="thead-dark ">
								<tr>
									<th rowspan="2" scope="col" class="align-middle">#</th>
									<th rowspan="2" scope="col" class="align-middle">Name</th>
									<th rowspan="2" scope="col" class="align-middle">Roll no</th>
									<th rowspan="2" scope="col" class="align-middle">Class</th>
									<th colspan="2" scope="colgroup" class="text-center">Ass-1</th>
									<th colspan="2" scope="colgroup" class="text-center">Ass-2</th>
									<th colspan="2" scope="colgroup" class="text-center">Ass-3</th>
									<th colspan="2" scope="colgroup" class="text-center">
										Ass-4</th>
								</tr>
								<tr>
									<th scope="colgroup">Mark</th>
									<th scope="colgroup">Grade</th>
									<th scope="colgroup">Mark</th>
									<th scope="colgroup">Grade</th>
									<th scope="colgroup">Mark</th>
									<th scope="colgroup">Grade</th>
									<th scope="colgroup">Mark</th>
									<th scope="colgroup">Grade</th>
								</tr>
							</thead>
							<tbody>
								<%
								int Slno = 1;
								%>
								<c:forEach var="user" items="${userList }">
									<tr>
										<th scope="row"><%=Slno++%></th>
										<td>${user.name}</td>
										<td>${user.rollno}</td>
										<td>${user.userClass}</td>
										<c:forEach var="i" begin="1" end="4">

											<c:set value="false" var="available" />
											<c:set value="0" var="mark" />
											<c:set value="" var="grade" />
											<c:forEach var="test" items="${user.testDetails }">
												<c:if test="${test.testNo == i }">
													<c:set value="true" var="available" />
													<c:set value="${test.obtainedMark }" var="mark" />
													<c:set value="${test.grade }" var="grade" />
												</c:if>
											</c:forEach>
											<c:if test="${available }">
												<td>${ mark}</td>
												<td>${ grade}</td>
											</c:if>
											<c:if test="${not available }">
												<td colspan="2" class="text-center text-danger">NA</td>
											</c:if>

										</c:forEach>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>


				</div>

			</c:if>
			
			<div class="card-footer text-center">
			<a href="home">
				<input type="button" class="btn btn-danger" value="Home">
			</a>
			</div>
		</div>


		</div>
	</div>


</body>
</html>