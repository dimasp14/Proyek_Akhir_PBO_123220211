package com.mycompany.bengkelapp.controller;

import com.mycompany.bengkelapp.dao.ServisDAO;
import com.mycompany.bengkelapp.model.Servis;

import java.util.List;

public class ServisController {

    private final ServisDAO dao =
            new ServisDAO();

    public void tambah(Servis s) {
        dao.insert(s);
    }

    public void update(Servis s) {
        dao.update(s);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public List<Servis> getAll() {
        return dao.getAll();
    }
    public int countServis() {
    return dao.countServis();
}

public double totalPendapatan() {
    return dao.totalPendapatan();
}
}
