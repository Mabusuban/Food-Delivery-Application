<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register - Tap Foods</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container">
    <h2 class="text-center my-4">Register</h2>
    <form action="RegisterServlet" method="post" class="card p-4 shadow-sm mx-auto" style="max-width:400px;">
        <div class="form-group">
            <input type="text" class="form-control" name="name" placeholder="Full Name" required/>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="username" placeholder="Username" required/>
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password" required/>
        </div>
        <div class="form-group">
            <input type="email" class="form-control" name="email" placeholder="Email" required/>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="phone" placeholder="Phone" required/>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="address" placeholder="Address" required/>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Register</button>
    </form>
</div>
</body>
</html>
