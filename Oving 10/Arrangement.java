import java.util.Date;

public class Arrangement {
    private int nummer;
    private String navn;
    private String sted;
    private String arrangor;
    private String type;
    private int tidspunkt; // Lagres som heltall, f.eks. 200210301800

    public Arrangement(int nummer, String navn, String sted, String arrangor, String type, int tidspunkt) {
        this.nummer = nummer;
        this.navn = navn;
        this.sted = sted;
        this.arrangor = arrangor;
        this.type = type;
        this.tidspunkt = tidspunkt;
    }

    // Getters and setters
    public int getNummer() {
        return nummer;
    }

    public String getNavn() {
        return navn;
    }

    public String getSted() {
        return sted;
    }

    public String getArrangor() {
        return arrangor;
    }

    public String getType() {
        return type;
    }

    public int getTidspunkt() {
        return tidspunkt;
    }
}