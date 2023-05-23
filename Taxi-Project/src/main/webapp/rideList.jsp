<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rides</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Rides</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Telephone Number</th>
                    <th>Vehicle</th>
                    <th>Current Location</th>
                    <th>Destination</th>
                    <th>Kilometers</th>
                    <th>Amount</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ride" items="${ride}">
                    <tr>
                        <td>${ride.username}</td>
                        <td>${ride.telephoneNumber}</td>
                        <td>${ride.vehicle}</td>
                        <td>${ride.currentLocation}</td>
                        <td>${ride.destination}</td>
                        <td>${ride.kilometers}</td>
                        <td>${ride.amount}</td>
                        <td>${ride.status}</td>
                        <td><a href="deleteRideServlet?id=${ride.id}" class="delete-button">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
