public class Test {
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