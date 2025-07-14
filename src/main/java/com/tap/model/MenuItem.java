package com.tap.model;

public class MenuItem {
    private int itemId;
    private String name;
    private double price;
    private int restaurantId;

    public MenuItem() {}

    public MenuItem(int itemId, String name, double price, int restaurantId) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}

