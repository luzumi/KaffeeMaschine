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
public class Menu implements IAuswahl{
    Scanner sc = new Scanner(System.in);
    String zeile1 = "****** Kaffeemaschine ******";
    String zeile2 = "============================";
    String zeile3 = "Auswahl:____________________";
    String zeile4 = "1.) Kaffee schwarz__________";
    String zeile5 = "2.) Kaffee mit Zucker_______";
    String zeile6 = "3.) Kaffee mit Milch________";
    String zeile7 = "4.) Kaffee mit Milch/Zucker_";
    String zeile8 = "5.) Kakao___________________";
    String zeile9 = "9.) _________________Wartung";
    String zeile10 = "0.) _________________Abbruch";

    public Menu() {
        System.out.printf("\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                zeile1, zeile2, zeile3, zeile4, zeile5, zeile6, zeile7, zeile8, zeile9, zeile10 );

    }

    /**
     *
     * @return Auswahl des vom User gewählten Programms
     */
    @Override
    public int programmAuswahl() {
        return sc.nextInt();
    }
}
