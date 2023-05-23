<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <style>
        body {
            background-color: #f5f5f5;
        }

        .card {
            margin-top: 100px;
            border: none;
            box-shadow: 0 0.5rem 1rem rgba(0,0,0,0.15);
        }

        .card-header {
            background-color: #fff;
            border-bottom: none;
            text-align: center;
            font-size: 2rem;
            font-weight: bold;
            color: #007bff;
        }

        .card-body {
            padding: 4rem;
        }

        .form-group {
            margin-bottom: 1rem;
        }

        .form-control:focus {
            border-color: #007bff;
            box-shadow: none;
        }

        .btn {
            background-color: #007bff;
            border-color: #007bff;
        }

        .btn:hover {
            background-color: #0069d9;
            border-color: #0062cc;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 mx-auto">
            <div class="card">
                <div class="card-header">
                    Customer Login
                </div>
                <div class="card-body">
                    <form action="login" method="POST">
                        <div class="form-group">
                            <label for="username">Telephone Number</label>
                            <input type="text" class="form-control" id="telephoneNo" name="telephoneNo">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="password">
                        </div>
                        <button type="submit" class="btn btn-block">Login</button>
                        
                    </form>
                    <a href="register.jsp">Register</a>
                     <%-- Validation errors --%>
   <%
      String error = request.getParameter("error");
      if (error != null) {
         out.println("<div class=\"error\">" + error + "</div>");
      }
   %>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
</body>
</html>
