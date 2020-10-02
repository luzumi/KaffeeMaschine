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

    final static String ZEILE_1 = "****** Kaffeemaschine ******";
    final static String ZEILE_2 = "============================";
    final static String ZEILE_3 = "Auswahl:____________________";
    final static String ZEILE_4 = "1.) Kaffee schwarz__________";
    final static String ZEILE_5 = "2.) Kaffee mit Zucker_______";
    final static String ZEILE_6 = "3.) Kaffee mit Milch________";
    final static String ZEILE_7 = "4.) Kaffee mit Milch/Zucker_";
    final static String ZEILE_8 = "5.) Kakao___________________";
    final static String ZEILE_9 = "9.) _________________Wartung";
    final static String ZEILE_10 = "0.) _________________Abbruch";

    public Menu() {
    }



    public static void menu() {
        System.out.printf("\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                Menu.ZEILE_1, Menu.ZEILE_2, Menu.ZEILE_3, Menu.ZEILE_4, Menu.ZEILE_5, Menu.ZEILE_6, Menu.ZEILE_7, Menu.ZEILE_8, Menu.ZEILE_9, Menu.ZEILE_10);

    }

    /**
     * @return Auswahl des vom User gewählten Programms
     */


    static int programmAuswahl() {
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }
}


