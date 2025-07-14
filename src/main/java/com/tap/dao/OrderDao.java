package com.tap.dao;

import java.util.List;
import com.tap.model.Order;

public interface OrderDao {
    void placeOrder(Order order);
    List<Order> getOrdersByUser(int userId);
}
