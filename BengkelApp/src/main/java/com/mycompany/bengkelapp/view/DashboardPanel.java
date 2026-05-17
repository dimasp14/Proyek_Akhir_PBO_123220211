package com.mycompany.bengkelapp.view;

import com.mycompany.bengkelapp.controller.KendaraanController;
import com.mycompany.bengkelapp.controller.PelangganController;
import com.mycompany.bengkelapp.controller.ServisController;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {

    private final PelangganController pelangganController =
            new PelangganController();

    private final KendaraanController kendaraanController =
            new KendaraanController();

    private final ServisController servisController =
            new ServisController();

    public DashboardPanel() {

        setLayout(new BorderLayout(20, 20));

        setBorder(BorderFactory.createEmptyBorder(
                20, 20, 20, 20
        ));

        // ================= TITLE =================
        JLabel title =
                new JLabel("Dashboard Statistik");

        title.setFont(
                new Font("Segoe UI", Font.BOLD, 30)
        );

        add(title, BorderLayout.NORTH);

        // ================= CARD PANEL =================
        JPanel cardPanel =
                new JPanel(
                        new GridLayout(2, 2, 20, 20)
                );

        // ================= DATA =================
        int totalPelanggan =
                pelangganController.countPelanggan();

        int totalKendaraan =
                kendaraanController.countKendaraan();

        int totalServis =
                servisController.countServis();

        double pendapatan =
                servisController.totalPendapatan();

        // ================= CARD =================
        cardPanel.add(createCard(
                "Total Pelanggan",
                String.valueOf(totalPelanggan)
        ));

        cardPanel.add(createCard(
                "Total Kendaraan",
                String.valueOf(totalKendaraan)
        ));

        cardPanel.add(createCard(
                "Total Servis",
                String.valueOf(totalServis)
        ));

        cardPanel.add(createCard(
                "Total Pendapatan",
                "Rp " + pendapatan
        ));

        add(cardPanel, BorderLayout.CENTER);
    }

    // ================= CARD =================
    private JPanel createCard(
            String title,
            String value
    ) {

        JPanel panel = new JPanel();

        panel.setLayout(
                new BorderLayout()
        );

        panel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                Color.GRAY,
                                1
                        ),
                        BorderFactory.createEmptyBorder(
                                20,
                                20,
                                20,
                                20
                        )
                )
        );

        JLabel lblTitle =
                new JLabel(title);

        lblTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        JLabel lblValue =
                new JLabel(value);

        lblValue.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        32
                )
        );

        panel.add(lblTitle, BorderLayout.NORTH);

        panel.add(lblValue, BorderLayout.CENTER);

        return panel;
    }
}