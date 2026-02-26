package ERRONKA4_ANDER_GIL.Desktop;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Produktuak JSON formatora esportatzeko klasea.
 * Produktuen zerrenda JSON fitxategian gordetzen du.
 * 
 * @author Ander Gil
 * @version 1.0
 */
public class JSONKudeatzailea {

    /**
     * Produktuak JSON formatoan fitxategian esportatu.
     * JAVADOC: 18. lerroan
     * 
     * @param fitxategia JSON fitxategiaren bidea
     * @param produktuak Esportatzeko produktuen zerrenda
     */
    public static void esportatu(String fitxategia, List<Produktua> produktuak) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < produktuak.size(); i++) {
            Produktua p = produktuak.get(i);
            sb.append("  {\n");
            sb.append("    \"id\": ").append(p.getId()).append(",\n");
            sb.append("    \"title\": \"").append(p.getIzena()).append("\",\n");
            sb.append("    \"description\": \"").append(p.getDeskribapena()).append("\",\n");
            sb.append("    \"price\": ").append(p.getPrezioa()).append(",\n");
            sb.append("    \"stock\": ").append(p.getStocka()).append(",\n");
            sb.append("    \"category\": \"").append(p.getKategoria()).append("\",\n");
            sb.append("    \"image\": \"").append(p.getIrudiak()).append("\"\n");
            sb.append("  }");
            if (i < produktuak.size() - 1)
                sb.append(",");
            sb.append("\n");
        }
        sb.append("]");

        try (FileWriter fw = new FileWriter(fitxategia)) {
            fw.write(sb.toString());
            System.out.println("JSON fitxategia ondo sortu da: " + fitxategia);
        } catch (IOException e) {
            System.out.println("Errorea JSON fitxategia sortzerakoan: " + e.getMessage());
        }
    }
}
