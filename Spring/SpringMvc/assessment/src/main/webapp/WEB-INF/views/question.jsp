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
</head>
<body>

	<%-- <div class="container">
	<h1>${user.id }</h1>
	<h1>${user.name }</h1>
	<h1>${user.rollno }</h1>
	<h1>${user.user_class }</h1>
	</div> --%>
<%int qno=1; %>
	<div class="container">
		<div class="card">
			<div class="card-header text-center">
				<h2 class="card-title">Assignment 1</h2>
			</div>
			<div class="card-body">
				<div class="container mt-4">
					<form>
						<ul class="list-group">
							<c:forEach items="${question }" var="que">
								<!-- Question -->
								<div class="form-group ">
									<label for="question">Question:<%= qno++ %> </label>
									<p class="font-weight-bold">${que.question }</p>
									<!-- Options -->
									<div class="form-check">
										<c:forEach begin="1" end="4" varStatus="option">
											<div class="list-group">
												<input type="radio" class="form-check-input"
													id="${option.index }" name="question" required
													value="option1"> <label for="${option.index }">
													<a
													class="list-group-item list-group-item-action list-group-item-secondary">
														This is a secondary list group item </a>

												</label>
											</div>
										</c:forEach>
									</div>
								</div>

							</c:forEach>
						</ul>
						<div class="container text-center">
							<button type="submit" class="btn btn-primary btn-lg">Submit</button>
							<button type="submit" class="btn btn-danger btn-lg">Exit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>