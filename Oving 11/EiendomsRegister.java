// Oppgave 3A, 3B og 3C

import java.util.ArrayList;
import java.util.Iterator;

// Klasse som representerer et register av eiendommer
public class EiendomsRegister {

    // ArrayList for å lagre eiendommer
    private ArrayList<Eiendom> eiendomListe;

    // Konstruktør 
    public EiendomsRegister() {
        eiendomListe = new ArrayList<>();
    }

    /**
     * Registrerer en eiendom i registeret.
     *
     * @param eiendom Eiendommen som skal registreres.
     */
    public void registerEiendom(Eiendom eiendom) {
        eiendomListe.add(eiendom);
    }

    /**
     * Henter listen over alle eiendommer i registeret.
     *
     * @return En ArrayList av alle eiendommer i registeret.
     */
    public ArrayList<Eiendom> getEiendomListe() {
        return eiendomListe;
    }

    /**
     * Sletter en eiendom fra registeret.
     *
     * @param eiendom Eiendommen som skal slettes.
     * @return true hvis eiendommen ble slettet, ellers false.
     */
    public boolean slettEiendom(Eiendom eiendom) {
        return eiendomListe.remove(eiendom);
    }

    /**
     * Returnerer antall eiendommer i registeret.
     *
     * @return Antall eiendommer i registeret.
     */
    public int antallEiendommer() {
        return eiendomListe.size();
    }

    /**
     * Finner en eiendom basert på kommunenummer, gardsnummer (gnr) og bruksnummer.
     *
     * @param kommunenummer Kommunenummeret til eiendommen.
     * @param gardsnummer   Gårdsnummeret til eiendommen.
     * @param bruksnummer   Bruksnummeret til eiendommen.
     * @return Eiendommen som matcher søkekriteriene, eller null hvis ikke funnet.
     */
    public Eiendom finnEiendom(int kommunenummer, int gardsnummer, int bruksnummer) {
        for (Eiendom eiendom : eiendomListe) {
            if (eiendom.getKommunenummer() == kommunenummer &&
                eiendom.getGårdsnummer() == gardsnummer &&
                eiendom.getBruksnummer() == bruksnummer) {
                return eiendom;
            }
        }
        return null; // Eiendom ikke funnet
    }

    // Dokumentasjon for klassen
    /**
     * EiendomsRegister-klassen representerer et register av eiendommer ved å bruke
     * en ArrayList for å lagre eiendommer dynamisk. Dette gir fleksibilitet med hensyn
     * til størrelse på registeret, og gjør det enkelt å legge til og fjerne eiendommer.
     *
     * @see Eiendom
     */

    
    
/**
 * Beregner gjennomsnittsareal av alle eiendommene i registeret.
 *
 * @return Gjennomsnittsareal av eiendommene i registeret.
 */
    public double beregnGjennomsnittsareal() {
        if (eiendomListe.isEmpty()) {
            return 0; // Returnerer 0 hvis registeret er tomt for å unngå delt på null-feil
        }   

        double totalAreal = 0;

        for (Eiendom eiendom : eiendomListe) {
            totalAreal += eiendom.getAreal();
        }

        return totalAreal / eiendomListe.size();
    }

    /**
    * Returnerer alle eiendommer med et gitt gårdsnummer.
    *
    * @param gardsnummer Gårdsnummeret som skal matches.
    * @return ArrayList med eiendommer som har det gitte gårdsnummeret.
    */
    public ArrayList<Eiendom> finnEiendommerMedGardsnummer(int gardsnummer) {
    ArrayList<Eiendom> matchendeEiendommer = new ArrayList<>();

    for (Eiendom eiendom : eiendomListe) {
        if (eiendom.getGårdsnummer() == gardsnummer) {
            matchendeEiendommer.add(eiendom);
        }
    }

    return matchendeEiendommer;
    }
}
