<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>
	<h1>This is home page</h1>

	<%
	String name = (String) request.getAttribute("name");
	Integer id = (Integer) request.getAttribute("id");
	List<String> friends = (List<String>) request.getAttribute("friends");
	%>

	<h1>
		Name =
		<%=name%>
	</h1>
	<h1>
		Id =
		<%=id%>
	</h1>

	<%
	for (String s : friends) {
	%>
	<h3><%=s%></h3>
	<%
	}
	%>

</body>
</html>