package com.mycompany.bengkelapp.controller;

import com.mycompany.bengkelapp.dao.UserDAO;
import com.mycompany.bengkelapp.model.User;

public class AuthController {

    private final UserDAO dao =
            new UserDAO();

    public User login(
            String username,
            String password
    ) {

        return dao.login(username, password);
    }
}