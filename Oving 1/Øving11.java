
/* Øving 1- Oppgave 1 */
import java.util.Scanner;
public class Øving11 {

    public static void main(String[] Strings) {

        Scanner Scan = new Scanner(System.in);

        System.out.print("Sett enn verdi for tommer: ");
        double tommer = Scan.nextDouble();
        double cm = tommer * 2.54;
        System.out.println(tommer + " tommer er " + cm + " cm");

    }
}