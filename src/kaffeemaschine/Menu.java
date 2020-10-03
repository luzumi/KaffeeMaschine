/*corat
 *28.09.2020
 *13:33
 *KaffeeMaschine
 */

package kaffeemaschine;

import java.util.Scanner;

/**
 * @author corat
 */
public class Menu implements IMenu{



    final static String AUSWAHL = Constants.ZEILE_1 + "\n" + Constants.ZEILE_2 + "\n" + Constants.ZEILE_3 + "\n" + Constants.ZEILE_4 + "\n" +
            Constants.ZEILE_5 + "\n" + Constants.ZEILE_6 + "\n" + Constants.ZEILE_7 + "\n" + Constants.ZEILE_8 + "\n" + Constants.ZEILE_9 + "\n" + Constants.ZEILE_10;

    public Menu() {
    }


    public static String menu() {
        return AUSWAHL;
    }

    /**
     * @return Auswahl des vom User gewählten Programms
     */


    public static int programmAuswahl() {
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }

    public static int programmAuswahl(String promptMsg, String errorMsg) {

        int num = 0;
        boolean isValid = false;

        while(!isValid) {
            System.out.println(promptMsg);
            String strInput = new Scanner(System.in).nextLine();

            try {
                num = Integer.parseInt(strInput);

                isValid = true;
            } catch (NumberFormatException var7) {
                System.out.println(errorMsg);
            }
        }

        return num;
    }
}


