package com.tap.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.tap.daoimplementation.RestaurantDaoImpl;
import com.tap.model.Restaurant;

public class AdminAddRestaurantServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getParameter("name"));
        restaurant.setAddress(request.getParameter("address"));
        restaurant.setPhone(request.getParameter("phone"));

        RestaurantDaoImpl dao = new RestaurantDaoImpl();
        dao.addRestaurant(restaurant);

        response.sendRedirect("admin-dashboard.jsp");
    }
}
