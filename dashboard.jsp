<%@ page import="com.tap.model.User" %>
<%@ page session="true" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard_Tap Foods</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container">
    <h2 class="my-4">Welcome, <%= user.getUsername() %>!</h2>
    <p>Email: <%= user.getEmail() %></p>
    <p>Address: <%= user.getAddress() %></p>

    <a href="index.html" class="btn btn-primary">Back to Home</a>
    <a href="LogoutServlet" class="btn btn-danger">Logout</a>
</div>
</body>
</html>
