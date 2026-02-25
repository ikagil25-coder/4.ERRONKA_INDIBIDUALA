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
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            return null;
        }
    }

    public static List<Produktua> zerrendatu() {
        List<Produktua> lista = new ArrayList<>();
        try (Connection con = konektatu();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM produktuak");
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Produktua(rs.getInt("id"), rs.getString("izena"), rs.getString("deskribapena"),
                        rs.getDouble("prezioa"), rs.getInt("stocka"),
                        String.valueOf(rs.getInt("kategoria_id")), rs.getString("irudiak")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static boolean gehitu(Produktua p) {
        String sql = "INSERT INTO produktuak (izena, deskribapena, prezioa, stocka, kategoria_id, irudiak) VALUES (?,?,?,?,?,?)";
        try (Connection con = konektatu(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getIzena());
            ps.setString(2, p.getDeskribapena());
            ps.setDouble(3, p.getPrezioa());
            ps.setInt(4, p.getStocka());
            ps.setInt(5, Integer.parseInt(p.getKategoria()));
            ps.setString(6, p.getIrudiak());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean eguneratu(Produktua p) {
        String sql = "UPDATE produktuak SET izena=?, deskribapena=?, prezioa=?, stocka=?, kategoria_id=?, irudiak=? WHERE id=?";
        try (Connection con = konektatu(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getIzena());
            ps.setString(2, p.getDeskribapena());
            ps.setDouble(3, p.getPrezioa());
            ps.setInt(4, p.getStocka());
            ps.setInt(5, Integer.parseInt(p.getKategoria()));
            ps.setString(6, p.getIrudiak());
            ps.setInt(7, p.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean ezabatu(int id) {
        String sql = "DELETE FROM produktuak WHERE id=?";
        try (Connection con = konektatu(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public static List<Produktua> bilatu(String testua) {
        List<Produktua> lista = new ArrayList<>();
        String sql = "SELECT * FROM produktuak WHERE izena LIKE ? OR deskribapena LIKE ?";
        try (Connection con = konektatu(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + testua + "%");
            ps.setString(2, "%" + testua + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Produktua(rs.getInt("id"), rs.getString("izena"), rs.getString("deskribapena"),
                        rs.getDouble("prezioa"), rs.getInt("stocka"),
                        String.valueOf(rs.getInt("kategoria_id")), rs.getString("irudiak")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
