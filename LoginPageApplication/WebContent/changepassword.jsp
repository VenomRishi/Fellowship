<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
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
	<div class="container" style="margin-top: 20px;">
		<div class="d-flex justify-content-center ">
			<div class="card bg-light text-dark" style="width: 300px">
				<img class="card-img-top" src="img/img_avatar1.png" alt="Card image"
					style="width: 100%; height: 240px">
				<div class="card-body">
					<h4 class="card-title">Forgot password</h4>
					<form action="changepassword" method="post">
						<input type="hidden" name="email"
							value="<%=request.getParameter("email")%>"> New password:
						<input class="form-control" type="password" name="password">
						confirm password: <input class="form-control" type="password"
							name="cpassword"> <br>
						<div class="text-center">
							<input type="submit" value="Change Password"
								class="btn btn-primary">
						</div>
					</form>

				</div>

			</div>
		</div>
	</div>
</body>
</html>