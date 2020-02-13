import java.util.ArrayList;
import java.util.Arrays;

public class Calcule {
    //fields :
    private String acidesA;
    private String acidesB;
    private int distanceMax;
    private int deviationTotal;
    private double pond;
    private double k;

    private ArrayList<String> s;
    private ArrayList<String> t;
    private ArrayList<PairsAcides> pairsAcides = new ArrayList<>();
    private ArrayList<Integer> deviations = new ArrayList<>();
    private ArrayList<Integer> sChiffre = new ArrayList<>();
    private ArrayList<Integer> tChiffre = new ArrayList<>();

    //Constructors
    public Calcule(String acidesA, String acidesB, int distanceMax) {
        this.acidesA = acidesA;
        this.acidesB = acidesB;
        this.distanceMax = distanceMax;
    }
    public Calcule() { }

    //Getter:
    public double getK() {
        return k;
    }

    //Méthods
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
            trouveDeviation(i, 's');
        }
        for(int i = 0; i < t.size(); i++) {
            trouveDeviation(i, 't');
        }
    }

    private void trouveDeviation(int inx, char acides) {
        switch (acides) {
            case 's':
                for(int i = 0; i < pairsAcides.size(); i++) {
                    if (pairsAcides.get(i).indexUn == inx) {
                        deviations.add(pairsAcides.get(i).deviation());
                    }else{
                        deviations.add(this.distanceMax);
                    }
                }
                Dmin(acides);
                break;
            case 't':
                for(int i = 0; i < pairsAcides.size(); i++) {
                    if (pairsAcides.get(i).indexDeux == inx) {
                        deviations.add(pairsAcides.get(i).deviation());
                    }else{
                        deviations.add(this.distanceMax);
                    }
                }
                Dmin(acides);
                break;
        }
    }

    private void Dmin(char acides) {
        int minDeviation = distanceMax;
        for(int deviation : deviations) {
            if (deviation < minDeviation) {
                minDeviation = deviation;
            }
        }
        if (acides == 's') {
            sChiffre.add(minDeviation);
        }else{
            tChiffre.add(minDeviation);
        }
        deviations.clear();
    }

    public void calculerDeviationTotal() {
        for(int deviation : sChiffre) {
            this.deviationTotal += deviation;
        }
        for(int deviation : tChiffre) {
            this.deviationTotal += deviation;
        }
    }

    public void ponderer() {
        int m = sChiffre.size();
        int n = tChiffre.size();
        this.pond = (double) this.deviationTotal / ((n + m) * this.distanceMax);
    }

    public void calculFinal() {
        this.k = Math.exp(-6 * Math.pow(this.pond, 2));
    }
}
