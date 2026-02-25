package ERRONKA4_ANDER_GIL.Desktop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatuBasea {
    private static final String URL = "jdbc:mysql://localhost:3306/indiusurbil";
    private static final String USER = "root";
    private static final String PASS = "Passwordsql";

    public static Connection konektatu() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.err.println("Errorea konektatzerakoan: " + e.getMessage());
        }
        return con;
    }

    public List<Produktua> zerrendatu() {
        List<Produktua> lista = new ArrayList<>();
        String sql = "SELECT * FROM produktuak";

        try (Connection con = konektatu();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Produktua p = new Produktua(
                        rs.getInt("id"),
                        rs.getString("izena"),
                        rs.getString("deskribapena"),
                        rs.getDouble("prezioa"),
                        rs.getInt("stocka"),
                        String.valueOf(rs.getInt("kategoria_id")),
                        rs.getString("irudiak"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean gehitu(Produktua p) {
        String sql = "INSERT INTO produktuak (izena, deskribapena, prezioa, stocka, kategoria_id, irudiak) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = konektatu();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getIzena());
            ps.setString(2, p.getDeskribapena());
            ps.setDouble(3, p.getPrezioa());
            ps.setInt(4, p.getStocka());
            ps.setInt(5, 1);
            ps.setString(6, p.getIrudiak());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
