package com.mycompany.bengkelapp.view;

import com.mycompany.bengkelapp.model.User;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;

    private JPanel mainPanel;

    private User user;

    public MainFrame(User user) {

        this.user = user;

        setTitle(
                "Sistem Manajemen Bengkel - "
                        + user.getRole().toUpperCase()
        );

        setSize(1200, 700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // ================= SIDEBAR =================
        JPanel sidebar = new JPanel();

        sidebar.setLayout(
                new GridLayout(10, 1, 10, 10)
        );

        sidebar.setPreferredSize(
                new Dimension(220, 0)
        );

        sidebar.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 15, 20, 15
                )
        );

        // ================= TITLE =================
        JLabel title =
                new JLabel("BENGKEL APP");

        title.setFont(
                new Font("Segoe UI", Font.BOLD, 22)
        );

        // ================= USER INFO =================
        JLabel lblUser =
                new JLabel(
                        "Login : "
                                + user.getUsername()
                );

        lblUser.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );

        JLabel lblRole =
                new JLabel(
                        "Role : "
                                + user.getRole()
                );

        lblRole.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );

        // ================= BUTTON =================
        JButton btnDashboard =
                new JButton("Dashboard");

        JButton btnPelanggan =
                new JButton("Pelanggan");

        JButton btnKendaraan =
                new JButton("Kendaraan");

        JButton btnServis =
                new JButton("Servis");

        JButton btnLogout =
                new JButton("Logout");

        // ================= STYLE =================
        styleButton(btnDashboard);

        styleButton(btnPelanggan);

        styleButton(btnKendaraan);

        styleButton(btnServis);

        styleButton(btnLogout);

        // ================= ROLE ACCESS =================
        if (user.getRole().equalsIgnoreCase("kasir")) {

            btnPelanggan.setEnabled(false);

            btnKendaraan.setEnabled(false);
        }

        // ================= SIDEBAR =================
        sidebar.add(title);

        sidebar.add(lblUser);

        sidebar.add(lblRole);

        sidebar.add(new JLabel(""));

        sidebar.add(btnDashboard);

        sidebar.add(btnPelanggan);

        sidebar.add(btnKendaraan);

        sidebar.add(btnServis);

        sidebar.add(btnLogout);

        // ================= MAIN PANEL =================
        cardLayout = new CardLayout();

        mainPanel = new JPanel(cardLayout);

        // ================= ADD PANEL =================
        mainPanel.add(
                new DashboardPanel(),
                "dashboard"
        );

        mainPanel.add(
                new PelangganPanel(),
                "pelanggan"
        );

        mainPanel.add(
                new KendaraanPanel(),
                "kendaraan"
        );

        mainPanel.add(
                new ServisPanel(),
                "servis"
        );

        // ================= DEFAULT PAGE =================
        cardLayout.show(mainPanel, "dashboard");

        // ================= ADD TO FRAME =================
        add(sidebar, BorderLayout.WEST);

        add(mainPanel, BorderLayout.CENTER);

        // ================= EVENT =================
        btnDashboard.addActionListener(e -> {

            cardLayout.show(
                    mainPanel,
                    "dashboard"
            );
        });

        btnPelanggan.addActionListener(e -> {

            cardLayout.show(
                    mainPanel,
                    "pelanggan"
            );
        });

        btnKendaraan.addActionListener(e -> {

            cardLayout.show(
                    mainPanel,
                    "kendaraan"
            );
        });

        btnServis.addActionListener(e -> {

            cardLayout.show(
                    mainPanel,
                    "servis"
            );
        });

        // ================= LOGOUT =================
        btnLogout.addActionListener(e -> {

            int confirm =
                    JOptionPane.showConfirmDialog(
                            null,
                            "Yakin ingin logout?",
                            "Logout",
                            JOptionPane.YES_NO_OPTION
                    );

            if (confirm == JOptionPane.YES_OPTION) {

                new LoginFrame().setVisible(true);

                dispose();
            }
        });
    }

    // ================= STYLE BUTTON =================
    private void styleButton(JButton button) {

        button.setFont(
                new Font("Segoe UI", Font.BOLD, 15)
        );

        button.setFocusPainted(false);

        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        button.setPreferredSize(
                new Dimension(180, 45)
        );
    }
}