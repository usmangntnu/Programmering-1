import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrangementRegister {
    private List<Arrangement> arrangementer;

    public ArrangementRegister() {
        this.arrangementer = new ArrayList<>();
    }

    public void leggTilArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }

    public List<Arrangement> finnArrangementerPaaSted(String sted) {
        List<Arrangement> resultater = new ArrayList<>();
        for (Arrangement arrangement : arrangementer) {
            if (arrangement.getSted().equalsIgnoreCase(sted)) {
                resultater.add(arrangement);
            }
        }
        return resultater;
    }

    public List<Arrangement> finnArrangementerPaaDato(int dato) {
        List<Arrangement> resultater = new ArrayList<>();
        for (Arrangement arrangement : arrangementer) {
            int arrangementDato = arrangement.getTidspunkt() / 1000000; // Henter dato fra heltallet
            if (arrangementDato == dato) {
                resultater.add(arrangement);
            }
        }
        return resultater;
    }

    public List<Arrangement> finnArrangementerITidsintervall(int startDato, int sluttDato) {
        List<Arrangement> resultater = new ArrayList<>();
        for (Arrangement arrangement : arrangementer) {
            int arrangementDato = arrangement.getTidspunkt() / 1000000; // Henter dato fra heltallet
            if (arrangementDato >= startDato && arrangementDato <= sluttDato) {
                resultater.add(arrangement);
            }
        }
        resultater.sort(Comparator.comparingInt(Arrangement::getTidspunkt));
        return resultater;
    }

    public List<Arrangement> listeOverArrangementerSortert(Comparator<Arrangement> sorteringsnokkel) {
        List<Arrangement> resultater = new ArrayList<>(arrangementer);
        resultater.sort(sorteringsnokkel);
        return resultater;
    }
}