import java.text.BreakIterator;
import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

public class Øving72 {
    private String tekst;

    public Øving72(String tekst) {
        this.tekst = tekst;
    }

    public int antallOrd() {
        String[] ord = tekst.split("\\s+");
        return ord.length;
    }

    public double gjennomsnittligOrdLengde() {
        String[] ord = tekst.split("\\s+");
        int totalLengde = 0;
        for (String ordet : ord) {
            totalLengde += ordet.length();
        }
        return (double) totalLengde / antallOrd();
    }

    public double gjennomsnittligAntallOrdPerPeriode() {
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        iterator.setText(tekst);
        int antallPerioder = 0;
        int totalAntallOrd = 0;

        int start = iterator.first();
        int end = iterator.next();
        while (end != BreakIterator.DONE) {
            String periode = tekst.substring(start, end);
            String[] ord = periode.split("\\s+");
            antallPerioder++;
            totalAntallOrd += ord.length;

            start = end;
            end = iterator.next();
        }

        return (double) totalAntallOrd / antallPerioder;
    }

    public String byttOrd(String gammeltOrd, String nyttOrd) {
        return tekst.replaceAll(Pattern.quote(gammeltOrd), nyttOrd);
    }

    public String hentOriginalTekst() {
        return tekst;
    }

    public String hentTekstMedStoreBokstaver() {
        return tekst.toUpperCase();
    }

    public static void main(String[] args) {
        String inputTekst = "Dette er en enkel tekstbehandling. Den fungerer greit. "
                + "Æ, Ø, og Å er inkludert.";
        Øving72 tekstbehandling = new Øving72(inputTekst);

        System.out.println("Antall ord: " + tekstbehandling.antallOrd());
        System.out.println("Gjennomsnittlig ordlengde: " + tekstbehandling.gjennomsnittligOrdLengde());
        System.out.println("Gjennomsnittlig antall ord per periode: " + tekstbehandling.gjennomsnittligAntallOrdPerPeriode());
        System.out.println("Bytt ord: " + tekstbehandling.byttOrd("enkel", "enkelere"));
        System.out.println("Original tekst: " + tekstbehandling.hentOriginalTekst());
        System.out.println("Tekst med store bokstaver: " + tekstbehandling.hentTekstMedStoreBokstaver());
    }
}