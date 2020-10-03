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
}


