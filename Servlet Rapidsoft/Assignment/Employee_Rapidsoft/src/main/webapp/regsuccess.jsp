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

<title>Insert title here</title>
</head>
<body style="background: #4db6ac; font-size: 20px;">

	<div class="container">

		<div class="row" style="margin-top: auto; margin-bottom: auto;">
			<div class="col m8 offset-m2">

				<div class="card">
					<div class="card-content indigo lighten-1 center">
						<form action="Login" method="get" id="form">
							<h2 id="welcomemsg" class="green-text"></h2>
							<button type="submit"
								class="waves-effect waves-light btn-large red"
								style="margin-top: 5em;">
								<i class="material-icons left">login</i>Login
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	
	<script type="text/javascript">
	$("#form").ready(function(){
		$('#welcomemsg').html("Welcome back!!!!!!!!")
		
		$.ajax({
			
			url:"Register",
			data:"Hello",
			type:"POST",
			success: function(data, textStatus, jqXHR){
				console.log("Text ststus = == = "+textStatus)
			}
			
		})
		
	})
	</script>

</body>
</html>