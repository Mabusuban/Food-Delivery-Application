<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Restaurant_Admin</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container">
    <h2 class="text-center my-4">Add New Restaurant</h2>
    <form action="AdminAddRestaurantServlet" method="post" class="card p-4 shadow-sm mx-auto" style="max-width:400px;">
        <div class="form-group">
            <input type="text" class="form-control" name="name" placeholder="Restaurant Name" required/>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="address" placeholder="Address" required/>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="phone" placeholder="Phone" required/>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Add Restaurant</button>
    </form>
</div>
</body>
</html>
