<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Sorry !! Something went Wrong</title>
</head>
<body>
<div class="container p-3 text-center">
<img alt="" src="image/somethingWentWrong.png" class="img-fluid">
<h1 >Sorry !! Something went Wrong</h1>
<p><%=exception %> </p>
<a class="btn btn-outline-primary" href="/ExceptionJSP"> Home Page</a>
</div>

</body>
</html>