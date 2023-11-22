/*Øving 1- Oppgave 2 */
import java.util.Scanner;

public class Øving12 {
    public static void main(String[] Strings) {
     
        int timer, minutter, sekunder, total_sekunder;

        Scanner Scan = new Scanner(System.in);

        System.out.print("Hvor mange timer?: ");
        timer = Scan.nextInt();
        System.out.print("Hvor mange minutter?: ");
        minutter = Scan.nextInt();
        System.out.print("Hvor mange sekunder?: ");
        sekunder = Scan.nextInt();

        int timer_til_sekunder = 3600;
        int minutter_til_sekunder = 60;

        total_sekunder = timer * timer_til_sekunder + minutter * minutter_til_sekunder + sekunder;

        System.out.println("Total sekunder: " + total_sekunder);
    }
}  

