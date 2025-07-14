package com.tap.daoimplementation;

import java.sql.*;
import java.util.*;
import com.tap.dao.OrderDao;
import com.tap.model.Order;
import com.tap.utility.DBConnection;

public class OrderDaoImpl implements OrderDao {

    @Override
    public void placeOrder(Order order) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO OrderTable(userId, totalAmount) VALUES(?,?)");
            ps.setInt(1, order.getUserId());
            ps.setDouble(2, order.getTotalAmount());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getOrdersByUser(int userId) {
        List<Order> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM OrderTable WHERE userId=?");
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order(
                    rs.getInt("orderId"),
                    rs.getInt("userId"),
                    rs.getDouble("totalAmount"),
                    rs.getTimestamp("orderDate")
                );
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
