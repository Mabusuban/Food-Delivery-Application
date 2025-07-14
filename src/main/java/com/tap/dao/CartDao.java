package com.tap.dao;

import java.util.List;
import com.tap.model.Cart;

public interface CartDao {
    void addToCart(Cart cart);
    List<Cart> getCartItemsByUser(int userId);
    void removeCartItem(int cartId);
    void clearCartByUser(int userId);
}
