<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./plugins.jsp"%>
<style>
.card-body {
	font-size: 1.3rem;
}
</style>

<script>
        function confirmExit() {
            var shouldExit = confirm("Are you sure you want to exit the exam?");
            if (shouldExit) {
                // Redirect to the home page
                window.location.href = "/assessment";
            }
        }
    </script>
</head>
<body>

<%-- 	<c:forEach var="entry" items="${question.entrySet() }">
		<h2>${entry.key.question_id}: ${entry.key.question }</h2>
		<c:forEach items="${entry.value }" var="op">
			<h4>${op.q_option }</h4>
		</c:forEach>
	</c:forEach> --%>

	<%
	int qno = 1;
	%>
	<div class="container">
		<div class="card">
			<div class="card-header text-center bg-secondary">
				<div class="card-title ">
				<h1 class="text-white font-weight-bold">Class ${user_class }</h1>
				<h2 class="text-white">Assignment ${test }</h2>
				
				</div>
			</div>
			<div class="card-body">
				<div class="container mt-4">
					<form action="submitExam" method="post" modelAttribute="examForm">
					<input type="hidden" value="${test }" name="testNO">
					<input type="hidden" value="${userId }" name="userId">
						<ul class="list-group">
							<c:forEach var="entry" items="${question.entrySet() }">
								<!-- Question -->
								<div class="form-group ">
									<label for="question">Question:<%=qno++%>
									</label>
									<p class="font-weight-bold">${entry.key.question }</p>
									<!-- Options -->
									<div class="form-check">
										<c:forEach items="${entry.value }" var="op">
											<div class="list-group">
												<input type="radio" class="form-check-input"
													<%-- id="${op.option_id }" name="${entry.key.question_id}" --%>
													id="${op.option_id }" name="selectedOptions[${entry.key.question_id}]"
													required value="${op.option_id}"> <label
													for="${op.option_id}"> <a
													class="list-group-item list-group-item-action list-group-item-secondary">

														<c:out value="${op.q_option}" escapeXml="true" />
												</a>

												</label>
											</div>
										</c:forEach>
									</div>
								</div>

							</c:forEach>
						</ul>
						<div class="container text-center">
							<button type="submit" class="btn btn-primary btn-lg">Submit</button>
							<input type="button" class="btn btn-danger btn-lg" value="Exit" onclick="confirmExit()">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>