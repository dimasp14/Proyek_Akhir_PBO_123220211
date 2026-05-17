package com.mycompany.bengkelapp.dao;

import com.mycompany.bengkelapp.model.User;
import com.mycompany.bengkelapp.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public User login(String username, String password) {

        String sql =
                "SELECT * FROM users WHERE username=? AND password=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, username);

            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                User user = new User();

                user.setId(rs.getInt("id"));

                user.setUsername(
                        rs.getString("username")
                );

                user.setRole(
                        rs.getString("role")
                );

                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}