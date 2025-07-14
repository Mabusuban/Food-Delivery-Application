package com.tap.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.tap.daoimplementation.MenuItemDaoImpl;
import com.tap.model.MenuItem;

public class AdminAddMenuItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MenuItem item = new MenuItem();
        item.setName(request.getParameter("name"));
        item.setPrice(Double.parseDouble(request.getParameter("price")));
        item.setRestaurantId(Integer.parseInt(request.getParameter("restaurantId")));

        MenuItemDaoImpl dao = new MenuItemDaoImpl();
        dao.addMenuItem(item);

        response.sendRedirect("admin-dashboard.jsp");
    }
}
