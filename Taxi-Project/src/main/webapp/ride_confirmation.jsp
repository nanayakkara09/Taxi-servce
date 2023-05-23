<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ride Confirmation</title>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
            background-image: url("https://static.vecteezy.com/system/resources/previews/002/944/432/original/online-taxi-service-concept-yellow-taxi-car-and-hand-holding-smartphone-with-taxi-application-on-city-background-illustration-in-flat-style-vector.jpg");
        }
        h1 {
            text-align: center;
            margin-top: 50px;
        }
        ul {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }
        li {
            padding: 10px;
            margin: 10px;
            background-color: white;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            border-radius: 5px;
            text-align: center;
            flex-basis: 250px;
        }
        li:nth-child(odd) {
            background-color: #f2f2f2;
        }
        p {
            text-align: center;
            font-size: 20px;
        }
    </style>
</head>
<body>
    <h1>Ride Confirmation</h1>
    <p>Thank you for booking your ride with us.</p>
    <p>Your ride details:</p>
    <ul>
        <li>Vehicle: ${ride.vehicle}</li>
        <li>From: ${ride.currentLocation}</li>
        <li>To: ${ride.destination}</li>
        <li>Kilometers: ${ride.kilometers}</li>
        <li>Amount: ${ride.amount}</li>
        <li>Status: ${ride.status}</li>
    </ul>
</body>
</html>



