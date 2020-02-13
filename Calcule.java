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

    public Calcule() {
    }

    //Getter:
    public double getK() {
        return k;
    }

    //Méthods

    /**
     * @description Méthod AjouterDansArrayList, pour ajouter 2 strings (acidesA , acidesB) dans
     * 2 ArrayList (s et t)
     */
    public void AjouterDansArrayList() {
        String[] arrAcidesA = acidesA.split("\\s");
        String[] arrAcidesB = acidesB.split("\\s");

        this.s = new ArrayList<>(Arrays.asList(arrAcidesA));
        this.t = new ArrayList<>(Arrays.asList(arrAcidesB));

    }

    /**
     * @description Méthod trouverPairs, pour trouver les pairs d'acides identiques entre s et t
     * et pour chaque paire il y a un object, et ces objets vont ajouter dans ArrayList (pairesAcides)
     */
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

    /**
     * @description Méthod creerDeviationMin, pour boucler sur ArrayLists s et t, pour chaque élément elle appelle
     * l'autre méthod et elle va envoyer un argument (i: index de cet élément)
     */
    public void creerDeviationMin() {
        for(int i = 0; i < s.size(); i++) {
            trouveDeviationS(i);
        }
        for(int i = 0; i < t.size(); i++) {
            trouveDeviationT(i);
        }
    }

    /**
     * @description Méthod trouveDeviationS, pour chaque acide dans s, trouver les acides dant t qui sont
     * correspond de ce acide, si elle trouve elle va calculer les déviations entre chaque pair d'acide identique
     * avec appelle la méthod deviation.et à la fin elle appelle la méthod Dmin pour trouver la deviation minimal
     *
     * @param inx   index de chaque élément dans s
     */
    private void trouveDeviationS(int inx) {
        for(int i = 0; i < pairsAcides.size(); i++) {
            if (pairsAcides.get(i).indexUn == inx) {
                deviations.add(pairsAcides.get(i).deviation());
            }else{
                deviations.add(this.distanceMax);
            }
        }
        Dmin('s');
    }

    /**
     * @description Méthod trouveDeviationT, pour chaque acide dans t, trouver les acides dant s qui sont
     * correspond de ce acide, si elle trouve elle va calculer les déviations entre chaque pair d'acide identique
     * avec appelle la méthod deviation.et à la fin elle appelle la méthod Dmin pour trouver la deviation minimal
     *
     * @param inx
     */
    private void trouveDeviationT(int inx) {
        for(int i = 0; i < pairsAcides.size(); i++) {
            if (pairsAcides.get(i).indexDeux == inx) {
                deviations.add(pairsAcides.get(i).deviation());
            }else{
                deviations.add(this.distanceMax);
            }
        }
        Dmin('t');
    }

    /**
     * @description Méthod Dmin, pour trouver la deviation minimal
     *
     * @param acides    pour savoir c'est quel ArrayList (s ou t)
     */
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


    /**
     * @description Méthod calculerDeviationTotal, pour calculer la deviation total
     *
     */
    public void calculerDeviationTotal() {
        for(int deviation : sChiffre) {
            this.deviationTotal += deviation;
        }
        for(int deviation : tChiffre) {
            this.deviationTotal += deviation;
        }
    }

    /**
     * @description Méthod ponderer, pour calculer la métrique
     *
     */
    public void ponderer() {
        int m = sChiffre.size();
        int n = tChiffre.size();
        this.pond = (double) this.deviationTotal / ((n + m) * this.distanceMax);
    }

    /**
     * @description Méthod calculFinal, pour calculer la résultat final
     *
     */
    public void calculFinal() {
        this.k = Math.exp(-6 * Math.pow(this.pond, 2));
    }
}
