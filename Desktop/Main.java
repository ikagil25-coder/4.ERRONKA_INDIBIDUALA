package ERRONKA4_ANDER_GIL.Desktop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aukera;
        do {
            System.out.println(
                    "1.Bistaratatu produktuak\n 2.Gehitu Produktuak\n 3.Aldatu Produktuak\n 4.Ezabatu Produktuak\n 5.CSV-tik kargatu\n 6.JSON esportatu\n 7.Bilatu Produktuak\n 0.Irten");
            System.out.print("Aukera: ");
            aukera = sc.nextInt();
            sc.nextLine();

            switch (aukera) {
                case 1 -> {
                    for (Produktua p : DatuBasea.zerrendatu())
                        System.out.println(p.getId() + " - " + p.getIzena() + " (" + p.getPrezioa() + "€)");
                }
                case 2 -> {
                    System.out.print("Izena: ");
                    String iz = sc.nextLine();
                    System.out.print("Deskribapena: ");
                    String de = sc.nextLine();
                    System.out.print("Prezioa: ");
                    double pr = sc.nextDouble();
                    System.out.print("Stocka: ");
                    int st = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Kategoria ID: ");
                    String ka = sc.nextLine();
                    System.out.print("Irudia: ");
                    String ir = sc.nextLine();
                    if (DatuBasea.gehitu(new Produktua(iz, de, pr, st, ka, ir)))
                        System.out.println("OK!");
                }
                case 3 -> {
                    for (Produktua p : DatuBasea.zerrendatu())
                        System.out.println(p.getId() + " - " + p.getIzena());
                    System.out.print("Aldatzeko ID-a: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("BERRIA - Izena: ");
                    String iz = sc.nextLine();
                    System.out.print("BERRIA - Deskribapena: ");
                    String de = sc.nextLine();
                    System.out.print("BERRIA - Prezioa: ");
                    double pr = sc.nextDouble();
                    System.out.print("BERRIA - Stocka: ");
                    int st = sc.nextInt();
                    sc.nextLine();
                    System.out.print("BERRIA - Kategoria ID: ");
                    String ka = sc.nextLine();
                    System.out.print("BERRIA - Irudia: ");
                    String ir = sc.nextLine();
                    if (DatuBasea.eguneratu(new Produktua(id, iz, de, pr, st, ka, ir)))
                        System.out.println("OK!");
                }
                case 4 -> {
                    for (Produktua p : DatuBasea.zerrendatu())
                        System.out.println(p.getId() + " - " + p.getIzena());
                    System.out.print("Ezabatzeko ID-a: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (DatuBasea.ezabatu(id))
                        System.out.println("OK!");
                }
                case 5 -> {
                    System.out.print("CSV fitxategiaren bidea: ");
                    String bidea = sc.nextLine();
                    int kopurua = CSVkudeatzailea.kargatu(bidea);
                    System.out.println(kopurua + " produktu kargatu dira.");
                }
                case 6 -> {
                    JSONKudeatzailea.esportatu("ERRONKA4_ANDER_GIL/Web/htdocs/produktuak.json", DatuBasea.zerrendatu());
                }
                case 7 -> {
                    System.out.print("Search text: ");
                    String text = sc.nextLine();
                    for (Produktua p : DatuBasea.bilatu(text))
                        System.out.println(p.getId() + " - " + p.getIzena());
                }
                case 0 -> System.out.println("Agur!");
                default -> System.out.println("Aukera okerra.");
            }
        } while (aukera != 0);
        sc.close();
    }
}
