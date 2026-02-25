package ERRONKA4_ANDER_GIL.Desktop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ProduktuTest {
    @Test
    void testPK1_GuztiaOndo() {
        Produktua p = new Produktua("Kamiseta", "Gorria", 30.0, 10, "Kamisetak", "irudia.jpg");
        assertAll("Produktu egokiaren balioak egiaztatu",
                () -> assertEquals("Kamiseta", p.getIzena()),
                () -> assertEquals(30.0, p.getPrezioa()),
                () -> assertEquals(10, p.getStocka()));
    }

    @Test
    void testPK2_IzenaZenbakia() {
        Produktua p = new Produktua("123", "Gorria", 30.0, 10, "Kamisetak", "irudia.jpg");
        assertTrue(p.getIzena().matches("\\d+"), "EB1: Izenak zenbakizkoa izan behar du test honetan");
    }

    @Test
    void testPK3_DeskribapenaHutsa() {
        Produktua p = new Produktua("Kamiseta", "", 30.0, 10, "Kamisetak", "irudia.jpg");
        assertTrue(p.getDeskribapena().isEmpty(), "EB2: Deskribapena hutsik dago");
    }

    @Test
    void testPK4_PrezioaBaxuegia() {
        Produktua p = new Produktua("Kamiseta", "Gorria", 0.0, 10, "Kamisetak", "irudia.jpg");
        assertTrue(p.getPrezioa() < 1, "EB3: Prezioa 1 baino txikiagoa da");
    }

    @Test
    void testPK5_PrezioaAltuenergia() {
        Produktua p = new Produktua("Kamiseta", "Gorria", 9999999.0, 10, "Kamisetak", "irudia.jpg");
        assertTrue(p.getPrezioa() > 10000, "EB4: Prezioa muga gainetik dago");
    }

    @Test
    void testPK6_StockNegatiboa() {
        Produktua p = new Produktua("kamiseta", "gorria", 30.0, -1, "kamisetak", "irudia.jpg");
        assertTrue(p.getStocka() < 0, "EB5: Stocka negatiboa da");
    }

    @Test
    void testPK7_StockAltuenergia() {
        Produktua p = new Produktua("Kamiseta", "Gorria", 30.0, 200, "Kamisetak", "irudia.jpg");
        assertTrue(p.getStocka() > 100, "EB6: Stocka muga gainetik dago (100)");
    }
}