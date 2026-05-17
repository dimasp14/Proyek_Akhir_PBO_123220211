package com.mycompany.bengkelapp.controller;

import com.mycompany.bengkelapp.dao.PelangganDAO;
import com.mycompany.bengkelapp.model.Pelanggan;

import java.util.List;

public class PelangganController {

    private final PelangganDAO dao = new PelangganDAO();

    public void tambah(Pelanggan p) {
        dao.insert(p);
    }

    public void update(Pelanggan p) {
        dao.update(p);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public List<Pelanggan> getAll() {
        return dao.getAll();
    }
    public int countPelanggan() {
    return dao.countPelanggan();
}
}