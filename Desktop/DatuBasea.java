package ERRONKA4_ANDER_GIL.Desktop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Datu-basea kudeatzeko klasea. MySQL datu-basearekin konektatu eta
 * produktuen eragiketak (sortu, irakurri, eguneratu, ezabatu) egiten ditu.
 * 
 * @author Ander Gil
 * @version 1.0
 */
public class DatuBasea {
    private static final String URL = "jdbc:mysql://localhost:3307/indiusurbil";
    private static final String USER = "root";
    private static final String PASS = "Passwordsql";

    /**
     * Datu-basearekin konektatu.
     * JAVADOC: 28. lerroan
     * 
     * @return Datu-basearekin konektatu edo null konektaketa huts bada
     */
    public static Connection konektatu() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Datu-basetik produktuen zerrenda lortu.
     * JAVADOC: 37. lerroan
     * 
     * @return Produktuen zerrenda
     */
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
            /**
             * Produktu berria datu-basean gehitu.
             * JAVADOC: 50. lerroan
             * 
             * @param p Gehitzeko produktua
             * @return true ondo gehitu bada, false bestela
             */
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
            /**
             * Datu-basean produktua eguneratu.
             * JAVADOC: 62. lerroan
             * 
             * @param p Eguneratzeko produktua
             * @return true ondo eguneratu bada, false bestela
             */
            ps.setString(6, p.getIrudiak());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean eguneratu(Produktua p) {
        String sql = "UPDATE produktuak SET izena=?, deskribapena=?, prezioa=?, stocka=?, kategoria_id=?, irudiak=? WHERE id=?";
        /**
         * Produktua datu-basean ezabatu ID bidez.
         * JAVADOC: 74. lerroan
         * 
         * @param id Ezabatzeko produktuaren ID
         * @return true ondo ezabatu bada, false bestela
         */
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
            /**
             * Produktuak bilaatu testua izena edo deskribapena bidez.
             * JAVADOC: 83. lerroan
             * 
             * @param testua Bilatzeko testua
             * @return Bilatutako produktuen zerrenda
             */
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
