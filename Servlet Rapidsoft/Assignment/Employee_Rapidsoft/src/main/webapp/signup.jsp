<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<title>Register</title>
</head>
<body style="background: #4db6ac; font-size: 20px;">
	<div class="container">

		<div class="row" style="margin-top: auto; margin-bottom: auto;">
			<div class="col m8 offset-m2">

				<div class="card">
					<div class="card-content indigo lighten-1 center">
						<h5 id="msg"></h5>
						<h3 class="center">Register here !!</h3>
						<h5 id="msg"></h5>

						<div class="form" style="color: white">
							<!-- creating form -->

							<form action="Register" method="post" id="signupform">

								<p class="left">First Name</p>
								<input required type="text" name="user_fname"
									placeholder="Enter First Name" />

								<p class="left">Last Name</p>
								<input required type="text" name="user_lname"
									placeholder="Enter Last Name" />

								<p class="left">Email</p>
								<input required type="email" name="user_email"
									placeholder="Enter email" />


								<p class="left">Date of Birth</p>
								<input required type="date" name="user_dob"
									placeholder="Select Date of Birth" />

								<p class="left">Phone Number</p>
								<input required type="text" name="user_phno"
									placeholder="Enter Phone Number" />

								<p class="left">Employee code</p>
								<input required type="text" name="user_empcode"
									placeholder="Enter your Employee code" />

								<p class="left">Password</p>
								<input required type="password" name="user_password"
									placeholder="Enter password" />

								<p>
								<p class="left">Gender</p>
								<label> <input required type="radio" name="user_gender"
									class="with-gap" style="color: white" value="Male" /> <span>Male</span>
								</label> <label> <input required type="radio" name="user_gender"
									class="with-gap" value="Female" /> <span>Female</span>
								</label> <label> <input required type="radio" name="user_gender"
									class="with-gap" value="Other" /> <span>Other</span>
								</label>
								</p>

								<button type="submit"
									class="waves-effect waves-light btn-large red"
									style="margin-top: 5em;">
									<i class="material-icons left">input</i>SignUp
								</button>

							</form>


						</div>
						
						<div class="loader" style="margin-top: 20vh; display: none;">
							<div class="progress">
								<div class="indeterminate"></div>
							</div>
							<h5 class="center" style="color: green;" id="waitmsg">Please wait</h5>
						</div>
					</div>
				</div>

			</div>
		</div>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script type="text/javascript">
	
	$(document).ready(function(){
		console.log("ready...........")
		
		$("#signupform").on('submit', function(event){
			
		//	event.preventDefault();
			
			var f = $(this).serialize();
			
			console.log(f);
			$(".loader").show();
			$(".form").hide();
			$.ajax({
				
				url:"Register",
				data:f,
				type:"POST",
				success:function(data,textStatus,jqXHR){
					
					console.log("data="+data);
					let dd = data.trim("success");
					console.log("dd = == == = "+dd[0]);
					console.log("textStatus = "+textStatus);
					console.log("Success......");
					$(".loader").hide();
					if (textStatus.trim()==="success") {
						console.log("Success...... in if condition	");
						
						$('#waitmsg').html("Redirecting to homepage...")
						$('#waitmsg').addClass('red-text')
						$(".loader").show();
						$('input').val("");
						setTimeout(function(){},3000);
					}else {

						$(".form").show();
						$('#msg').html("Something Went Wrong on server");
						$('#msg').addClass('red-text')
						console.log("In success error");
					}
					
				},
				error:function(jqXHR, textStatus, error){

					$(".form").show();
					console.log(data);
					console.log("Error.......");
					$(".loader").hide();
					$(".form").show();
					$('#msg').html("Something Went Wrong on server");
					$('#msg').addClass('red-text')
				}
				
			})
			
		})
		
		
	})
	
	</script>
</body>
</html>