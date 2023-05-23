<html>
<head>
    <title>Ride Details</title>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
            background-image: url("https://th.bing.com/th/id/R.c9588cc5731d58c89de2329af0a17c2a?rik=E6mEEibb5ZkEEw&pid=ImgRaw&r=0");
        }
        form {
            margin: 50px auto;
            width: 400px;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        }
        input[type=radio] {
            margin: 10px;
            transform: scale(1.5);
            margin-right: 20px;
            vertical-align: middle;
        }
        input[type=radio]:checked + label {
            font-weight: bold;
        }
        input[type=text], input[type=number] {
            width: 100%;
            padding: 12px 20px;
            margin: 10px 0;
            box-sizing: border-box;
            border: 2px solid #ccc;
            border-radius: 4px;
        }
        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type=submit]:hover {
            background-color: #45a049;
        }
        label {
            font-size: 20px;
            vertical-align: middle;
            display: inline-block;
            margin-right: 20px;
        }
        img {
            width: 100px;
            height:100px;
            margin-right: 10px;
            vertical-align: middle;
        }
    </style>
</head>
<body>
    <form method="post" action="Ride">
        <label>
            <input type="radio" name="vehicle" value="car"> 
            <img src="https://thumbs.dreamstime.com/b/red-car-icon-cartoon-style-white-background-82483882.jpg
" alt="car">
            Car
        </label>
        <label>
            <input type="radio" name="vehicle" value="threewheel"> 
            <img src="https://th.bing.com/th/id/R.a92ac3673ea511eaced7e4ec720e1da5?rik=0NBsckD0dNcsvQ&riu=http%3a%2f%2fclipartstation.com%2fwp-content%2fuploads%2f2017%2f11%2ftuk-tuk-clipart-2.jpg&ehk=R46MnMWfXtau1M8gIwG2bFqsP091JO6BcIWiq5ymdhM%3d&risl=&pid=ImgRaw&r=0
" alt="three-wheel">
            Three-wheel
        </label>
        <label>
            <input type="radio" name="vehicle" value="bike"> 
            <img src="https://www.iconbunny.com/icons/media/catalog/product/4/3/43.10-motorcycle-icon-iconbunny.jpg
" alt="bike">
            Bike
        </label>
        <br>
        <%String telephoneNo = (String) session.getAttribute("telephoneNo"); %>
        <h1>"<%=telephoneNo%>"</h1>>
        <label for="current_location">Current Location:</label>
        <input type="text" name="current_location" id="current_location"><br>
        <label for="destination">Destination:</label>
        <input type="text" name="destination" id="destination"><br>
        <label for="kilometers">Kilometers:</label>
        <input type="number" name="kilometers" id="kilometers"><br>
        <br>
        <input type="submit" value="Calculate Amount">
    </form>
</body>
</html>
