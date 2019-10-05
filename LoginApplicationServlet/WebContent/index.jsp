
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-validate");//HTTP 1.1
		response.setHeader("Pragma", "no-cache");//HTTP 1.0
		response.setHeader("Expires", "0");//for proxy server
		if (session.getAttribute("username") == null)
			response.sendRedirect("login.jsp");
	%>
	Welcome: ${username}

	<form action="logout">
		<input type="submit" value="log out">
	</form>
</body>
</html>