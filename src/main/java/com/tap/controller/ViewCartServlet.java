package com.tap.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.tap.model.Cart;
import com.tap.daoimplementation.CartDaoImpl;

public class ViewCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = ((com.tap.model.User) session.getAttribute("user")).getUserId();

        CartDaoImpl dao = new CartDaoImpl();
        List<Cart> cartItems = dao.getCartItemsByUser(userId);

        request.setAttribute("cartItems", cartItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
        dispatcher.forward(request, response);
    }
}
