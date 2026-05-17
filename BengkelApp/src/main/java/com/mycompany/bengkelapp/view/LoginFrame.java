package com.mycompany.bengkelapp.view;

import com.mycompany.bengkelapp.controller.AuthController;
import com.mycompany.bengkelapp.model.User;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField txtUsername;

    private JPasswordField txtPassword;

    private JButton btnLogin;

    private final AuthController controller =
            new AuthController();

    public LoginFrame() {

        setTitle("Login Bengkel App");

        setSize(450, 350);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // ================= MAIN PANEL =================
        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(6, 1, 10, 10)
        );

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        30,
                        30,
                        30
                )
        );

        // ================= TITLE =================
        JLabel title =
                new JLabel(
                        "LOGIN BENGKEL APP",
                        SwingConstants.CENTER
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24
                )
        );

        // ================= INPUT =================
        txtUsername = new JTextField();

        txtPassword = new JPasswordField();

        txtUsername.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );

        txtPassword.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );

        // ================= BUTTON =================
        btnLogin = new JButton("LOGIN");

        btnLogin.setFont(
                new Font("Segoe UI", Font.BOLD, 15)
        );

        btnLogin.setFocusPainted(false);

        // ================= ADD COMPONENT =================
        panel.add(title);

        panel.add(new JLabel("Username"));

        panel.add(txtUsername);

        panel.add(new JLabel("Password"));

        panel.add(txtPassword);

        panel.add(btnLogin);

        // ================= ADD FRAME =================
        add(panel, BorderLayout.CENTER);

        // ================= EVENT =================
        btnLogin.addActionListener(e -> login());
    }

    // ================= LOGIN =================
    private void login() {

        String username =
                txtUsername.getText();

        String password =
                String.valueOf(
                        txtPassword.getPassword()
                );

        User user =
                controller.login(
                        username,
                        password
                );

        if (user != null) {

            JOptionPane.showMessageDialog(
                    null,
                    "Login berhasil sebagai "
                            + user.getRole()
            );

            MainFrame main =
                    new MainFrame(user);

            main.setVisible(true);

            dispose();

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Username / Password salah!"
            );
        }
    }
}