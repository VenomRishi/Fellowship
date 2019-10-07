
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome Page</title>
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

	<div class="container">
		<div class="d-flex justify-content-center">
			<div class="card bg-light text-dark"
				style="width: 600px; margin: 20px;">
				<%
					response.setHeader("Cache-Control", "no-cache, no-store, must-validate");//HTTP 1.1
					response.setHeader("Pragma", "no-cache");//HTTP 1.0
					response.setHeader("Expires", "0");//for proxy server
					if (session.getAttribute("username") == null)
						response.sendRedirect("login.jsp");
				%>
				<img alt="welcome_image_not_available" src="img/welcome.jpg">
				<p class="h1">Welcome: ${username}
				<p>
				<form action="Logout">
					<div class="text-center" style="margin-bottom: 20px;">
						<input type="submit" class="btn btn-primary" value="log out">
					</div>
				</form>


			</div>

		</div>

	</div>

</body>
</html>