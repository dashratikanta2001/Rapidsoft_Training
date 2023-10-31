<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<form action="regForm" method="post">
		Name: <input required type="text" name="name1" /><br> <br> Email: <input
			type="text" name="email1" required/><br> <br> Password: <input
			type="password" name="pass1" required/><br> <br> Gender: <input
			type="radio" name="gender1" value="male"required/>Male <input type="radio"
			name="gender1" value="female"required/>Female <br> <br> City: <select
			name="city1" required>
			<option value="">Select City</option>
			<option value="BBSR">BBSR</option>
			<option value="CTC">CTC</option>
			<option value="BLS" >BLS</option>
			<option value="RKL">RKL</option>
		</select> <br> <br> <input type="submit" value="Register" />
	</form>
</body>
</html>