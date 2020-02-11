import java.util.Scanner;

/**
 * Classe ApplicationPrincipale
 *
 * @author : Mehran Nazemi
 * @version : Février 2020
 * @Professeur : M.
 * @email : nazemi.mehran@courrier.uqam.ca
 * @code permanent  : NAZM30088507
 */

public class ApplicationPrincipale {
    public static void main(String[] args) {
        try {
            Inventaire.lire();
        } catch(Exception e) {
            System.out.println("Fichier non trouvé!");
        }

        // Méthode d'affichage du message de bienvenue
        Console.msgBienvenue();

        // Méthode d'affichage du résumé de ce que votre programme fait
        Console.msgResume();

        String a = Console.lirARN("Entrer premier ARN S.V P : ");

        String b = Console.lirARN("Entrer deuxièm ARN S.V P : ");

        int c = Console.lireDistanceMax("Entrer distance maximal S.V P : ");

        a = a.replaceAll("...", "$0 ");
        b = b.replaceAll("...", "$0 ");

        String acidesA = Inventaire.trouverAcide(a);
        String acidesB = Inventaire.trouverAcide(b);

        Calcule calcule = new Calcule(acidesA, acidesB);
        calcule.AjouterDansArrayList();

        //GCCAAUUCCACGUCGUAU
        //AAUUCGGCGACAGCCUGGUCCUAC



    }
}
