package com.mycompany.bengkelapp.view;

import com.mycompany.bengkelapp.controller.KendaraanController;
import com.mycompany.bengkelapp.controller.ServisController;
import com.mycompany.bengkelapp.model.Kendaraan;
import com.mycompany.bengkelapp.model.Servis;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;

public class ServisPanel extends JPanel {

    private JTable table;

    private DefaultTableModel model;

    private JComboBox<Kendaraan> cbKendaraan;

    private JTextField txtJenis;

    private JTextField txtBiaya;

    private JSpinner spTanggal;

    private JButton btnTambah;
    private JButton btnUpdate;
    private JButton btnDelete;

    private final ServisController controller =
            new ServisController();

    private final KendaraanController kendaraanController =
            new KendaraanController();

    public ServisPanel() {

        setLayout(new BorderLayout(15, 15));

        setBorder(BorderFactory.createEmptyBorder(
                20, 20, 20, 20
        ));

        // ================= TITLE =================
        JLabel title = new JLabel("Data Servis");

        title.setFont(
                new Font("Segoe UI", Font.BOLD, 26)
        );

        add(title, BorderLayout.NORTH);

        // ================= TABLE =================
        model = new DefaultTableModel(
                new String[]{
                        "ID",
                        "Kendaraan",
                        "Tanggal",
                        "Jenis Servis",
                        "Biaya"
                }, 0
        );

        table = new JTable(model);

        table.setRowHeight(30);

        table.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );

        table.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 14)
        );

        JScrollPane scrollPane =
                new JScrollPane(table);

        // ================= FORM PANEL =================
        JPanel formContainer =
                new JPanel(new BorderLayout());

        JPanel formPanel =
                new JPanel(
                        new GridLayout(5, 2, 15, 15)
                );

        // ================= COMPONENT =================
        cbKendaraan = new JComboBox<>();

        loadKendaraan();

        spTanggal = new JSpinner(
                new SpinnerDateModel()
        );

        JSpinner.DateEditor dateEditor =
                new JSpinner.DateEditor(
                        spTanggal,
                        "yyyy-MM-dd"
                );

        spTanggal.setEditor(dateEditor);

        txtJenis = new JTextField();

        txtBiaya = new JTextField();

        txtJenis.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );

        txtBiaya.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );

        // ================= BUTTON =================
        btnTambah = new JButton("Tambah");

        btnUpdate = new JButton("Update");

        btnDelete = new JButton("Delete");

        styleButton(btnTambah);
        styleButton(btnUpdate);
        styleButton(btnDelete);

        // ================= ADD FORM =================
        formPanel.add(new JLabel("Kendaraan"));
        formPanel.add(cbKendaraan);

        formPanel.add(new JLabel("Tanggal"));
        formPanel.add(spTanggal);

        formPanel.add(new JLabel("Jenis Servis"));
        formPanel.add(txtJenis);

        formPanel.add(new JLabel("Biaya"));
        formPanel.add(txtBiaya);

        // ================= BUTTON PANEL =================
        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                15,
                                10
                        )
                );

        buttonPanel.add(btnTambah);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);

        formContainer.add(formPanel, BorderLayout.CENTER);

        formContainer.add(buttonPanel, BorderLayout.SOUTH);

        // ================= CENTER PANEL =================
        JPanel centerPanel =
                new JPanel(
                        new BorderLayout(15, 15)
                );

        centerPanel.add(scrollPane, BorderLayout.CENTER);

        centerPanel.add(formContainer, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        // ================= LOAD TABLE =================
        loadTable();

        // ================= EVENT TAMBAH =================
        btnTambah.addActionListener(e -> {

            try {

                Kendaraan k =
                        (Kendaraan)
                                cbKendaraan.getSelectedItem();

                if (k == null) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Data kendaraan kosong!"
                    );

                    return;
                }

                Servis s = new Servis();

                s.setKendaraanId(k.getId());

                s.setTanggal(
                        (Date) spTanggal.getValue()
                );

                s.setJenisServis(
                        txtJenis.getText()
                );

                s.setBiaya(
                        Double.parseDouble(
                                txtBiaya.getText()
                        )
                );

                controller.tambah(s);

                loadTable();

                clearForm();

                JOptionPane.showMessageDialog(
                        null,
                        "Data servis berhasil ditambahkan!"
                );

            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        null,
                        "Input gagal!"
                );
            }
        });

        // ================= EVENT UPDATE =================
        btnUpdate.addActionListener(e -> {

            try {

                int row = table.getSelectedRow();

                if (row >= 0) {

                    Kendaraan k =
                            (Kendaraan)
                                    cbKendaraan.getSelectedItem();

                    Servis s = new Servis();

                    s.setId(
                            (int) model.getValueAt(row, 0)
                    );

                    s.setKendaraanId(k.getId());

                    s.setTanggal(
                            (Date) spTanggal.getValue()
                    );

                    s.setJenisServis(
                            txtJenis.getText()
                    );

                    s.setBiaya(
                            Double.parseDouble(
                                    txtBiaya.getText()
                            )
                    );

                    controller.update(s);

                    loadTable();

                    clearForm();

                    JOptionPane.showMessageDialog(
                            null,
                            "Data berhasil diupdate!"
                    );
                }

            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        null,
                        "Update gagal!"
                );
            }
        });

        // ================= EVENT DELETE =================
        btnDelete.addActionListener(e -> {

            int row = table.getSelectedRow();

            if (row >= 0) {

                int confirm =
                        JOptionPane.showConfirmDialog(
                                null,
                                "Yakin ingin menghapus?",
                                "Konfirmasi",
                                JOptionPane.YES_NO_OPTION
                        );

                if (confirm == JOptionPane.YES_OPTION) {

                    int id =
                            (int) model.getValueAt(row, 0);

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

        // ================= CLICK TABLE =================
        table.getSelectionModel()
                .addListSelectionListener(e -> {

                    int row = table.getSelectedRow();

                    if (row >= 0) {

                        txtJenis.setText(
                                model.getValueAt(row, 3)
                                        .toString()
                        );

                        txtBiaya.setText(
                                model.getValueAt(row, 4)
                                        .toString()
                        );
                    }
                });
    }

    // ================= STYLE BUTTON =================
    private void styleButton(JButton button) {

        button.setFont(
                new Font("Segoe UI", Font.BOLD, 14)
        );

        button.setFocusPainted(false);

        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        button.setPreferredSize(
                new Dimension(120, 40)
        );
    }

    // ================= LOAD KENDARAAN =================
    private void loadKendaraan() {

        cbKendaraan.removeAllItems();

        for (Kendaraan k :
                kendaraanController.getAll()) {

            cbKendaraan.addItem(k);
        }
    }

    // ================= LOAD TABLE =================
    private void loadTable() {

        model.setRowCount(0);

        for (Servis s : controller.getAll()) {

            model.addRow(new Object[]{
                    s.getId(),
                    s.getKendaraan(),
                    s.getTanggal(),
                    s.getJenisServis(),
                    s.getBiaya()
            });
        }
    }

    // ================= CLEAR FORM =================
    private void clearForm() {

        txtJenis.setText("");

        txtBiaya.setText("");
    }
}