public class AcideAmine {
    //**********************Attributs**********************
    private String abreviation;
    private String codon;
    private String nom;

    //**********************Constructor**********************

    public AcideAmine(String abreviation, String codon, String nom) {
        this.abreviation = abreviation;
        this.codon = codon;
        this.nom = nom;
    }

    public AcideAmine() {
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getCodon() {
        return codon;
    }

    public void setCodon(String codon) {
        this.codon = codon;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
