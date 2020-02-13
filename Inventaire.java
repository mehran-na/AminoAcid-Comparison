import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Inventaire contient toutes les informations sur les Acide Aminés.
 * - ArrayList contenant les  Acide Aminés.
 *
 * @author Mehran Nazemi
 * @version février 2020
 */
public class Inventaire {

    private static ArrayList<AcideAmine> acides = new ArrayList<AcideAmine>();

    /**
     * @description  Lire les informations des Acide amines à partir du fichier AcideAmine.txt
     * et créer object AcideAmine et les mettre dans l'attribut acides qui est un ArrayList.
     *
     */
    public static void lire() throws Exception {
        File file = new File(Consts.NOM_FICHIER);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String ligne = sc.nextLine();
            String[] parts = ligne.split("\\|");
            String abreviation = parts[0];
            String codon = parts[1];
            String nom = parts[2];
            //créer acide amine object et ajouter dans acides ArrayList:
            acides.add(new AcideAmine(abreviation, codon, nom));
        }
    }

    /**
     * @description Méthod trouverAcide, pour prendre la demande d'utilisateur et chercher dans ArrayList de ARNs
     *
     * @param demandUtilisateur    l'entrée d'utilisateur
     * @return resultat      c'est Abréviations correspondence des codon demandés
     *
     */
    public static String trouverAcide(String demandUtilisateur){
        String resultat = "";
        String [] arrDemandUtilisateur = demandUtilisateur.split("\\s");
        for (int i = 0; i < arrDemandUtilisateur.length; i++){
            for(AcideAmine acide : acides){
                if(acide.getCodon().contains(arrDemandUtilisateur[i])){
                    resultat += acide.getAbreviation() + " ";
                }
            }
        }
        return resultat;
    }
}
