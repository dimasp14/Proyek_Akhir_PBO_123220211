package com.mycompany.bengkelapp.view;

import com.mycompany.bengkelapp.controller.PelangganController;
import com.mycompany.bengkelapp.model.Pelanggan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PelangganPanel extends JPanel {

    private JTable table;
    private DefaultTableModel model;

    private JTextField txtNama;
    private JTextField txtHp;
    private JTextField txtAlamat;

    private JButton btnTambah;
    private JButton btnUpdate;
    private JButton btnDelete;

    private final PelangganController controller =
            new PelangganController();

    public PelangganPanel() {

        setLayout(new BorderLayout(15, 15));

        setBorder(BorderFactory.createEmptyBorder(
                20, 20, 20, 20
        ));

        // ================= TITLE =================
        JLabel title = new JLabel("Data Pelanggan");

        title.setFont(new Font("Segoe UI", Font.BOLD, 26));

        add(title, BorderLayout.NORTH);

        // ================= TABLE =================
        model = new DefaultTableModel(
                new String[]{"ID", "Nama", "No HP", "Alamat"}, 0
        );

        table = new JTable(model);

        table.setRowHeight(30);

        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        table.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 14)
        );

        JScrollPane scrollPane = new JScrollPane(table);

        // ================= FORM PANEL =================
        JPanel formContainer = new JPanel(new BorderLayout());

        JPanel formPanel = new JPanel(
                new GridLayout(4, 2, 15, 15)
        );

        JLabel lblNama = new JLabel("Nama");
        JLabel lblHp = new JLabel("No HP");
        JLabel lblAlamat = new JLabel("Alamat");

        lblNama.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblHp.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblAlamat.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        txtNama = new JTextField();
        txtHp = new JTextField();
        txtAlamat = new JTextField();

        txtNama.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtHp.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtAlamat.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        formPanel.add(lblNama);
        formPanel.add(txtNama);

        formPanel.add(lblHp);
        formPanel.add(txtHp);

        formPanel.add(lblAlamat);
        formPanel.add(txtAlamat);

        // ================= BUTTON PANEL =================
        JPanel buttonPanel = new JPanel(
                new FlowLayout(FlowLayout.LEFT, 15, 10)
        );

        btnTambah = new JButton("Tambah");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        styleButton(btnTambah);
        styleButton(btnUpdate);
        styleButton(btnDelete);

        buttonPanel.add(btnTambah);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);

        formContainer.add(formPanel, BorderLayout.CENTER);
        formContainer.add(buttonPanel, BorderLayout.SOUTH);

        // ================= CENTER PANEL =================
        JPanel centerPanel = new JPanel(
                new BorderLayout(15, 15)
        );

        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.add(formContainer, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        // ================= LOAD DATA =================
        loadTable();

        // ================= EVENT TAMBAH =================
        btnTambah.addActionListener(e -> {

            Pelanggan p = new Pelanggan();

            p.setNama(txtNama.getText());
            p.setNoHp(txtHp.getText());
            p.setAlamat(txtAlamat.getText());

            controller.tambah(p);

            loadTable();

            clearForm();

            JOptionPane.showMessageDialog(
                    null,
                    "Data berhasil ditambahkan!"
            );
        });

        // ================= EVENT UPDATE =================
        btnUpdate.addActionListener(e -> {

            int row = table.getSelectedRow();

            if (row >= 0) {

                Pelanggan p = new Pelanggan();

                p.setId((int) model.getValueAt(row, 0));

                p.setNama(txtNama.getText());
                p.setNoHp(txtHp.getText());
                p.setAlamat(txtAlamat.getText());

                controller.update(p);

                loadTable();

                clearForm();

                JOptionPane.showMessageDialog(
                        null,
                        "Data berhasil diupdate!"
                );
            }
        });

        // ================= EVENT DELETE =================
        btnDelete.addActionListener(e -> {

            int row = table.getSelectedRow();

            if (row >= 0) {

                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Yakin ingin menghapus?",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {

                    int id = (int) model.getValueAt(row, 0);

                    controller.delete(id);

                    loadTable();

                    clearForm();

                    JOptionPane.showMessageDialog(
                            null,
                            "Data berhasil dihapus!"
                    );
                }
            }
        });

        // ================= KLIK TABLE =================
        table.getSelectionModel().addListSelectionListener(e -> {

            int row = table.getSelectedRow();

            if (row >= 0) {

                txtNama.setText(
                        model.getValueAt(row, 1).toString()
                );

                txtHp.setText(
                        model.getValueAt(row, 2).toString()
                );

                txtAlamat.setText(
                        model.getValueAt(row, 3).toString()
                );
            }
        });
    }

    // ================= STYLE BUTTON =================
    private void styleButton(JButton button) {

        button.setFont(new Font("Segoe UI", Font.BOLD, 14));

        button.setFocusPainted(false);

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.setPreferredSize(new Dimension(120, 40));
    }

    // ================= LOAD TABLE =================
    private void loadTable() {

        model.setRowCount(0);

        for (Pelanggan p : controller.getAll()) {

            model.addRow(new Object[]{
                    p.getId(),
                    p.getNama(),
                    p.getNoHp(),
                    p.getAlamat()
            });
        }
    }

    // ================= CLEAR FORM =================
    private void clearForm() {

        txtNama.setText("");
        txtHp.setText("");
        txtAlamat.setText("");
    }
}