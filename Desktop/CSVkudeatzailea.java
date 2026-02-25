package ERRONKA4_ANDER_GIL.Desktop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVkudeatzailea {

    public static int kargatu(String fitxategia) {
        int kontagailua = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fitxategia))) {
            String linea;
            br.readLine(); // Goiburua saltatu
            while ((linea = br.readLine()) != null) {
                try {
                    String[] datuak = linea.split(";");
                    if (datuak.length >= 6) {
                        String izena = datuak[0].trim();
                        String deskribapena = datuak[1].trim();
                        double prezioa = Double.parseDouble(datuak[2].trim());
                        int stocka = Integer.parseInt(datuak[3].trim());
                        String kategoria = datuak[4].trim();
                        String irudiak = datuak[5].trim();
                        if (DatuBasea.gehitu(new Produktua(izena, deskribapena, prezioa, stocka, kategoria, irudiak)))
                            kontagailua++;
                    }
                } catch (Exception e) {
                    System.err.println("Errorea lerro hau kargatzerakoan: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Errorea fitxategia irakurtzerakoan: " + e.getMessage());
        }
        return kontagailua;
    }
}
