package com.mycompany.bengkelapp.dao;

import com.mycompany.bengkelapp.model.Servis;
import com.mycompany.bengkelapp.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServisDAO {

    public void insert(Servis s) {

        String sql =
                "INSERT INTO servis(kendaraan_id,tanggal,jenis_servis,biaya) VALUES(?,?,?,?)";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, s.getKendaraanId());

            ps.setDate(
                    2,
                    new java.sql.Date(
                            s.getTanggal().getTime()
                    )
            );

            ps.setString(3, s.getJenisServis());

            ps.setDouble(4, s.getBiaya());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Servis s) {

        String sql =
                "UPDATE servis SET kendaraan_id=?, tanggal=?, jenis_servis=?, biaya=? WHERE id=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, s.getKendaraanId());

            ps.setDate(
                    2,
                    new java.sql.Date(
                            s.getTanggal().getTime()
                    )
            );

            ps.setString(3, s.getJenisServis());

            ps.setDouble(4, s.getBiaya());

            ps.setInt(5, s.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {

        String sql = "DELETE FROM servis WHERE id=?";

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

    public List<Servis> getAll() {

        List<Servis> list = new ArrayList<>();

        String sql =
                """
                SELECT
                    servis.id,
                    servis.kendaraan_id,
                    kendaraan.plat_nomor,
                    servis.tanggal,
                    servis.jenis_servis,
                    servis.biaya
                FROM servis
                JOIN kendaraan
                ON servis.kendaraan_id = kendaraan.id
                """;

        try (
                Connection conn = DBConnection.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)
        ) {

            while (rs.next()) {

                Servis s = new Servis();

                s.setId(rs.getInt("id"));

                s.setKendaraanId(
                        rs.getInt("kendaraan_id")
                );

                s.setKendaraan(
                        rs.getString("plat_nomor")
                );

                s.setTanggal(
                        rs.getDate("tanggal")
                );

                s.setJenisServis(
                        rs.getString("jenis_servis")
                );

                s.setBiaya(
                        rs.getDouble("biaya")
                );

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public int countServis() {

    String sql = "SELECT COUNT(*) FROM servis";

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
    public double totalPendapatan() {

    String sql = "SELECT SUM(biaya) FROM servis";

    try (
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql)
    ) {

        if (rs.next()) {
            return rs.getDouble(1);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return 0;
}
}