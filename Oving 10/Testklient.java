import java.util.ArrayList;
import java.util.List;

class Rett {
    String navn;
    String type;
    int pris;
    String oppskrift;

    public Rett(String navn, String type, int pris, String oppskrift) {
        this.navn = navn;
        this.type = type;
        this.pris = pris;
        this.oppskrift = oppskrift;
    }
}

class Meny {
    String navn;
    List<Rett> retter;
    int totalpris;

    public Meny(String navn, List<Rett> retter) {
        this.navn = navn;
        this.retter = retter;
        this.totalpris = retter.stream().mapToInt(rett -> rett.pris).sum();
    }
}

class MenyRegister {
    List<Rett> retter;
    List<Meny> menyer;

    public MenyRegister() {
        this.retter = new ArrayList<>();
        this.menyer = new ArrayList<>();
    }

    public void registrerRett(Rett rett) {
        retter.add(rett);
    }

    public Rett finnRett(String navn) {
        for (Rett rett : retter) {
            if (rett.navn.equals(navn)) {
                return rett;
            }
        }
        return null;
    }

    public List<Rett> finnRetterAvType(String type) {
        List<Rett> resultater = new ArrayList<>();
        for (Rett rett : retter) {
            if (rett.type.equals(type)) {
                resultater.add(rett);
            }
        }
        return resultater;
    }

    public void registrerMeny(Meny meny) {
        menyer.add(meny);
    }

    public List<Meny> finnMenyerInnenforPrisintervall(int lavestePris, int hoyestePris) {
        List<Meny> resultater = new ArrayList<>();
        for (Meny meny : menyer) {
            if (lavestePris <= meny.totalpris && meny.totalpris <= hoyestePris) {
                resultater.add(meny);
            }
        }
        return resultater;
    }
}

public class Testklient {
    public static void main(String[] args) {
        MenyRegister menyRegister = new MenyRegister();

        // Registrer retter
        Rett rett1 = new Rett("Salat", "Forrett", 50, "Blandet salat med dressing.");
        Rett rett2 = new Rett("Biff", "Hovedrett", 150, "Stekt biff med poteter og grønnsaker.");
        Rett rett3 = new Rett("Sjokoladefondant", "Dessert", 80, "Sjokoladekake med flytende sjokoladekjerne.");

        menyRegister.registrerRett(rett1);
        menyRegister.registrerRett(rett2);
        menyRegister.registrerRett(rett3);

        // Registrer menyer
        Meny meny1 = new Meny("Dagens meny", List.of(rett1, rett2, rett3));
        Meny meny2 = new Meny("Vegetarmeny", List.of(rett1, rett2));
        Meny meny3 = new Meny("Luksusmeny", List.of(rett2, rett3));

        menyRegister.registrerMeny(meny1);
        menyRegister.registrerMeny(meny2);
        menyRegister.registrerMeny(meny3);

        // Test operasjoner
        System.out.println("Finn rett etter navn:");
        System.out.println(menyRegister.finnRett("Biff").navn);

        System.out.println("\nFinn retter av en gitt type:");
        for (Rett rett : menyRegister.finnRetterAvType("Forrett")) {
            System.out.println(rett.navn);
        }

        System.out.println("\nFinn menyer innenfor prisintervall:");
        for (Meny meny : menyRegister.finnMenyerInnenforPrisintervall(100, 200)) {
            System.out.println(meny.navn + " - " + meny.totalpris + " kr");
        }
    }
}