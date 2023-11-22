import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class KlientProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrangementRegister arrangementRegister = new ArrangementRegister();

        while (true) {
            System.out.println("\nVelg en operasjon:");
            System.out.println("1. Legg til arrangement");
            System.out.println("2. Finn arrangementer på et gitt sted");
            System.out.println("3. Finn arrangementer på en gitt dato");
            System.out.println("4. Finn arrangementer innenfor et tidsintervall");
            System.out.println("5. Liste over arrangementer sortert etter sted");
            System.out.println("6. Liste over arrangementer sortert etter type");
            System.out.println("7. Liste over arrangementer sortert etter tidspunkt");
            System.out.println("8. Avslutt");

            int valg = scanner.nextInt();
            scanner.nextLine(); // Consuming the newline character

            switch (valg) {
                case 1:
                    leggTilArrangement(scanner, arrangementRegister);
                    break;
                case 2:
                    finnArrangementerPaaSted(scanner, arrangementRegister);
                    break;
                case 3:
                    finnArrangementerPaaDato(scanner, arrangementRegister);
                    break;
                case 4:
                    finnArrangementerITidsintervall(scanner, arrangementRegister);
                    break;
                case 5:
                    listeOverArrangementerSortert(scanner, arrangementRegister, Comparator.comparing(Arrangement::getSted));
                    break;
                case 6:
                    listeOverArrangementerSortert(scanner, arrangementRegister, Comparator.comparing(Arrangement::getType));
                    break;
                case 7:
                    listeOverArrangementerSortert(scanner, arrangementRegister, Comparator.comparingInt(Arrangement::getTidspunkt));
                    break;
                case 8:
                    System.out.println("Programmet avsluttet.");
                    System.exit(0);
                default:
                    System.out.println("Ugyldig valg. Prøv igjen.");
            }
        }
    }

    private static void leggTilArrangement(Scanner scanner, ArrangementRegister arrangementRegister) {
        System.out.println("Legg til arrangement:");
        System.out.print("Nummer: ");
        int nummer = scanner.nextInt();
        scanner.nextLine(); // Consuming the newline character
        System.out.print("Navn: ");
        String navn = scanner.nextLine();
        System.out.print("Sted: ");
        String sted = scanner.nextLine();
        System.out.print("Arrangør: ");
        String arrangor = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Tidspunkt (klokkeslett som hh:mm, f.eks. 18:00): ");
        String tidspunktString = scanner.nextLine();
    
        try {
            // Konverter tidspunktet til heltall
            String[] tidspunktDeler = tidspunktString.split(":");
            int time = Integer.parseInt(tidspunktDeler[0]);
            int minutt = Integer.parseInt(tidspunktDeler[1]);
    
            int fulltTidspunkt = (time * 100) + minutt; // f.eks. 1800
    
            Arrangement arrangement = new Arrangement(nummer, navn, sted, arrangor, type, fulltTidspunkt);
            arrangementRegister.leggTilArrangement(arrangement);
            System.out.println("Arrangement lagt til!");
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Feil format for tidspunkt. Skriv inn som hh:mm, f.eks. 18:00.");
        }
    }
    
    
    private static void finnArrangementerPaaSted(Scanner scanner, ArrangementRegister arrangementRegister) {
        System.out.print("Skriv inn sted: ");
        String sted = scanner.nextLine();
        List<Arrangement> arrangementer = arrangementRegister.finnArrangementerPaaSted(sted);
        skrivUtArrangementer(arrangementer);
    }

    private static void finnArrangementerPaaDato(Scanner scanner, ArrangementRegister arrangementRegister) {
        System.out.print("Skriv inn dato (som heltall, f.eks. 20021030): ");
        int dato = scanner.nextInt();
        List<Arrangement> arrangementer = arrangementRegister.finnArrangementerPaaDato(dato);
        skrivUtArrangementer(arrangementer);
    }

    private static void finnArrangementerITidsintervall(Scanner scanner, ArrangementRegister arrangementRegister) {
        System.out.print("Skriv inn startdato (som heltall, f.eks. 20021030): ");
        int startDato = scanner.nextInt();
        System.out.print("Skriv inn sluttdato (som heltall, f.eks. 20021031): ");
        int sluttDato = scanner.nextInt();
        List<Arrangement> arrangementer = arrangementRegister.finnArrangementerITidsintervall(startDato, sluttDato);
        skrivUtArrangementer(arrangementer);
    }

    private static void listeOverArrangementerSortert(Scanner scanner, ArrangementRegister arrangementRegister, Comparator<Arrangement> sorteringsnokkel) {
        List<Arrangement> arrangementer = arrangementRegister.listeOverArrangementerSortert(sorteringsnokkel);
        skrivUtArrangementer(arrangementer);
    }

    private static void skrivUtArrangementer(List<Arrangement> arrangementer) {
        if (arrangementer.isEmpty()) {
            System.out.println("Ingen arrangementer funnet.");
        } else {
            for (Arrangement arrangement : arrangementer) {
                System.out.println(arrangement.getNummer() + ": " + arrangement.getNavn() +
                        " - Sted: " + arrangement.getSted() +
                        ", Arrangør: " + arrangement.getArrangor() +
                        ", Type: " + arrangement.getType() +
                        ", Tidspunkt: " + arrangement.getTidspunkt());
            }
        }
    }
}