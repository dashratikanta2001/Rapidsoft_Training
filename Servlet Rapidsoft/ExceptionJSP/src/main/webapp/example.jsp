<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="WEB-INF/mylib.tld" prefix="t"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome taglib</h1>
	<t:mytag></t:mytag>

	<t:printTable number="10" color="red"></t:printTable>
	<t:printTable number="100" color="blue"></t:printTable>
	<t:printTable number="30"></t:printTable>

<!-- 	JSP Implicit objects -->

	<%
	out.print("This is my implicit object<br>");
	
	//request.getParameter("");
	//response.sendRedirect("");
	//config(ServletConfig)
	//application(ServletContext)
	
	//session
	
	out.println(session.isNew());
	session.setAttribute("name", 23);
	
	//page: current jsp page:	
		
	//exception: Throwable..
	
	//pageContext: PageContext
	
	%>
</body>
</html>