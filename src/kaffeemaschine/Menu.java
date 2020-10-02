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

    public final static String ZEILE_1 = "****** Kaffeemaschine ******";
    public final static String ZEILE_2 = "============================";
    public final static String ZEILE_3 = "Auswahl:____________________";
    public final static String ZEILE_4 = "1.) Kaffee schwarz__________";
    public final static String ZEILE_5 = "2.) Kaffee mit Zucker_______";
    public final static String ZEILE_6 = "3.) Kaffee mit Milch________";
    public final static String ZEILE_7 = "4.) Kaffee mit Milch/Zucker_";
    public final static String ZEILE_8 = "5.) Kakao___________________";
    public final static String ZEILE_9 = "9.) _________________Wartung";
    public final static String ZEILE_10 = "0.) _________________Abbruch";

    final static String AUSWAHL = ZEILE_1 + "\n" + ZEILE_2 + "\n" + ZEILE_3 + "\n" + ZEILE_4 + "\n" +
        ZEILE_5 + "\n" + ZEILE_6 + "\n" + ZEILE_7 + "\n" + ZEILE_8 + "\n" + ZEILE_9 + "\n" + ZEILE_10;

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


