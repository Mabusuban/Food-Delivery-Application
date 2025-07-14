package com.tap.daoimplementation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.userDao;
import com.tap.model.User;
import com.tap.utility.DBConnection;

public class userDaoImpl implements userDao {

    public static final String INSERT_USER_QUERY = "INSERT INTO `user` (name, username, password, email, phone, address, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_USER_QUERY = "SELECT * FROM `user` WHERE userId = ?";
    public static final String UPDATE_USER_QUERY = "UPDATE `user` SET name = ?, password = ?, phone = ?, address = ?, role = ? WHERE userId = ?";
    public static final String DELETE_USER_QUERY = "DELETE FROM `user` WHERE userId = ?";
    public static final String GET_ALL_USER_QUERY = "SELECT * FROM `user`";

    @Override
    public boolean addUser(User user) {
        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(INSERT_USER_QUERY)
        ) {
            prepareStatement.setString(1, user.getName());
            prepareStatement.setString(2, user.getUsername());
            prepareStatement.setString(3, user.getPassword());
            prepareStatement.setString(4, user.getEmail());
            prepareStatement.setString(5, user.getPhone());
            prepareStatement.setString(6, user.getAddress());
            prepareStatement.setString(7, user.getRole());

            int res = prepareStatement.executeUpdate();
            return res > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUser(int userId) {
        User user = null;
        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(GET_USER_QUERY)
        ) {
            prepareStatement.setInt(1, userId);
            ResultSet res = prepareStatement.executeQuery();
            if (res.next()) {
                user = extractUser(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_USER_QUERY)
        ) {
            prepareStatement.setString(1, user.getName());
            prepareStatement.setString(2, user.getPassword());
            prepareStatement.setString(3, user.getPhone());
            prepareStatement.setString(4, user.getAddress());
            prepareStatement.setString(5, user.getRole());
            prepareStatement.setInt(6, user.getUserId()); // assuming userId is available
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) {
        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(DELETE_USER_QUERY)
        ) {
            prepareStatement.setInt(1, userId);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUser() {
        ArrayList<User> usersList = new ArrayList<>();
        try (
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(GET_ALL_USER_QUERY)
        ) {
            while (res.next()) {
                User user = extractUser(res);
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    private User extractUser(ResultSet res) throws SQLException {
        int userId = res.getInt("userId");
        String name = res.getString("name");
        String username = res.getString("username");
        String password = res.getString("password");
        String email = res.getString("email");
        String phone = res.getString("phone");
        String address = res.getString("address");
        String role = res.getString("role");

        return new User(userId, name, username, password, email, phone, address, role, null, null);
    }

    @Override
    public User getUserByUsername(String username) {
        User user = null;
        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `user` WHERE username = ?")
        ) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = extractUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
