/**
 * Classe ApplicationPrincipale
 *
 * @author : Mehran Nazemi
 * @version : Février 2020
 * @Professeur : M.Bruno Malenfant
 * @email : nazemi.mehran@courrier.uqam.ca
 * @code permanent  : NAZM30088507
 */

public class ApplicationPrincipale {
    public static void main(String[] args) {

        //Lire le fichier AcideAmine.txt :
        try {
            Inventaire.lire();
        } catch(Exception e) {
            System.err.println(Consts.MSG_ERROR_FICHIER_NON_TROUVER);
            System.exit(-1);
        }

        // Méthode d'affichage du message de bienvenue
        Console.msgBienvenue();

        // Méthode d'affichage du résumé de ce que programme fait
        Console.msgResume();

        //Demande des informations à l'utilisateur:
        String a = Console.lireARN("Entrer premier ARN S.V P : ");
        String b = Console.lireARN("Entrer deuxièm ARN S.V P : ");
        int c = Console.lireDistanceMax("Entrer distance maximal S.V P : ");

        //Diviser en codon : pour mettre space entre codon
        a = a.replaceAll("...", "$0 ");
        b = b.replaceAll("...", "$0 ");

        //Pour chaque codon, trouver l'acide amine qu'il represente:
        String acidesA = Inventaire.trouverAcide(a);
        String acidesB = Inventaire.trouverAcide(b);

        //Créer object calcule:
        Calcule calcule = new Calcule(acidesA, acidesB, c);

        //Ajouter les acide amine qui sont dèja trouver dans ArrayList (s,t)
        calcule.AjouterDansArrayList();

        //trouver les pairs d'acides identiques entre s et t
        calcule.trouverPairs();

        //Pour chaque acide de s et t, elle va trouver la deviation minimal:
        calcule.creerDeviationMin();

        //faire la somme:
        calcule.calculerDeviationTotal();

        //Ponderer:
        calcule.ponderer();

        //Résultat final:
        calcule.calculFinal();

        //afficher résultat final à la console:
        Console.afficher(calcule.getK());

        //afficher message fin d programme:
        Console.msgFin();

        //GCCAAUUCCACGUCGUAU
        //AAUUCGGCGACAGCCUGGUCCUAC
    }
}
