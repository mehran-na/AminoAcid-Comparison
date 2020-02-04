/**
 * Classe ApplicationPrincipale
 *
 * @author          : Mehran Nazemi
 * @version         : Février 2020
 * @Professeur      : M.
 * @email           : nazemi.mehran@courrier.uqam.ca
 * @code permanent  : NAZM30088507
 */

public class ApplicationPrincipale {
    /**
     * Méthod msgBienvenue
     *
     * @description afficher le message de bienvenue
     */
    public static void msgBienvenue() {
        System.out.println(Consts.MSG_BIENVENUE);
    }

    /**
     * Méthod msgResume
     *
     * @description afficher le message de résumé de programme
     */
    public static void msgResume() {
        System.out.println(Consts.MSG_RESUME);
    }

    /**
     * Méthod msgFin
     *
     * @description afficher le message de fin de programme
     */
    public static void msgFin() {
        System.out.println(Consts.MSG_FIN);
    }

    public static void main(String[] args) {
        // Déclaration des variables locales

        // Initialisation des variables

        /* **************************************************
         *                Début du programme
         **************************************************/
        // Méthode d'affichage du message de bienvenue
        msgBienvenue();
        // Méthode d'affichage du résumé de ce que votre programme fait
        msgResume();

    }
}
