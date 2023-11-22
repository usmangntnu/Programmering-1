public class Øving5 {
    private int teller;
    private int nevner;

    public Brok(int teller, int nevner) {
        if (nevner == 0) {
            throw new IllegalArgumentException("Nevneren kan ikke være 0.");
        }
        this.teller = teller;
        this.nevner = nevner;
    }

    public Brok(int teller) {
        this(teller, 1);
    }

    public int getTeller() {
        return teller;
    }

    public int getNevner() {
        return nevner;
    }

    public void summer(Brok annenBrok) {
        this.teller = this.teller * annenBrok.getNevner() + annenBrok.getTeller() * this.nevner;
        this.nevner = this.nevner * annenBrok.getNevner();
    }

    public void subtraher(Brok annenBrok) {
        this.teller = this.teller * annenBrok.getNevner() - annenBrok.getTeller() * this.nevner;
        this.nevner = this.nevner * annenBrok.getNevner();
    }

    public void multipliser(Brok annenBrok) {
        this.teller = this.teller * annenBrok.getTeller();
        this.nevner = this.nevner * annenBrok.getNevner();
    }

    public void divider(Brok annenBrok) {
        if (annenBrok.getTeller() == 0) {
            throw new IllegalArgumentException("Kan ikke dele med 0.");
        }
        this.teller = this.teller * annenBrok.getNevner();
        this.nevner = this.nevner * annenBrok.getTeller();
    }

    public String toString() {
        return teller + "/" + nevner;
    }

    public static void main(String[] args) {
        Brok brok1 = new Brok(1, 2);
        Brok brok2 = new Brok(1, 3);

        System.out.println("Brok 1: " + brok1);
        System.out.println("Brok 2: " + brok2);

        brok1.summer(brok2);
        System.out.println("Sum: " + brok1);

        brok1.subtraher(brok2);
        System.out.println("Differanse: " + brok1);

        brok1.multipliser(brok2);
        System.out.println("Produkt: " + brok1);

        brok1.divider(brok2);
        System.out.println("Kvotient: " + brok1);
    }
}




