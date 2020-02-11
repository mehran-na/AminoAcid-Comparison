import java.util.ArrayList;
import java.util.Arrays;

public class Calcule {
    //fields :
    private String acidesA;
    private String acidesB;

    private ArrayList<String> s;
    private ArrayList<String> t;
    private ArrayList<PairsAcides> pairsAcides = new ArrayList<>();

    public Calcule(String acidesA, String acidesB) {
        this.acidesA = acidesA;
        this.acidesB = acidesB;
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
}
