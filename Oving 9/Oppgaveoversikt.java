public class Oppgaveoversikt {
    private Student[] studenter;
    private int antStud;

    public Oppgaveoversikt(int maksAntStudenter) {
        studenter = new Student[maksAntStudenter];
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
            studenter[antStud] = new Student(navn);
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

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < antStud; i++) {
            result.append(studenter[i].toString()).append("\n");
        }
        return result.toString();
    }
} 
