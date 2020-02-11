public class PairsAcides implements Comparable<PairsAcides> {
    int indexUn;
    int indexDeux;

    public PairsAcides(int indexUn, int indexDeux) {
        this.indexUn = indexUn;
        this.indexDeux = indexDeux;
    }

    @Override
    public int compareTo(PairsAcides specifiquePairAcide) {
        return this.indexUn - specifiquePairAcide.indexUn;
    }

    public int deviation(){
        return Math.abs(indexUn - indexDeux);
    }


}
