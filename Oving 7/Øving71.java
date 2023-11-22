public class Øving71 {
    private final String tekst;

    public Øving71(String tekst) {
        this.tekst = tekst;
    }

    public Øving71 forkort() {
        String[] ord = tekst.split(" ");
        StringBuilder forkortetTekst = new StringBuilder();
        
        for (String ordet : ord) {
            if (!ordet.isEmpty()) {
                forkortetTekst.append(ordet.charAt(0));
            }
        }
        
        return new Øving71(forkortetTekst.toString());
    }

    public Øving71 fjernTegn(char tegn) {
        StringBuilder nyTekst = new StringBuilder();
        int indeks = tekst.indexOf(tegn);
    
        int start = 0;
        while (indeks != -1) {
            nyTekst.append(tekst.substring(start, indeks));
            start = indeks + 1;
            indeks = tekst.indexOf(tegn, start);
        }
        nyTekst.append(tekst.substring(start));
    
        return new Øving71(nyTekst.toString());
    }
    

    public String toString() {
        return tekst;
    }

    public static void main(String[] args) {
        Øving71 nyString = new Øving71("denne setningen kan forkortes");

        Øving71 forkortet = nyString.forkort();
        System.out.println("Forkortet tekst: " + forkortet);

        Øving71 fjernetE = nyString.fjernTegn('e');
        System.out.println("Tekst med 'e' fjernet: " + fjernetE);
    }
}