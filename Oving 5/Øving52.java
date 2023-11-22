import java.util.Random;

public class Øving52 {
    private Random random;

    public Øving52() {
        random = new Random();
    }

    public int nesteHeltall(int nedre, int ovre) {
        
        return random.nextInt(ovre - nedre + 1) + nedre;
    }

    public double nesteDesimaltall(double nedre, double ovre) {
        
        return random.nextDouble() * (ovre - nedre) + nedre;
    }

    public static void main(String[] args) {
        Øving52 minRandom = new Øving52();

       
        int tilfeldigHeltall = minRandom.nesteHeltall(1, 10);
        double tilfeldigDesimaltall = minRandom.nesteDesimaltall(0.0, 1.0);

        System.out.println("Tilfeldig heltall: " + tilfeldigHeltall);
        System.out.println("Tilfeldig desimaltall: " + tilfeldigDesimaltall);
    }
}