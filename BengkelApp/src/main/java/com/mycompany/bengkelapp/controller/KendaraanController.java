package com.mycompany.bengkelapp.controller;

import com.mycompany.bengkelapp.dao.KendaraanDAO;
import com.mycompany.bengkelapp.model.Kendaraan;

import java.util.List;

public class KendaraanController {

    private final KendaraanDAO dao =
            new KendaraanDAO();

    public void tambah(Kendaraan k) {
        dao.insert(k);
    }

    public void update(Kendaraan k) {
        dao.update(k);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public List<Kendaraan> getAll() {
        return dao.getAll();
    }
    public int countKendaraan() {
    return dao.countKendaraan();
}
}