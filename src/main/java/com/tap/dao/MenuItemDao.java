package com.tap.dao;

import java.util.List;
import com.tap.model.MenuItem;

public interface MenuItemDao {
    void addMenuItem(MenuItem item);
    List<MenuItem> getMenuItemsByRestaurant(int restaurantId);
    MenuItem getMenuItemById(int itemId);
}
