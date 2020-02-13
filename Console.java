import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

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

    public static String lirARN(String prompt) {
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

    public static int lireDistanceMax(String prompt) {
        System.out.print(prompt);
        int distanceMax = scanner.nextInt();
        if (distanceMax <= 0) {
            System.err.println(Consts.MSG_ERROR_DISTANCE_MAX);
            System.exit(-1);
        }
        return distanceMax;
    }

    public static void afficher(double k) {
        System.out.println("\n Similarite : " + k);
    }
}