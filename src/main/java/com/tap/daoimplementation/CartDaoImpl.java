package com.tap.daoimplementation;

import java.sql.*;
import java.util.*;
import com.tap.dao.CartDao;
import com.tap.model.Cart;
import com.tap.utility.DBConnection;

public class CartDaoImpl implements CartDao {

    @Override
    public void addToCart(Cart cart) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Cart(userId, itemId, quantity) VALUES(?,?,?)");
            ps.setInt(1, cart.getUserId());
            ps.setInt(2, cart.getItemId());
            ps.setInt(3, cart.getQuantity());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cart> getCartItemsByUser(int userId) {
        List<Cart> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Cart WHERE userId=?");
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart(
                    rs.getInt("cartId"),
                    rs.getInt("userId"),
                    rs.getInt("itemId"),
                    rs.getInt("quantity")
                );
                list.add(cart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void removeCartItem(int cartId) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Cart WHERE cartId=?");
            ps.setInt(1, cartId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearCartByUser(int userId) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Cart WHERE userId=?");
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
