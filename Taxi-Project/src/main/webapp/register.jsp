<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Registration Form</title>
  <style>
    body {
      background-color: #F7F7F7;
      font-family: Arial, sans-serif;
      background-image: url("https://static.vecteezy.com/system/resources/previews/002/944/432/original/online-taxi-service-concept-yellow-taxi-car-and-hand-holding-smartphone-with-taxi-application-on-city-background-illustration-in-flat-style-vector.jpg");
    }
    h1 {
      color: #4CAF50;
      text-align: center;
    }
    form {
      background-color: #FFFFFF;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0px 0px 5px #888888;
      margin: auto;
      width: 50%;
    }
    input[type="text"], input[type="password"], input[type="tel"] {
      padding: 10px;
      border-radius: 5px;
      border: 1px solid #ccc;
      width: 100%;
      margin-bottom: 10px;
      box-sizing: border-box;
      font-size: 16px;
      color: #555;
    }
    input[type="submit"] {
      background-color: #4CAF50;
      color: white;
      padding: 10px 20px;
      border-radius: 5px;
      border: none;
      cursor: pointer;
      font-size: 16px;
    }
    input[type="submit"]:hover {
      background-color: #45a049;
    }
    label {
      font-size: 16px;
      font-weight: bold;
      color: #555;
    }
    .error {
      color: red;
      font-size: 14px;
      margin-top: 5px;
    }
  </style>
</head>
<body>
  <h1>Registration Form</h1>
  <form action="register" method="POST">
    <label for="username">Username:</label>
    <input type="text" id="userName" name="userName" required>
    <label for="telephone">Telephone:</label>
    <input type="tel" id="telephoneNo" name="telephoneNo" pattern="[0-9]{10}" required>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" minlength="8" required>
    <% if (request.getAttribute("registerError") != null) { %>
      <p class="error"><%= request.getAttribute("registerError") %></p>
    <% } %>
    <input type="submit" value="Register">
  </form>
</body>
</html>
