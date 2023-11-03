<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<meta charset="UTF-8">
<title>login</title>
</head>
<body style="background: #4db6ac;">
	<div class="container">

		<div class="row">
			<div class="col m6 offset-m3">

				<div class="card indigo lighten-1 center">
					<div class="card-content center white-text">
						<h3 class="center">Login here !!</h3>
						<h5 id="msg"></h5>

						<div class="form ">
							<!-- creating form -->

							<form action="Login" method="post" id="loginform">
								<p class="left">Phone Number</p>
								<input required type="text" name="user_phno"
									placeholder="Enter phone number" />

								<p class="left">Password</p>
								<input required type="password" name="user_password"
									placeholder="Enter password" /><br>
								<br>
								<br>

								<button type="submit"
									class="waves-effect waves-light btn-large blue">
									<i class="material-icons left">login</i>Login
								</button>
								<p>Not have an Account? <a href="signup.jsp" >Register Here</a>

							</form>
						</div>

						<div class="loader" style="margin-top: 5em; display: none;">
							<div class="progress white">
								<div class="indeterminate green"></div>
							</div>
							<h5 class="center" style="color: red;">Please wait</h5>
						</div>
					</div>
				</div>

			</div>
		</div>

	</div>
	<footer class="page-footer" style="bottom:0; position: fixed; width: 100%; font-size: 15px;">
		<div class="footer-copyright">
			<div class="container center">
				Copyright © Rapidsoft Technology 
			</div>
		</div>
	</footer>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			//console.log("Its ready.......")

			$("#loginform").on('submit', function(event) {
				event.preventDefault();

				var f = $(this).serialize();

				//console.log(f);

				$.ajax({

					url : "Login",
					data : f,
					type : "POST",
					success : function(data, textStatus, jqXHR) {
						//console.log(data);
						//console.log("success");
						$(".loader").hide();
						$(".form").show();
						if (data.trim() === "Invalid Cridential") {
							$('#msg').html("Invalid Cridential");
							$('#msg').addClass('red-text')
						}
						  else {
							$('.row').html(data)
						}  
					},
					error : function(jqXHR, textStatus, errorThrown) {
						//console.log(data);
						//console.log("error");
						$(".loader").hide();
						$(".form").show();
						$('#msg').html("Something Went Wrong on server");
						$('#msg').addClass('red-text')
						//console.log("in error error")
					}

				})

			})
		})
	</script>
</body>
</html>