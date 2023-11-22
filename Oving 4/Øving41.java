import java.util.Scanner;

class Valuta {
    private String navn;
    private double kurs;

    public Valuta(String navn, double kurs) {
        this.navn = navn; 
        this.kurs = kurs;
    }

    public double tilNorskeKrone(double beløp) {
        return beløp * kurs;
    }

    public String getNavn() {
        return navn;
    }
}

public class Øving41 {
    public static void main(String[] args) {
        Valuta dollar = new Valuta("Dollar", 8.80);
        Valuta euro = new Valuta("Euro", 10.30);
        Valuta svenske = new Valuta("Svenske kroner", 1.03);

        Valuta[] valutaer = {dollar, euro, svenske};

        Scanner scanner = new Scanner(System.in); 
        while (true) {
            System.out.println("Velg valuta:");

            for (int i = 0; i < valutaer.length; i++) {
                System.out.println((i + 1) + ": " + valutaer[i].getNavn());
            }
            System.out.println("4: Avslutt");

            int valg = scanner.nextInt(); 

            if (valg == 4) {
                break;
            } else if (valg >= 1 && valg <= valutaer.length) {
                Valuta valuta = valutaer[valg - 1];
                System.out.print("Oppgi beløp i " + valuta.getNavn() + ": ");
                double beløp = scanner.nextDouble();
                double norskeKroner = valuta.tilNorskeKrone(beløp);
                System.out.println(beløp + " " + valuta.getNavn() + " tilsvarer " + norskeKroner + " norske kroner");
            } else {
                System.out.println("Ugyldig valg. Vennligst velg 1, 2, 3 eller 4 for å avslutte");
            }
        }
    }
}