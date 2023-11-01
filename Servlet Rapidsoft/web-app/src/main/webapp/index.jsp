<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to homepage of servlet project</h1>
<p>This is servlet testing</p>

<%= new Date().toLocaleString() %>

<br>
<a href="login">Login Servlet</a>

<h1><a href="web">First Servlet</a></h1>
<h1><a href="second">Second Servlet</a></h1>
<h1><a href="servlet">Third Servlet</a></h1>


</body>
</html>