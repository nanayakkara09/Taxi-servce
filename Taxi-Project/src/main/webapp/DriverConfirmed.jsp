<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmed Rides</title>
     <!-- Add CSS -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
            background-image: url("https://static.vecteezy.com/system/resources/previews/002/944/432/original/online-taxi-service-concept-yellow-taxi-car-and-hand-holding-smartphone-with-taxi-application-on-city-background-illustration-in-flat-style-vector.jpg);
        }
        h1 {
            color: #333;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f9f9f9;
            text-align: left;
            color: #555;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
    <h1>Confirmed Rides</h1>
    <table>
        <tr>
            <th>Customer Username</th>
            <th>Customer Telephone</th>
            <th>Vehicle</th>
            <th>Current Location</th>
            <th>Destination</th>
            <th>Amount</th>
            <th>Driver Username</th>
            <th>Driver Telephone</th>
        </tr>
        <c:forEach items="${drivers}" var="driver">
            <tr>
                <td>${driver.customerUserName}</td>
                <td>${driver.customerTelephoneNo}</td>
                <td>${driver.vehicle}</td>
                <td>${driver.customerCurrentLocation}</td>
                <td>${driver.customerDestination}</td>
                <td>${driver.amount}</td>
                <td>${driver.driverUsename}</td>
                <td>${driver.driverTelephone}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
