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


    public Menu() {
        System.out.println("****** Kaffeemaschine ******");
        System.out.println("============================");
        System.out.println("Auswahl:____________________");
        System.out.println("1.) Kaffee schwarz__________");
        System.out.println("2.) Kaffee mit Zucker_______");
        System.out.println("3.) Kaffee mit Milch________");
        System.out.println("4.) Kaffee mit Milch/Zucker_");
        System.out.println("5.) Kakao___________________");
        System.out.println("9.) _________________Wartung");
        System.out.println("0.) _________________Abbruch");
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
