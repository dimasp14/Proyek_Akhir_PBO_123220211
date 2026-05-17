package com.mycompany.bengkelapp.model;

public class Kendaraan {

    private int id;

    private int pelangganId;

    private String namaPelanggan;

    private String platNomor;

    private String jenis;

    private String merk;

    public Kendaraan() {
    }

    public Kendaraan(
            int id,
            int pelangganId,
            String namaPelanggan,
            String platNomor,
            String jenis,
            String merk
    ) {

        this.id = id;

        this.pelangganId = pelangganId;

        this.namaPelanggan = namaPelanggan;

        this.platNomor = platNomor;

        this.jenis = jenis;

        this.merk = merk;
    }

    // ================= GETTER SETTER =================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPelangganId() {
        return pelangganId;
    }

    public void setPelangganId(int pelangganId) {
        this.pelangganId = pelangganId;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    // ================= COMBOBOX DISPLAY =================

    @Override
    public String toString() {

        return platNomor + " - " + merk;
    }
}