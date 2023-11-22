/*Øving 2- Oppgave 2 */
import java.util.Scanner;
public class Øving22 {

    public static void main(String[] args) {
    
    Scanner Scan = new Scanner(System.in);


    System.out.print("Sett in pris paa merke A: ");
	float pris_a = Scan.nextInt();
    System.out.print("Sett in vekt paa merke A: ");
    int vekt_a = Scan.nextInt();
    System.out.print("Sett in pris paa merke B: ");
	float pris_b = Scan.nextInt();
    System.out.print("Sett in vekt paa merke B: ");
    int vekt_b = Scan.nextInt();


    if ((pris_a / vekt_a)>(pris_b / vekt_b)) {
        System.out.print("Merke B er billigst.");
        
    } else {
        System.out.print("Merke A er billigst.");
        
        }
    }
}
