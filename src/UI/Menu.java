/*corat
 *28.09.2020
 *13:33
 *KaffeeMaschine
 */

package UI;

import kaffeemaschine.*;

import java.util.Arrays;

/**
 * @author corat
 */
public class Menu implements IMenu {



    final static String AUSWAHL = Constants.ZEILE_1 + "\n" + Constants.ZEILE_2 + "\n" + Constants.ZEILE_3 + "\n" + Constants.ZEILE_4 + "\n" +
            Constants.ZEILE_5 + "\n" + Constants.ZEILE_6 + "\n" + Constants.ZEILE_7 + "\n" + Constants.ZEILE_8 + "\n" + Constants.ZEILE_9 + "\n" + Constants.ZEILE_10;

    public Menu() {
    }


    public static String menu() {
        return AUSWAHL;
    }

    public static String[] wartungInitiieren() {
        String[] wartungsMeldung = new String[Kaffeemaschine.behaelterListe.length];
        for (int zaehler = 0; zaehler < Kaffeemaschine.behaelterListe.length; zaehler++) {

                if (Kaffeemaschine.behaelterListe[zaehler].getFuellstand() <= Kaffeemaschine.behaelterListe[zaehler].getMaxFuellMenge()) {
                    wartungsMeldung[zaehler] = Kaffeemaschine.behaelterListe[zaehler].wartung(Kaffeemaschine.behaelterListe[zaehler]);
                    System.out.println(Kaffeemaschine.behaelterListe[zaehler].wartung(Kaffeemaschine.behaelterListe[zaehler]));
                }
                else{
                    wartungsMeldung[zaehler] = Kaffeemaschine.behaelterListe[zaehler].getBezeichner() + ": keine Wartung nötig";
                }
        }


        Kaffeemaschine.behaelterListe[5].wartung(Kaffeemaschine.behaelterListe[5]);


        System.out.println("============================");
        for (AbstractBehaelter behaelter : Kaffeemaschine.behaelterListe) {
            System.out.println(behaelter.toString(behaelter));
        }
        return wartungsMeldung;
    }

    public static String[] infoAuslesen() {
        String[] ausgabe = new String[Kaffeemaschine.behaelterListe.length];
        for (int zaehler = 0; zaehler < Kaffeemaschine.behaelterListe.length; zaehler++) {

                ausgabe[zaehler] = Kaffeemaschine.behaelterListe[zaehler].toString(Kaffeemaschine.behaelterListe[zaehler]) + "\n";
            System.out.println(Kaffeemaschine.behaelterListe[zaehler].toString(Kaffeemaschine.behaelterListe[zaehler]) + "\n");

            }
        System.out.println(Arrays.toString(ausgabe));
        return ausgabe;
    }
}


