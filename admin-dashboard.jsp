<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin_Dashboard - Tap Foods</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Admin_Tap Foods</a>
    <div class="ml-auto">
        <a href="LogoutServlet" class="btn btn-danger">Logout</a>
    </div>
</nav>

<div class="container my-5">
    <h2 class="mb-4">Admin_Panel</h2>
    <div class="list-group">
        <a href="admin-add-restaurant.jsp" class="list-group-item list-group-item-action">Add Restaurant</a>
        <a href="admin-add-menuitem.jsp" class="list-group-item list-group-item-action">Add Menu Item</a>
    </div>
</div>
</body>
</html>
