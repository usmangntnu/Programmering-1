// Oppgave 4A

import java.util.Scanner;

/**
 * Klientklasse for å håndtere brukergrensesnittet til eiendomsregisterapplikasjonen.
 */
public class EiendomsRegisterKlient {

    private EiendomsRegister register;
    private Scanner scanner;

    /**
     * Konstruktør for å opprette en ny klient med et eiendomsregister og en Scanner for brukerinndata.
     */
    public EiendomsRegisterKlient() {
        register = new EiendomsRegister();
        scanner = new Scanner(System.in);
    }

    /**
     * Metode for å starte klientapplikasjonen og vise hovedmenyen.
     */
    public void start() {
        int valg;

        do {
            valg = showMenu();

            switch (valg) {
                case 1:
                    registrerEiendom();
                    break;
                case 2:
                    skrivUtAlleEiendommer();
                    break;
                case 3:
                    sokEtterEiendom();
                    break;
                case 4:
                    visGjennomsnittsAreal();
                    break;
                case 0:
                    System.out.println("Avslutter programmet.");
                    break;
                default:
                    System.out.println("Ugyldig valg. Prøv igjen.");
            }

        } while (valg != 0);
    }

    /**
     * Viser hovedmenyen og returnerer brukerens valg.
     *
     * @return Brukerens valg fra menyen.
     */
    private int showMenu() {
        System.out.println("=== Meny ===");
        System.out.println("1. Registrer eiendom");
        System.out.println("2. Skriv ut alle eiendommer");
        System.out.println("3. Søk etter eiendom");
        System.out.println("4. Vis gjennomsnittsareal");
        System.out.println("0. Avslutt");
        System.out.print("Velg et alternativ: ");

        return scanner.nextInt();
    }

    /**
     * Metode for å registrere en ny eiendom ved å be brukeren om nødvendig informasjon.
     */
    private void registrerEiendom() {
        System.out.print("Skriv inn kommunenummer: ");
        int kommunenummer = scanner.nextInt();

        System.out.print("Skriv inn gårdsnummer: ");
        int gardsnummer = scanner.nextInt();

        System.out.print("Skriv inn bruksnummer: ");
        int bruksnummer = scanner.nextInt();

        System.out.print("Skriv inn bruksnavn (trykk Enter hvis ingen navn): ");
        scanner.nextLine(); // Tømmer bufferen
        String bruksnavn = scanner.nextLine();

        System.out.print("Skriv inn areal: ");
        double areal = scanner.nextDouble();

        System.out.print("Skriv inn eierens navn: ");
        scanner.nextLine(); // Tømmer bufferen
        String eierNavn = scanner.nextLine();

        Eiendom nyEiendom = new Eiendom(kommunenummer, gardsnummer, bruksnummer, bruksnavn, areal, eierNavn);
        register.registerEiendom(nyEiendom);

        System.out.println("Eiendom registrert!");
    }

    /**
     * Metode for å skrive ut alle eiendommene i registeret.
     */
    private void skrivUtAlleEiendommer() {
        System.out.println("=== Alle eiendommer ===");
        for (Eiendom eiendom : register.getEiendomListe()) {
            System.out.println(eiendom);
        }
    }

    /**
     * Metode for å søke etter en eiendom basert på kommunenummer, gårdsnummer og bruksnummer.
     */
    private void sokEtterEiendom() {
        System.out.print("Skriv inn kommunenummer: ");
        int kommunenummer = scanner.nextInt();

        System.out.print("Skriv inn gårdsnummer: ");
        int gardsnummer = scanner.nextInt();

        System.out.print("Skriv inn bruksnummer: ");
        int bruksnummer = scanner.nextInt();

        Eiendom funnetEiendom = register.finnEiendom(kommunenummer, gardsnummer, bruksnummer);

        if (funnetEiendom != null) {
            System.out.println("Eiendom funnet: " + funnetEiendom);
        } else {
            System.out.println("Ingen eiendom funnet med angitte numre.");
        }
    }
    /**
     * Metode for å vise gjennomsnittsarealet av alle eiendommene i registeret.
     */
    private void visGjennomsnittsAreal() {
        double gjennomsnittsareal = register.beregnGjennomsnittsareal();
        System.out.println("Gjennomsnittsareal av alle eiendommene: " + gjennomsnittsareal + " m2");
    }

    /**
     * Hovedmetode for å kjøre klientprogrammet.
     *
     * @param args Kommandolinjeargumenter (ikke brukt i dette tilfellet).
     */
    public static void main(String[] args) {
        EiendomsRegisterKlient klient = new EiendomsRegisterKlient();
        klient.start();
    }
}
