import java.util.Random;

class Spiller {
    private int sumPoeng;
    private Random terning;

    public Spiller() {
        sumPoeng = 0;
        terning = new Random();
    }

    public int getSumPoeng() {
        return sumPoeng;
    }

    public void KastTerningen() {
        int terningkast = terning.nextInt(6)+1; 
        if (terningkast == 1) {
            sumPoeng = 0;
        } else {
            sumPoeng += terningkast;
        }
    }

    public boolean erFerdig() {
        return sumPoeng >= 100;
    }

}


public class Øving42 {
    public static void main(String[] args) {
        Spiller spillerA = new Spiller();
        Spiller spillerB = new Spiller();
        int runde = 1;

        while (true) {
            System.out.println("Runde " + runde);
            System.out.println("Spiller A: " + spillerA.getSumPoeng() + " poeng");
            System.out.println("Spiller B: " + spillerB.getSumPoeng() + " poeng");
            
            spillerA.KastTerningen();
            spillerB.KastTerningen();

            if (spillerA.erFerdig() || spillerB.erFerdig()) {
                break;
            }
            
            runde++;    
    }
    
    System.out.println("Spillet er ferdig!");
}
}