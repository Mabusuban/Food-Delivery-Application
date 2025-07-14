<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.model.Cart" %>
<%
    List<Cart> cartItems = (List<Cart>) request.getAttribute("cartItems");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Cart - Tap Foods</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="DashboardServlet">Tap Foods</a>
    <div class="ml-auto">
        <a href="LogoutServlet" class="btn btn-danger">Logout</a>
    </div>
</nav>

<div class="container my-4">
    <h2>Your Cart</h2>
    <form action="PlaceOrderServlet" method="post">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Cart ID</th>
                    <th>Item ID</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <%
                    double total = 0;
                    if (cartItems != null && !cartItems.isEmpty()) {
                        for(Cart c : cartItems) {
                %>
                    <tr>
                        <td><%= c.getCartId() %></td>
                        <td><%= c.getItemId() %></td>
                        <td><%= c.getQuantity() %></td>
                    </tr>
                <%
                            total += (c.getQuantity() * 100); // Assume price = 100
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="3" class="text-center">Your cart is empty.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <h4>Total Amount: ₹<%= total %></h4>
        <input type="hidden" name="totalAmount" value="<%= total %>"/>
        <button type="submit" class="btn btn-success btn-block" <%= (cartItems == null || cartItems.isEmpty()) ? "disabled" : "" %>>Place Order</button>
    </form>
</div>
</body>
</html>
