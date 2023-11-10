<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background: gray;">
	<h1>This is page2</h1>

	<%
	//Redirection
	response.sendRedirect("page3.jsp");
	%>
</body>
</html>