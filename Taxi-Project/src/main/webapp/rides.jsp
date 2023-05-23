<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Requested Rides</title>
	 <!-- Add CSS -->
	<style>
		table {
			border-collapse: collapse;
			width: 100%;
		}
		th, td {
			padding: 8px;
			text-align: left;
			border-bottom: 1px solid #ddd;
		}
		tr:hover {background-color:#f5f5f5;}
		th {
			background-color: #4CAF50;
			color: white;
		}
		form {
			display: inline-block;
		}
	</style>
</head>
<body>
	<h1>Requested Rides</h1>
	<table>
		<tr>
			<th>Username</th>
			<th>Telephone Number</th>
			<th>Vehicle</th>
			<th>Current Location</th>
			<th>Destination</th>
			<th>Kilometers</th>
			<th>Amount</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${requestedRides}" var="ride">
			<tr>
				<td>${ride.username}</td>
				<td>${ride.telephoneNumber}</td>
				<td>${ride.vehicle}</td>
				<td>${ride.currentLocation}</td>
				<td>${ride.destination}</td>
				<td>${ride.kilometers}</td>
				<td>${ride.amount}</td>
				<td>${ride.status}</td>
				<td>
					<form method="POST" >
						<input type="hidden" name="rideId" value="${ride.id}">
						<input type="submit" name="confirm" value="Confirm">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
