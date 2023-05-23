<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
	<title>Location</title>
	<style>
		body {
			background-color: #f2f2f2;
			font-family: Arial, sans-serif;
			color: #333;
		}
		h3 {
			font-size: 24px;
			margin-top: 20px;
			margin-bottom: 10px;
		}
		form {
			margin: 20px auto;
			padding: 20px;
			max-width: 600px;
			background-color: #fff;
			border-radius: 5px;
			box-shadow: 0 2px 5px rgba(0,0,0,0.3);
		}
		input[type="text"], input[type="number"] {
			padding: 10px;
			margin-bottom: 20px;
			border-radius: 3px;
			border: none;
			box-shadow: 0 1px 2px rgba(0,0,0,0.1);
			font-size: 16px;
			width: 100%;
			box-sizing: border-box;
		}
		input[type="submit"] {
			padding: 10px 20px;
			background-color: #4CAF50;
			color: #fff;
			border: none;
			border-radius: 3px;
			font-size: 16px;
			cursor: pointer;
			transition: background-color 0.3s ease;
		}
		input[type="submit"]:hover {
			background-color: #3e8e41;
		}
	</style>
</head>
<body>
	<h3>Enter your location:</h3>
	<form method="post" action="rideConfirmationServlet">
		<input type="hidden" name="ride" value="<%=request.getParameter("ride")%>">
		<h1>"<%=request.getParameter("ride")%>"</h1>>
		<p><b>Current Location:</b> <input type="text" name="currentLocation"></p>
		<p><b>Destination Location:</b> <input type="text" name="destinationLocation"></p>
		<p><b>Kilometers:</b> <input type="number" name="kilometers"></p>
		<input type="submit" value="Calculate Fare">
	</form>
</body>
</html>
