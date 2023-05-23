<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Driver</title>
</head>
<body>
    <h1 style="color: #008080;">Update Driver    <form action="updateDriver" method="post" style="max-width: 500px; margin: 0 auto; background-color: #fff; padding: 20px; border: 1px solid #ccc; box-shadow: 2px 2px 5px #ccc;">
        <label for="telephoneNumber" style="display: block; margin-bottom: 10px;">Telephone Number:</label>
        
        <input type="number" id="telephoneNumber" name="telephoneNumber" value="<%=request.getParameter("telephoneNumber")%>" readonly style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box; margin-bottom: 20px;">
        <br><br>
        
        <label for="username" style="display: block; margin-bottom: 10px;">Username:</label>
        
        <input type="text" id="username" name="username" value="<%=request.getParameter("userName")%>" required style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box; margin-bottom: 20px;">
        <br><br>
        
        <label for="password" style="display: block; margin-bottom: 10px;">Password:</label>
        
        <input type="password" id="password" name="password" required style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box; margin-bottom: 20px;">
        <br><br>
        
        <input type="submit" value="Update" style="background-color: #008080; color: #fff; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer;">
    </form>
</body>
</html>
