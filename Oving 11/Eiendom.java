// Oppgave 2A og 2B

public class Eiendom {
    
    //Eiendomsinformasjon 
    private int kommunenummer;
    private int gårdsnummer; 
    private int bruksnummer;
    private String bruksnavn;
    private double areal;
    private String eierNavn; 

    // Konstruktør
    public Eiendom(int kommunenummer, int gårdsnummer, int bruksnummer, String bruksnavn, double areal, String eierNavn) {
        this.kommunenummer = kommunenummer;
        this.gårdsnummer = gårdsnummer;
        this.bruksnummer = bruksnummer;
        this.bruksnavn = bruksnavn;
        this.areal = areal;
        this.eierNavn = eierNavn;
    }

    //Aksessor-metoder for å hente verdier
    public int getKommunenummer() {
        return kommunenummer;
    }

    public int getGårdsnummer() {
        return gårdsnummer;
    }

    public int getBruksnummer() {
        return bruksnummer;
    }

    public String getBruksnavn() {
        return bruksnavn;
    }

    public double getAreal() {
        return areal;
    }

    public String getEierNavn() {
        return eierNavn;
    }

    // Mutator-metoder for å oppdatere verdier
    public void setBruksnavn(String nyttBruksnavn) {
        this.bruksnavn = nyttBruksnavn;
    }

    public void setAreal(double nyttAreal) {
        if (nyttAreal > 0) {
            this.areal = nyttAreal;
        } else {
            System.out.println("Ugyldig areal. Areal må være et positivt tall.");
        }
    }

    public void setEierNavn(String nyttEierNavn) {
        this.eierNavn = nyttEierNavn;
    }

// Dokumentasjon for klassen
    /**
     * Eiendom-klassen representerer en eiendom med relevant informasjon, inkludert
     * kommunenummer, gårdsnummer, bruksnummer, bruksnavn, areal og eierens navn.
     *
     * @param kommunenummer Kommunenummeret der eiendommen ligger.
     * @param gardsnummer   Gårdsnummeret til eiendommen.
     * @param bruksnummer   Bruksnummeret til eiendommen.
     * @param bruksnavn     Navn på eiendommen.
     * @param areal         Areal i kvadratmeter.
     * @param eierNavn      Navn på eieren av eiendommen.
     */

    public String getEiendomsID() {
        return kommunenummer + "-" + gårdsnummer + "/" + bruksnummer;
        } 
    
        @Override
    public String toString() {
        return String.format("Kommunenummer: %d, Gårdsnummer: %d, Bruksnummer: %d, Bruksnavn: %s, Areal: %.2f, Eier: %s",
                                kommunenummer, gårdsnummer, bruksnummer, bruksnavn, areal, eierNavn);
        }
    // Dokumentasjon for metoden
        /**
        * Returnerer en tekststreng som representerer ID-en til eiendommen.
        * Formatet er "kommunenr-gnr/bnr".
        *
        * @return Tekststreng av eiendoms-ID.
        */
}