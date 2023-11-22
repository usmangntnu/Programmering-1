/*Øving 2 - Oppgave 1 */
import java.util.Scanner;

public class Øving21 {

    public static void main(String[] args) {
    
    Scanner Scan = new Scanner(System.in);
    System.out.print("Sett inn aar: ");
	int år = Scan.nextInt();
    
    boolean er_skuddår;
    
    //delelig på 4
    er_skuddår = (år % 4 == 0);
    
    //delelig på 4, ikke på 100, eller delelig på 400
    er_skuddår = er_skuddår && (år %  100 != 0 || år % 400 == 0);

    if (er_skuddår) {
        System.out.print(år + " er skuddaar.");
    }else{
        System.out.print(år + " er ikke skuddaar");
        
        }
    }
 }
