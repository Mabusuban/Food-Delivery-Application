<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Tap Foods</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container">
    <h2 class="text-center my-4">Login</h2>
    <form action="LoginServlet" method="post" class="card p-4 shadow-sm mx-auto" style="max-width:400px;">
        <div class="form-group">
            <input type="text" class="form-control" name="username" placeholder="Username" required/>
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password" required/>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Login</button>
        <div class="text-center mt-3">
            <a href="register.jsp">Don't have an account? Register</a>
        </div>
        <div class="text-danger mt-2">${errorMessage}</div>
    </form>
</div>
</body>
</html>
