package com.tap.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.tap.model.Cart;
import com.tap.daoimplementation.CartDaoImpl;

public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        HttpSession session = request.getSession();
        int userId = ((com.tap.model.User) session.getAttribute("user")).getUserId();

        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setItemId(itemId);
        cart.setQuantity(quantity);

        CartDaoImpl dao = new CartDaoImpl();
        dao.addToCart(cart);

        response.sendRedirect("ViewCartServlet");
    }
}
