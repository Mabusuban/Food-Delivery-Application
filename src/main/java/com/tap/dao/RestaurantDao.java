package com.tap.dao;

import java.util.List;
import com.tap.model.Restaurant;

public interface RestaurantDao {
    void addRestaurant(Restaurant restaurant);
    List<Restaurant> getAllRestaurants();
    Restaurant getRestaurantById(int restaurantId);
}
