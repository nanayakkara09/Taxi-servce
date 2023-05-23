<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Customer</title>
	 <!-- Add CSS -->
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f2f2f2;
			background-image: url("https://static.vecteezy.com/system/resources/previews/002/944/432/original/online-taxi-service-concept-yellow-taxi-car-and-hand-holding-smartphone-with-taxi-application-on-city-background-illustration-in-flat-style-vector.jpg");
		}

		h1 {
			color: #008080;
		}

		form {
			max-width: 500px;
			margin: 0 auto;
			background-color: #fff;
			padding: 20px;
			border: 1px solid #ccc;
			box-shadow: 2px 2px 5px #ccc;
		}

		label {
			display: block;
			margin-bottom: 10px;
		}

		input[type="text"],
		input[type="password"] {
			width: 100%;
			padding: 10px;
			border: 1px solid #ccc;
			border-radius: 5px;
			box-sizing: border-box;
			margin-bottom: 20px;
		}

		input[type="submit"] {
			background-color: #008080;
			color: #fff;
			border: none;
			padding: 10px 20px;
			border-radius: 5px;
			cursor: pointer;
		}

		input[type="submit"]:hover {
			background-color: #006666;
		}
	</style>
</head>
<body>
	<h1>Add Customer</h1>
	<form action="registerCustomerbyAdmin" method="post">
		<label for="telephone">Telephone:</label>
		<input type="text" id="telephoneNo" name="telephoneNo" required><br><br>
		
		<label for="username">Username:</label>
		<input type="text" id="userName" name="userName" required><br><br>
		
		<label for="password">Password:</label>
		<input type="password" id="password" name="password" required><br><br>
		
		<input type="submit" value="Submit">
	</form>
</body>
</html>
