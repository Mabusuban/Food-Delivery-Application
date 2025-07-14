package com.tap.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.tap.model.Order;
import com.tap.daoimplementation.OrderDaoImpl;

public class ViewOrdersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = ((com.tap.model.User) session.getAttribute("user")).getUserId();

        OrderDaoImpl dao = new OrderDaoImpl();
        List<Order> orders = dao.getOrdersByUser(userId);

        request.setAttribute("orders", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders.jsp");
        dispatcher.forward(request, response);
    }
}
