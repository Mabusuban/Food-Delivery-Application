package com.tap.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/topfoods2";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established.");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not loaded successfully.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection not established.");
            e.printStackTrace();
        }
        return con;
    }

    // Optional: for testing
    public static void main(String[] args) {
        getConnection();
    }
}

