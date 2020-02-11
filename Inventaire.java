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
    //private static String NOM_FICHIER = Consts.NOM_FICHIER;
    public static ArrayList<AcideAmine> acides = new ArrayList<AcideAmine>();

    /**
     * Lire les informations des Acide amines à partir du fichier AcideAmine.txt
     * et les mettre dans l'attribut acides.
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
}
