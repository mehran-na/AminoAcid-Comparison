import java.util.ArrayList;
import java.util.Arrays;

public class Calcule {
    //fields :
    private String acidesA;
    private String acidesB;
    private int distanceMax;

    private ArrayList<String> s;
    private ArrayList<String> t;
    private ArrayList<PairsAcides> pairsAcides = new ArrayList<>();
    private ArrayList<Integer> sChiffre = new ArrayList<>();

    public Calcule(String acidesA, String acidesB, int distanceMax) {
        this.acidesA = acidesA;
        this.acidesB = acidesB;
        this.distanceMax = distanceMax;
    }

    public void AjouterDansArrayList() {
        String[] arrAcidesA = acidesA.split("\\s");
        String[] arrAcidesB = acidesB.split("\\s");

        this.s = new ArrayList<>(Arrays.asList(arrAcidesA));
        this.t = new ArrayList<>(Arrays.asList(arrAcidesB));

    }

    public void trouverPairs() {
        for(int i = 0; i < s.size(); i++) {
            for(int j = 0; j < t.size(); j++) {
                if (s.get(i).equals(t.get(j))) {
                    PairsAcides pairAcide = new PairsAcides(i, j);
                    pairsAcides.add(pairAcide);
                }
            }
        }
    }

    public void creerDeviationMin() {
        for(int i = 0; i < s.size(); i++) {
            Dmin(i);
        }
    }

    public void Dmin(int inx) {
        ArrayList<Integer> deviations = new ArrayList<>();
        for(int i = 0; i < pairsAcides.size(); i++) {
            if (pairsAcides.get(i).indexUn == inx) {
                deviations.add(pairsAcides.get(i).deviation());
            }else{
                deviations.add(this.distanceMax);
            }
        }
        int minDeviation = deviations.get(0);
        for(int deviation : deviations) {
            if (deviation < minDeviation) {
                minDeviation = deviation;
            }
        }
        sChiffre.add(minDeviation);
    }

    public void afficher() {
        for(int i = 0; i < sChiffre.size(); i++) {
            System.out.println(sChiffre.get(i));
        }

    }
}
