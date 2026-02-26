package ERRONKA4_ANDER_GIL.Desktop;

/**
 * Produktuaren klasea. Dendan saltaturiko edukia adierazten du.
 * Propietateak: id, izena, deskribapena, prezioa, stocka, kategoria eta irudiak.
 * 
 * @author Ander Gil
 * @version 1.0
 */
public class Produktua {

    private int id;
    private String izena;
    private String deskribapena;
    private double prezioa;
    private int stocka;
    private String kategoria;
    private String irudiak;

    /**
     * Konstruktorea id gabe. Produktu berriak sortzeko erabiltzen da.
     * 
     * @param izena Produktuaren izena
     * @param deskribapena Produktuaren deskribapena
     * @param prezioa Produktuaren prezioa
     * @param stocka Produktuaren stock kopurua
     * @param kategoria Produktuaren kategoria
     * @param irudiak Produktuaren irudiaren fitxategia
     */
    public Produktua(String izena, String deskribapena, double prezioa, int stocka, String kategoria, String irudiak) {
        this.izena = izena;
        this.deskribapena = deskribapena;
        this.prezioa = prezioa;
        this.stocka = stocka;
        this.kategoria = kategoria;
        this.irudiak = irudiak;
    }

    /**
     * Konstruktorea id-arekin. Datu-basetik irakurtzeko produktuak sortzeko erabiltzen da.
     * 
     * @param id Produktuaren identifikadorea
     * @param izena Produktuaren izena
     * @param deskribapena Produktuaren deskribapena
     * @param prezioa Produktuaren prezioa
     * @param stocka Produktuaren stock kopurua
     * @param kategoria Produktuaren kategoria
     * @param irudiak Produktuaren irudiaren fitxategia
     */
    public Produktua(int id, String izena, String deskribapena, double prezioa, int stocka, String kategoria,
    /**
     * Produktuaren identifikadorea lortu.
     * JAVADOC: 59. lerroan
     * @return produktuaren id
     */
            String irudiak) {
        this.id = id;
        this.izena = izena;
        this.deskribapena = deskribapena;
        this.prezioa = prezioa;
        this.stocka = stocka;
        this.kategoria = kategoria;
        this.irudiak = irudiak;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getDeskribapena() {
        return deskribapena;
    }

    public void setDeskribapena(String deskribapena) {
        this.deskribapena = deskribapena;
    }

    public double getPrezioa() {
        return prezioa;
    }

    public void setPrezioa(double prezioa) {
        this.prezioa = prezioa;
    }

    public int getStocka() {
        return stocka;
    }

    public void setStocka(int stocka) {
        this.stocka = stocka;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getIrudiak() {
        return irudiak;
    }

    public void setIrudiak(String irudiak) {
        this.irudiak = irudiak;
    }

}
