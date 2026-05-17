package com.mycompany.bengkelapp;

import com.mycompany.bengkelapp.util.DBConnection;

public class TestConnection {

    public static void main(String[] args) {

        if (DBConnection.getConnection() != null) {
            System.out.println("Koneksi berhasil!");
        } else {
            System.out.println("Koneksi gagal!");
        }

    }
}