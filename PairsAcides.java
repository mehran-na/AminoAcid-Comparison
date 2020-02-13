public class PairsAcides {
    int indexUn;
    int indexDeux;

    //Constructor:
    public PairsAcides(int indexUn, int indexDeux) {
        this.indexUn = indexUn;
        this.indexDeux = indexDeux;
    }

    public PairsAcides() {
    }

    /**
     * @description Méthod deviation, pour calculer les déviation chaque pair d'acide identique
     *
     */
    public int deviation(){
        return Math.abs(indexUn - indexDeux);
    }
}