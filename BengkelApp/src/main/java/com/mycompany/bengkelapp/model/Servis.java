package com.mycompany.bengkelapp.model;

import java.util.Date;

public class Servis {

    private int id;

    private int kendaraanId;

    private String kendaraan;

    private Date tanggal;

    private String jenisServis;

    private double biaya;

    public Servis() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKendaraanId() {
        return kendaraanId;
    }

    public void setKendaraanId(int kendaraanId) {
        this.kendaraanId = kendaraanId;
    }

    public String getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(String kendaraan) {
        this.kendaraan = kendaraan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getJenisServis() {
        return jenisServis;
    }

    public void setJenisServis(String jenisServis) {
        this.jenisServis = jenisServis;
    }

    public double getBiaya() {
        return biaya;
    }

    public void setBiaya(double biaya) {
        this.biaya = biaya;
    }
}