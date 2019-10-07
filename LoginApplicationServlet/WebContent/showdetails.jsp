<%@page import="java.io.PrintWriter"%>
<%@page import="com.bridgelabz.model.User"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.bridgelabz.dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Details Page</title>
<link rel="icon" href="img/icon/favicon-16x16.png" type="image"
	sizes="16x16">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		User user = new User();
		response.setHeader("Cache-Control", "no-cache, no-store, must-validate");//HTTP 1.1
		response.setHeader("Pragma", "no-cache");//HTTP 1.0
		response.setHeader("Expires", "0");//for proxy server
		if (session.getAttribute("username") == null)
			response.sendRedirect("login.jsp");
		else {
			String username = String.valueOf(session.getAttribute("username"));
			Dao dao = new Dao();

			try {
				ResultSet rs = dao.readAllFromDatabase(username);
				if (rs.next()) {
					user.setFname(rs.getString("fname"));
					user.setLname(rs.getString("lname"));
					user.setUsername(rs.getString("username"));
					user.setDateupdated(rs.getString("dateupdated"));
				}
			} catch (Exception ex) {

			}

		}
	%>
	<div class="container text-center" style="margin: 50px;">
		<form action="Logout">
			<div class="text-center" style="margin-bottom: 20px;">
				<input type="submit" class="btn btn-primary" value="Log out">
				<a href="index.jsp">go back</a>
			</div>
		</form>
		<a class="btn btn-primary" data-toggle="collapse"
			href="#collapseExample" role="button" aria-expanded="false"
			aria-controls="collapseExample">Show All Details </a>

		<div class="collapse" id="collapseExample" style="margin: 50px;">
			<div class="card card-body">
				<p class="text-muted">First name:</p>
				<p class="text-monospace">
					<%
						out.print(user.getFname());
					%>
				</p>
				<p class="text-muted">Last name:</p>
				<p class="text-monospace">
					<%
						out.print(user.getLname());
					%>
				</p>
				<p class="text-muted">User name:</p>
				<p class="text-monospace">
					<%
						out.print(user.getUsername());
					%>
				</p>
				<p class="text-muted">Last Update Date:</p>
				<p class="text-monospace">
					<%
						out.print(user.getDateupdated());
					%>
				</p>
			</div>
		</div>
	</div>

</body>
</html>