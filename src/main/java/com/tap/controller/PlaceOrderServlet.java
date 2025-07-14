package com.tap.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.tap.daoimplementation.OrderDaoImpl;
import com.tap.daoimplementation.CartDaoImpl;
import com.tap.model.Order;

public class PlaceOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));

        HttpSession session = request.getSession();
        int userId = ((com.tap.model.User) session.getAttribute("user")).getUserId();

        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(totalAmount);
        
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.placeOrder(order);

        CartDaoImpl cartDao = new CartDaoImpl();
        cartDao.clearCartByUser(userId);

        response.sendRedirect("ViewOrdersServlet");
    }
}
