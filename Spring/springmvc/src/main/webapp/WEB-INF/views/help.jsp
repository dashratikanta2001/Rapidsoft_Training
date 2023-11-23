<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Help page</title>
</head>
<body>

	<%
	/* 	String name = (String) request.getAttribute("name");
		Integer rollno = (Integer) request.getAttribute("rollno");
		LocalDateTime time = (LocalDateTime) request.getAttribute("time"); */
	%>


	<h1>
		Hello My name is
		<%-- <%=name%> --%>
		${name}
	</h1>
	<h2>This is help page</h2>
	<h1>
		Hello Roll no is
		
		<%-- <%=rollno%> --%>
		
		${rollno}
	</h1>
	<h2>
		Time =
		<%-- <%=time%></h2> --%>
		${time}
	</h2>

	<hr>

	<%-- <h2>List = 
	${marks }
	
	</h2> --%>

	<c:forEach var="item" items="${marks }">
		<%-- 
		<h3>${item }</h3> --%>
		<h3>
			<c:out value="${item }" />
		</h3>

	</c:forEach>
</body>
</html>