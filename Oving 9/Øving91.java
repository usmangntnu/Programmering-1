public class Øving91 {
    private String navn;
    private int antOppg;

    public Øving91(String navn) {
        this.navn = navn;
        this.antOppg = 0;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntOppg() {
        return antOppg;
    }

    public void økAntOppg(int økning) {
        antOppg += økning;
    }

    @Override
    public String toString() {
        return "Student: " + navn + ", Antall godkjente oppgaver: " + antOppg;
    }
}

public class Oppgaveoversikt {
    private Øving91[] studenter;
    private int antStud;

    public Oppgaveoversikt(int maksAntStudenter) {
        studenter = new Øving91[maksAntStudenter];
        antStud = 0;
    }

    public int finnAntallStudenter() {
        return antStud;
    }

    public int finnAntallOppgaver(String studentNavn) {
        for (int i = 0; i < antStud; i++) {
            if (studenter[i].getNavn().equals(studentNavn)) {
                return studenter[i].getAntOppg();
            }
        }
        return -1; // Returnerer -1 hvis studenten ikke finnes
    }

    public void registrerStudent(String navn) {
        if (antStud < studenter.length) {
            studenter[antStud] = new Øving91(navn);
            antStud++;
        } else {
            System.out.println("Maksimalt antall studenter er nådd.");
        }
    }

    public void økAntallOppgaver(String studentNavn, int økning) {
        for (int i = 0; i < antStud; i++) {
            if (studenter[i].getNavn().equals(studentNavn)) {
                studenter[i].økAntOppg(økning);
                return;
            }
        }
        System.out.println("Studenten med navn " + studentNavn + " ble ikke funnet.");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < antStud; i++) {
            result.append(studenter[i].toString()).append("\n");
        }
        return result.toString();
    }
}

public class TestOppgaveoversikt {
    public static void main(String[] args) {
        Oppgaveoversikt oversikt = new Oppgaveoversikt(10);

        oversikt.registrerStudent("Student1");
        oversikt.registrerStudent("Student2");

        oversikt.økAntallOppgaver("Student1", 3);
        oversikt.økAntallOppgaver("Student2", 5);

        System.out.println("Antall registrerte studenter: " + oversikt.finnAntallStudenter());
        System.out.println("Antall oppgaver for Student1: " + oversikt.finnAntallOppgaver("Student1"));
        System.out.println("Antall oppgaver for Student2: " + oversikt.finnAntallOppgaver("Student2"));

        System.out.println(oversikt);
    }
}