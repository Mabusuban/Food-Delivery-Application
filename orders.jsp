<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.model.Order" %>
<%
    List<Order> orders = (List<Order>) request.getAttribute("orders");
%>
<!DOCTYPE html>
<html>
<head>
    <title>My Orders - Tap Foods</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container my-4">
    <h2>My Orders</h2>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Total Amount</th>
                <th>Order Date</th>
            </tr>
        </thead>
        <tbody>
            <%
                if (orders != null && !orders.isEmpty()) {
                    for (Order o : orders) {
            %>
                        <tr>
                            <td><%= o.getOrderId() %></td>
                            <td>₹<%= o.getTotalAmount() %></td>
                            <td><%= o.getOrderDate() %></td>
                        </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="3" class="text-center">No orders found.</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>
</body>
</html>
