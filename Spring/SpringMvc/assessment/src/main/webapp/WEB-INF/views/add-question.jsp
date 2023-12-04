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



		<div class="card-header bg-white" id="classSelector">
			<form action="select-class" method="post">
				<div class="form-group" id="classSelect">
					<label for="inputState">Select Class to add question</label> <select
						id="inputState" name="selectedClass" class="form-control" required>
						<option value="">Select Class</option>
						<c:forEach var="i" begin="1" end="10">
							<option>${i }</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group" id="classSelect">
					<label for="inputState">Select Test No to add question</label> <select
						id="inputState" name="selectedTestNo" class="form-control"
						required>
						<option value="">Select Test No</option>
						<c:forEach var="i" begin="1" end="4">
							<option>${i }</option>
						</c:forEach>
					</select>
				</div>
				<div class="container text-center">
					<input type="submit" class="btn btn-primary" value="Select Class">
					<a href="/assessment/admin-dashboard"> <input type="button"
					class="btn btn-danger " value="Home">
				</a>
				</div>
			</form>
		</div>


		<!-- ADDING QUESTION -->
		<c:if test="${not empty selectedClass && not empty selectedTestNo}">
		<script >
		document.getElementById("classSelector").style.display = "none";
		</script>
			<div class="card">
			<div class="card-header">
			<h2>Class : ${ selectedClass}</h2>
			<h2>Test No: ${selectedTestNo }</h2>
			</div>
				<form action="add-Question" method="post" name="setQuestionOption">
				<input type="hidden" name="classNo" value="${ selectedClass}">
				<input type="hidden" name="testNo" value="${ selectedTestNo}">
					<div class="card-body">
						<div id="questionForm">
							<div class="form-group questionGroup" id="questionGroup">
								<div class="form-group">
									<label for="question" id="lebelQ">Question 1:</label> <input
										type="text" class="form-control" id="question"
										name="question[0]" required>
								</div>

								<div class="input-group mb-3">
									<label for="option1">Option 1:</label> <input type="text"
										class="form-control" id="option1" name="option" required>
									<div class="input-group-append">
										<span class="input-group-text">Is answer</span>
										<div class="input-group-text">
											<input type="radio" name="answer[0]" required value="1">
										</div>
									</div>
								</div>

								<div class="input-group mb-3">
									<label for="option2">Option 2:</label> <input type="text"
										class="form-control" id="option2" name="option" required>
									<div class="input-group-append">
										<span class="input-group-text">Is answer</span>
										<div class="input-group-text">
											<input type="radio" name="answer[0]" value="2">
										</div>
									</div>
								</div>

								<div class="input-group mb-3">
									<label for="option3">Option 3:</label> <input type="text"
										class="form-control" id="option3" name="option" required>
									<div class="input-group-append">
										<span class="input-group-text">Is answer</span>
										<div class="input-group-text">
											<input type="radio" name="answer[0]" value="3">
										</div>
									</div>
								</div>

								<div class="input-group mb-3">
									<label for="option4">Option 4:</label> <input type="text"
										class="form-control" id="option4" name="option" required>
									<div class="input-group-append">
										<span class="input-group-text">Is answer</span>
										<div class="input-group-text">
											<input type="radio" name="answer[0]" value="4">
										</div>
									</div>
								</div>
							</div>

						</div>
						<div class="container">
							<div class="text-right">
								<button type="button" class="btn btn-primary"
									onclick="addQuestion()">
									<b>+</b> add question
								</button>
							</div>
						</div>
					</div>
					<div class="card-footer text-center">
						<div class="container text-center">

							<c:set var="questionNo" value="${questionNo+1 }" />
							<button type="submit" class="btn btn-success">Submit</button>
							<a href="/assessment/admin-dashboard"> <input type="button"
					class="btn btn-danger" value="Home">
				</a>

						</div>
					</div>
				</form>
			</div>
		</c:if>
	</div>

	<script>
		let questionCounter = 0;

		function addQuestion() {
			questionCounter++;

			// Clone the existing question group
			const originalQuestionGroup = document
					.getElementById('questionGroup');
			const clonedQuestionGroup = originalQuestionGroup.cloneNode(true);

			// Reset the values of the cloned elements
			const inputElements = clonedQuestionGroup
					.querySelectorAll('input[type="text"], input[type="radio"]');
			inputElements.forEach(function(inputElement) {

				if (inputElement.type === 'radio') {
					inputElement.setAttribute('name', "answer["
							+ questionCounter + "]"); // Update radio input names
					inputElement.checked = false; // Uncheck radio inputs
				} else {
					inputElement.value = ''; // Reset text input values
				}
			});
			const questionval = clonedQuestionGroup
					.querySelector('input[id="question"]');
			questionval.setAttribute('name', "question[" + questionCounter
					+ "]");

			var qno=1+questionCounter;
			const clonedQuestionLabel = clonedQuestionGroup
					.querySelector('label[for="question"]');
			clonedQuestionLabel.textContent = 'Question ' + qno
					+ ':';

			// Append the cloned group to the document
			$("#questionForm").append(clonedQuestionGroup);
		}
	</script>
</body>
</html>