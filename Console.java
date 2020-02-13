import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * @description Méthod msgBienvenue, pour afficher le message de bienvenue
     *
     */
    public static void msgBienvenue() {
        System.out.println(Consts.MSG_BIENVENUE);
    }

    /**
     * @description Méthod msgResume, pour afficher le message de résumé de programme
     *
     */
    public static void msgResume() {
        System.out.println(Consts.MSG_RESUME);
    }

    /**
     * @description Méthod lireARN, pour demander ARN à l'utilisateur
     *
     * @param prompt    message pour demander ARN à l'utilisateur
     * @return arn      ARN validé
     *
     */
    public static String lireARN(String prompt) {
        System.out.print(prompt);
        String arn = scanner.nextLine();
        if (arn.length() % 3 == 0) {
            for(int i = 0; i < arn.length(); i++) {
                char letter = arn.charAt(i);
                if (letter != 'A' && letter != 'C' && letter != 'G' && letter != 'U') {
                    System.err.println(Consts.MSG_ERROR_ARN_LETTRE);
                    System.exit(-1);
                }
            }
        }else{
            System.err.println(Consts.MSG_ERROR_ARN_LENGTH);
            System.exit(-1);
        }
        return arn;
    }

    /**
     * @description Méthod lireDistanceMax, pour demander la distance maximal à l'utilisateur
     *
     * @param prompt    message pour demander distance maximal à l'utilisateur
     * @return distanceMax      un chiffre valid
     *
     */
    public static int lireDistanceMax(String prompt) {
        System.out.print(prompt);
        int distanceMax = scanner.nextInt();
        if (distanceMax <= 0) {
            System.err.println(Consts.MSG_ERROR_DISTANCE_MAX);
            System.exit(-1);
        }
        return distanceMax;
    }

    /**
     * @description Méthod afficher, pour afficher la résultat final
     *
     * @param k    similarité
     *
     */
    public static void afficher(double k) {
        System.out.println("\n Similarite : " + k);
    }

    /**
     * @description Méthod msgFin, pour afficher le message de fin de programme
     *
     */
    public static void msgFin() {
        System.out.println(Consts.MSG_FIN);
    }
}