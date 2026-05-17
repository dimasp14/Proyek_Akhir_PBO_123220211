package com.mycompany.bengkelapp.dao;

import com.mycompany.bengkelapp.model.Kendaraan;
import com.mycompany.bengkelapp.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KendaraanDAO {

    public void insert(Kendaraan k) {

        String sql =
                "INSERT INTO kendaraan(pelanggan_id, plat_nomor, jenis, merk) VALUES(?,?,?,?)";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, k.getPelangganId());
            ps.setString(2, k.getPlatNomor());
            ps.setString(3, k.getJenis());
            ps.setString(4, k.getMerk());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Kendaraan k) {

        String sql =
                "UPDATE kendaraan SET pelanggan_id=?, plat_nomor=?, jenis=?, merk=? WHERE id=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, k.getPelangganId());
            ps.setString(2, k.getPlatNomor());
            ps.setString(3, k.getJenis());
            ps.setString(4, k.getMerk());
            ps.setInt(5, k.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {

        String sql = "DELETE FROM kendaraan WHERE id=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Kendaraan> getAll() {

        List<Kendaraan> list = new ArrayList<>();

        String sql =
                """
                SELECT 
                    kendaraan.id,
                    kendaraan.pelanggan_id,
                    pelanggan.nama,
                    kendaraan.plat_nomor,
                    kendaraan.jenis,
                    kendaraan.merk
                FROM kendaraan
                JOIN pelanggan
                ON kendaraan.pelanggan_id = pelanggan.id
                """;

        try (
                Connection conn = DBConnection.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)
        ) {

            while (rs.next()) {

                Kendaraan k = new Kendaraan();

                k.setId(rs.getInt("id"));
                k.setPelangganId(rs.getInt("pelanggan_id"));
                k.setNamaPelanggan(rs.getString("nama"));
                k.setPlatNomor(rs.getString("plat_nomor"));
                k.setJenis(rs.getString("jenis"));
                k.setMerk(rs.getString("merk"));

                list.add(k);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public int countKendaraan() {

    String sql = "SELECT COUNT(*) FROM kendaraan";

    try (
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql)
    ) {

        if (rs.next()) {
            return rs.getInt(1);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return 0;
}
}