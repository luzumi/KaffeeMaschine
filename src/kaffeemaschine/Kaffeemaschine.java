/*corat
 *27.09.2020
 *13:03
 *KaffeeMaschine
 */

package kaffeemaschine;

import java.util.Arrays;

/**
 * @author corat
 * KaffeeMaschine hat verschiedene Behälter
 * und bereitet Getränk nach Usereingabe zu
 * Dabei fällt Müll an, der im Abfallbehälter geammelt wird
 */
public class Kaffeemaschine {

    static AbstractBehaelter[] behaelterListe = new AbstractBehaelter[6];
    static boolean betriebsbereit = true;


    /**
     * eine Kaffeemaschine hat 6 verschiedene Behältern,
     * einen für Müll und 5 weitere mit Zutaten für die Getränke
     * Diese finden sich im kaffeemaschinen-Array wieder
     */
    public Kaffeemaschine() {
        behaelterListe[0] = new ZutatenBehaelter("Wasser", 10, 10);
        behaelterListe[1] = new ZutatenBehaelter("Kaffee", 1, 1);
        behaelterListe[2] = new ZutatenBehaelter("Kakao", 1, 1);
        behaelterListe[3] = new ZutatenBehaelter("Zucker", 1, 1);
        behaelterListe[4] = new ZutatenBehaelter("Milch", 1, 1);
        behaelterListe[Constants.ABFALLBEHAELTER] = new AbfallBehaelter("Abfall", 0, 100);
    }


    /**
     * @param eingabeAuswahl Auswahl des Getränks auf Basis der {@link Menu}
     *                       Eingaben 1-5 erzeugt entsprechendes Getränk,
     *                       Entnimmt die Zutaten für das Produkt aus den jeweiligen Behältern
     *                       erzeugter Müll kommt in den Abfallbehältern
     */
    public static void zutatenEntnahme(int eingabeAuswahl) throws AbfallBehaelterVollException, ZutatLeerException{

        if (eingabeAuswahl > 0 && eingabeAuswahl <= Rezept.AuswahlProdukt.length) {
            if(behaelterListe[Constants.ABFALLBEHAELTER].getFuellstand() == behaelterListe[Constants.ABFALLBEHAELTER].getMaxFuellMenge()){
                try {
                    throw new AbfallBehaelterVollException(behaelterListe);
                } catch (AbfallBehaelterVollException e) {
                    System.out.println(e.toString());
                }
            }
            else {
                behaelterListe[Constants.ABFALLBEHAELTER].setFuellstand(behaelterListe[Constants.ABFALLBEHAELTER].getFuellstand() + 10);
                getraenkZuebereiten(eingabeAuswahl);
                getraenkAusgeben(eingabeAuswahl);
            }
        } else {
            if (eingabeAuswahl == Constants.PROGRAMM_ABBRUCH) {
                programmAbbruch("Auswahl \"0\" -> Programmabruch");
            } else if (eingabeAuswahl == Constants.WARTUNG) {
                wartungInitiieren();
            } else {
                programmAbbruch("Falsche Eingabe -> Programmabruch");
            }
        }
    }


    public static void programmAbbruch(String ausgabeText) {
        System.out.println(ausgabeText);

        System.exit(Constants.PROGRAMM_ABBRUCH);
    }


    public static void wartungInitiieren() {

        for (int zaehler = 0; zaehler < behaelterListe.length; zaehler++) {

            if (behaelterListe[zaehler].getFuellstand() <= behaelterListe[zaehler].getMaxFuellMenge()) {

                System.out.println(behaelterListe[zaehler].wartung(behaelterListe[zaehler]));
            }
        }

        System.out.println("============================");
        for (AbstractBehaelter behaelter : behaelterListe) {
            System.out.println(behaelter.toString(behaelter));
        }
    }


    public static void getraenkZuebereiten(int eingabeAuswahl) {

        for (int zaehler = 0; zaehler < behaelterListe.length - 1; zaehler++) {

            if (pruefeZutatenFuellstand(eingabeAuswahl - 1, zaehler)) {

                behaelterListe[zaehler].setFuellstand(behaelterListe[zaehler].getFuellstand() - Rezept.getZutatenVerbrauch[eingabeAuswahl - 1][zaehler]);

                System.out.println(behaelterListe[zaehler].toString(behaelterListe[zaehler]));

            } else {
                betriebsbereit = false;

                wartenAufWartung(zaehler);

                break;
            }
        }
        System.out.println(behaelterListe[Constants.ABFALLBEHAELTER].toString(behaelterListe[Constants.ABFALLBEHAELTER]));
    }


    private static void wartenAufWartung(int zaehler) {

        while (!betriebsbereit) {

            try {
                throw new ZutatLeerException(behaelterListe, zaehler);
            } catch (ZutatLeerException e) {
                System.out.println(e.toString());
            } finally {

                System.out.println(Menu.menu());

                if (Menu.programmAuswahl("Programm auswählen", "") == Constants.WARTUNG) {

                    for (AbstractBehaelter b : behaelterListe) {

                        b.wartung(b);
                    }
                    betriebsbereit = true;
                }
            }
        }
    }


    private static void getraenkAusgeben(int eingabeUser) {

        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Bitte entnehmen Sie Ihr Getränk!\n" + Rezept.AuswahlProdukt[eingabeUser - 1]);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }


    private static boolean pruefeZutatenFuellstand(int eingabeUser, int zaehler) {

        return ((behaelterListe[zaehler].getFuellstand() - Rezept.getZutatenVerbrauch[eingabeUser][zaehler]) > 0);
    }

    public static String[] infoAuslesen() {
        String[] ausgabe = new String[behaelterListe.length];
        for (int zaehler = 0; zaehler < behaelterListe.length; zaehler++) {

                ausgabe[zaehler] = behaelterListe[zaehler].toString(behaelterListe[zaehler]) + "\n";
            System.out.println(behaelterListe[zaehler].toString(behaelterListe[zaehler]) + "\n");

            }
        System.out.println(Arrays.toString(ausgabe));
        return ausgabe;
    }
}
