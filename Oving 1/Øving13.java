/*Øving 1- Oppgave 3 */
import java.util.Scanner;
public class Øving13 {

public static void main(String[] args) {

        Scanner Scan = new Scanner(System.in);

        System.out.print("Sett inn sekunder: ");
	    int sekunder = Scan.nextInt();
        int sek = sekunder % 60;
        int timer = sekunder / 60;
        int minutter = timer % 60;
        timer = timer / 60;
        System.out.print( timer + " timer " + minutter + " minutter " + sek + " sekunder");
    }
}

