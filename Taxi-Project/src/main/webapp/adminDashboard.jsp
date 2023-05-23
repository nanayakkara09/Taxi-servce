<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <!-- Add CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            padding: 50px;
            font-size: 1.1rem;
            background-image: url("https://static.vecteezy.com/system/resources/previews/002/944/432/original/online-taxi-service-concept-yellow-taxi-car-and-hand-holding-smartphone-with-taxi-application-on-city-background-illustration-in-flat-style-vector.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
        }

        h1 {
            margin-bottom: 50px;
        }

        ul {
            list-style: none;
            padding-left: 0;
        }

        li {
            margin-bottom: 15px;
        }

        .button-container {
            display: inline-block;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            transition: all 0.3s ease;
        }

        .button-container:hover {
            transform: scale(1.05);
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            color: #0056b3;
            text-decoration: underline;
        }

       
        .fa-icon {
            display: inline-block;
            margin-right: 10px;
            font-size: 20px;
            width: 30px;
            height: 30px;
            line-height: 30px;
            text-align: center;
            border-radius: 50%;
            background-color: #007bff;
            color: #ffffff;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome, Admin</h1>
        <ul>
            <li>
                <div class="button-container">
                    <a href="retrieveCustomer">
                        <i class="fa-icon far fa-user"></i>
                        View All Customers
                    </a>
                </div>
            </li>
            <li>
                <div class="button-container">
                    <a href="retrieveDriver">
                        <i class="fa-icon fas fa-car"></i>
                        View All Drivers
                    </a>
                </div>
            </li>
            <li>
                <div class="button-container">
                    <a href="retrievePendingRides">
                        <i class="fa-icon far fa-clock"></i>
                        View Pending Rides
                    </a>
                </div>
            </li>
            <li>
                <div class="button-container">
                    <a href="retrieveDriverPending">
                        <i class="fa-icon fas fa-check-circle"></i>
                        View Confirmed Rides
                    </a>
                </div>
            </li>
        </ul>
    </div>
    <!-- Add JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    

