public class PairsAcides {
    int indexUn;
    int indexDeux;

    public PairsAcides(int indexUn, int indexDeux) {
        this.indexUn = indexUn;
        this.indexDeux = indexDeux;
    }

    public int deviation(){
        return Math.abs(indexUn - indexDeux);
    }
}
