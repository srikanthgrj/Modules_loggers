<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<body>

</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
body {
	background-image:
		url("Best-and-Worst-Fast-Furious-Couples-featured.webp");
	height: 400px; /* You must set a specified height */
	background-position: 80%; /* Center the image */
	background-repeat: no-repeat; /* Do not repeat the image */
	background-size: cover;
}
</style>
<title>SignUp</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="./index.jsp">Racing Time</a>
			</div>
			<ul class="nav navbar-nav">



			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="./index.jsp"><span class="glyphicon "></span>
						Home</a></li>
			</ul>
		</div>
	</nav>
	<div>
		<div class="col-xs-2">
			<h2>SignUP to Race</h2>
			<form action="Signup.do" method="post">
				<div class="form-group" style="color: white">
					<label for="username">User name:</label> <input type="text"
						class="form-control" id="username" placeholder="Enter user_name"
						name="username" required>
				</div>
				<div class="form-group" style="color: white">
					<label for="email">Email:</label> <input type="text"
						class="form-control" id="email" placeholder="Enter email"
						name="email" required>
				</div>
				<div class="form-group" style="color: white">
					<label for="mobnum">Mobil Number:</label> <input type="text"
						class="form-control" id="" placeholder="Enter mobil_number"
						name="mobnum" required>
				</div>
				<div class="form-group" style="color: white">
					<label for="pwd">Password:</label> <input type="password"
						class="form-control" id="pwd" placeholder="Enter password"
						name="pwd" required>
				</div>
				<div class="form-group" style="color: white">
					<label for="conpwd">Confirm Password:</label> <input
						type="password" class="form-control" id="conpwd"
						placeholder="Conform password" name="conpwd" required>
				</div>

				<button type="submit" class="btn btn-default">Sign UP</button>
			</form>
		</div>
	</div>
	
	<div align="left">
		<span style="color: green; font-family: cursive;">${successmessage}</span>
		<span style="color: red; font-family: cursive;">${failuremessage}</span>
	</div>

</body>
</html>
