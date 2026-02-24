package ERRONKA4_ANDER_GIL.Desktop;
import java.util.Scanner;

public class Main {

   public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    int aukera = 0;

    do{
        System.out.println("--- INDIUSURBIL KUDEAKETA ---");
        System.out.println("1. Produktuak zerrendatu");
        System.out.println("2. Produktua gehitu");
        System.out.println("3. Produktua aldatu");
        System.out.println("4. Produktua ezabatu");
        System.out.println("5. CSV-tik kargatu");
        System.out.println("6. JSON-era esportatu");
        System.out.println("7. Bilatu produktua");
        System.out.println("0. Irten");
        System.out.println("Hautatu aukera bat: ");

        try{
            aukera = sc.nextInt();
            sc.nextLine();

            switch(aukera){
                case 1: 
                System.out.println("Produktuak zerrendatzen...");
                //Deitu datubase
                break;
                 case 2: 
                System.out.println("Produktua gehitzen...");
                //Deitu datubase
                break;
                 case 3: 
                System.out.println("Produktua aldatzen...");
                //Deitu datubase
                break;
                 case 4: 
                System.out.println("Produktua ezabatzen...");
                //Deitu datubase
                break;
                 case 5: 
                System.out.println("CSV_tik produktuak kargatzen...");
                //Deitu datubase
                break;
                 case 6: 
                System.out.println("JSON-era esportatzen...");
                //Deitu datubase
                break;
                 case 7: 
                System.out.println("Sartu bilatzeko testua: ");
                        String testua = sc.nextLine();
                        System.out.println("Bilatzen: " + testua);;
                //Deitu datubase
                break;
                 case 0: 
                System.out.println("Agur!!");
                break;
                default:
                    System.out.println("Aukera okerra.");
            }
         }
            catch (Exception e){
                System.out.println("Errorea: Sartu zenbaki bat mesedez.");
                sc.nextLine();
            } 
        }
            while (aukera !=0);
                sc.close();
            
       
   
   }
}


