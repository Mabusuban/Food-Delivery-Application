package com.tap.daoimplementation;

import java.sql.*;
import java.util.*;
import com.tap.dao.MenuItemDao;
import com.tap.model.MenuItem;
import com.tap.utility.DBConnection;

public class MenuItemDaoImpl implements MenuItemDao {

    @Override
    public void addMenuItem(MenuItem item) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO MenuItem(name, price, restaurantId) VALUES(?,?,?)");
            ps.setString(1, item.getName());
            ps.setDouble(2, item.getPrice());
            ps.setInt(3, item.getRestaurantId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MenuItem> getMenuItemsByRestaurant(int restaurantId) {
        List<MenuItem> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM MenuItem WHERE restaurantId=?");
            ps.setInt(1, restaurantId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MenuItem item = new MenuItem(
                    rs.getInt("itemId"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getInt("restaurantId")
                );
                list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public MenuItem getMenuItemById(int itemId) {
        MenuItem item = null;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM MenuItem WHERE itemId=?");
            ps.setInt(1, itemId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                item = new MenuItem(
                    rs.getInt("itemId"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getInt("restaurantId")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}
