<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Menu Item_Admin</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container">
    <h2 class="text-center my-4">Add New Menu Item</h2>
    <form action="AdminAddMenuItemServlet" method="post" class="card p-4 shadow-sm mx-auto" style="max-width:400px;">
        <div class="form-group">
            <input type="text" class="form-control" name="name" placeholder="Menu Item Name" required/>
        </div>
        <div class="form-group">
            <input type="number" step="0.01" class="form-control" name="price" placeholder="Price" required/>
        </div>
        <div class="form-group">
            <input type="number" class="form-control" name="restaurantId" placeholder="Restaurant ID" required/>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Add Menu Item</button>
    </form>
</div>
</body>
</html>
