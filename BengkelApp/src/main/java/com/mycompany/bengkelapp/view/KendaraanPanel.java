package com.mycompany.bengkelapp.view;

import com.mycompany.bengkelapp.controller.KendaraanController;
import com.mycompany.bengkelapp.controller.PelangganController;
import com.mycompany.bengkelapp.model.Kendaraan;
import com.mycompany.bengkelapp.model.Pelanggan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class KendaraanPanel extends JPanel {

    private JTable table;
    private DefaultTableModel model;

    private JComboBox<Pelanggan> cbPelanggan;

    private JTextField txtPlat;
    private JTextField txtJenis;
    private JTextField txtMerk;

    private final KendaraanController controller =
            new KendaraanController();

    private final PelangganController pelangganController =
            new PelangganController();

    public KendaraanPanel() {

        setLayout(new BorderLayout(15, 15));

        setBorder(BorderFactory.createEmptyBorder(
                20, 20, 20, 20
        ));

        JLabel title = new JLabel("Data Kendaraan");

        title.setFont(new Font("Segoe UI", Font.BOLD, 26));

        add(title, BorderLayout.NORTH);

        // ================= TABLE =================
        model = new DefaultTableModel(
                new String[]{
                        "ID",
                        "Pelanggan",
                        "Plat",
                        "Jenis",
                        "Merk"
                }, 0
        );

        table = new JTable(model);

        table.setRowHeight(30);

        JScrollPane scrollPane =
                new JScrollPane(table);

        // ================= FORM =================
        JPanel formPanel = new JPanel(
                new GridLayout(5, 2, 15, 15)
        );

        cbPelanggan = new JComboBox<>();

        loadPelanggan();

        txtPlat = new JTextField();
        txtJenis = new JTextField();
        txtMerk = new JTextField();

        JButton btnTambah = new JButton("Tambah");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");

        formPanel.add(new JLabel("Pelanggan"));
        formPanel.add(cbPelanggan);

        formPanel.add(new JLabel("Plat Nomor"));
        formPanel.add(txtPlat);

        formPanel.add(new JLabel("Jenis"));
        formPanel.add(txtJenis);

        formPanel.add(new JLabel("Merk"));
        formPanel.add(txtMerk);

        formPanel.add(btnTambah);
        formPanel.add(btnUpdate);

        formPanel.add(btnDelete);

        // ================= CENTER =================
        JPanel centerPanel =
                new JPanel(new BorderLayout(15, 15));

        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.add(formPanel, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        // ================= LOAD =================
        loadTable();

        // ================= TAMBAH =================
        btnTambah.addActionListener(e -> {

            Pelanggan p =
                    (Pelanggan) cbPelanggan.getSelectedItem();

            Kendaraan k = new Kendaraan();

            k.setPelangganId(p.getId());

            k.setPlatNomor(txtPlat.getText());
            k.setJenis(txtJenis.getText());
            k.setMerk(txtMerk.getText());

            controller.tambah(k);

            loadTable();

            clearForm();
        });

        // ================= UPDATE =================
        btnUpdate.addActionListener(e -> {

            int row = table.getSelectedRow();

            if (row >= 0) {

                Pelanggan p =
                        (Pelanggan) cbPelanggan.getSelectedItem();

                Kendaraan k = new Kendaraan();

                k.setId((int) model.getValueAt(row, 0));

                k.setPelangganId(p.getId());

                k.setPlatNomor(txtPlat.getText());
                k.setJenis(txtJenis.getText());
                k.setMerk(txtMerk.getText());

                controller.update(k);

                loadTable();

                clearForm();
            }
        });

        // ================= DELETE =================
        btnDelete.addActionListener(e -> {

            int row = table.getSelectedRow();

            if (row >= 0) {

                int id = (int) model.getValueAt(row, 0);

                controller.delete(id);

                loadTable();

                clearForm();
            }
        });

        // ================= CLICK TABLE =================
        table.getSelectionModel()
                .addListSelectionListener(e -> {

                    int row = table.getSelectedRow();

                    if (row >= 0) {

                        txtPlat.setText(
                                model.getValueAt(row, 2).toString()
                        );

                        txtJenis.setText(
                                model.getValueAt(row, 3).toString()
                        );

                        txtMerk.setText(
                                model.getValueAt(row, 4).toString()
                        );
                    }
                });
    }

    // ================= LOAD PELANGGAN =================
    private void loadPelanggan() {

        cbPelanggan.removeAllItems();

        for (Pelanggan p : pelangganController.getAll()) {
            cbPelanggan.addItem(p);
        }
    }

    // ================= LOAD TABLE =================
    private void loadTable() {

        model.setRowCount(0);

        for (Kendaraan k : controller.getAll()) {

            model.addRow(new Object[]{
                    k.getId(),
                    k.getNamaPelanggan(),
                    k.getPlatNomor(),
                    k.getJenis(),
                    k.getMerk()
            });
        }
    }

    // ================= CLEAR =================
    private void clearForm() {

        txtPlat.setText("");
        txtJenis.setText("");
        txtMerk.setText("");
    }
}