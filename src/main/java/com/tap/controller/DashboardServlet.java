package com.tap.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.tap.daoimplementation.RestaurantDaoImpl;
import com.tap.daoimplementation.MenuItemDaoImpl;
import com.tap.model.Restaurant;
import com.tap.model.MenuItem;

public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RestaurantDaoImpl restaurantDao = new RestaurantDaoImpl();
        MenuItemDaoImpl menuItemDao = new MenuItemDaoImpl();

        List<Restaurant> restaurants = restaurantDao.getAllRestaurants();
        request.setAttribute("restaurants", restaurants);

        List<MenuItem> menuItems = new ArrayList<>();
        for (Restaurant r : restaurants) {
            menuItems.addAll(menuItemDao.getMenuItemsByRestaurant(r.getRestaurantId()));
        }
        request.setAttribute("menuItems", menuItems);

        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }
}
