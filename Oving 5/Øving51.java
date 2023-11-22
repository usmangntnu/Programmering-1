class Brøk {
    private int teller; 
    private int nevner; 

    public Brøk(int teller, int nevner) {
        if (nevner == 0) {
            throw new IllegalArgumentException("Nevner kan ikke være 0");
        }
        this.teller = teller;
        this.nevner = nevner;
    } 

    public Brøk(int teller) {
        this(teller, 1);
    }
    
    public int getTeller() {
    return teller;
    }

    public int getNevner() {
        return nevner;
    }

    public void summer(Brøk annenBrøk) {
        this.teller = this.teller * annenBrøk.getNevner() + annenBrøk.getTeller() * this.nevner;
        this.nevner = this.nevner * annenBrøk.getNevner();
    }
    
    public void subtraher(Brøk annenBrøk) {
        this.teller = this.teller * annenBrøk.getNevner() - annenBrøk.getTeller() * this.nevner;
        this.nevner = this.nevner * annenBrøk.getNevner();
    }

    public void multipliser(Brøk annenBrøk) {
        this.teller = this.teller * annenBrøk.getTeller();
        this.nevner = this.nevner * annenBrøk.getNevner();
    }

    public void divider(Brøk annenBrøk) {
        if (annenBrøk.getTeller() == 0) {
            throw new IllegalArgumentException("Kan ikke dele med 0");
        }
        this.teller = this.teller * annenBrøk.getNevner();
        this.nevner = this.nevner * annenBrøk.getTeller();
    }

} 

public class Øving51 {
    public static void main(String[] args) {
        Brøk brøk1 = new Brøk(1, 2);
        Brøk brøk2 = new Brøk(1, 3);

        brøk1.summer(brøk2);
        System.out.println("Sum: " + brøk1.getTeller() + "/" + brøk1.getNevner());

        brøk1.subtraher(brøk2);
        System.out.println("Differanse: " + brøk1.getTeller() + "/" + brøk1.getNevner());

        brøk1.multipliser(brøk2);
        System.out.println("Produkt: " + brøk1.getTeller() + "/" + brøk1.getNevner());

        brøk1.divider(brøk2);
        System.out.println("Kvotient: " + brøk1.getTeller() + "/" + brøk1.getNevner());
    }
}
