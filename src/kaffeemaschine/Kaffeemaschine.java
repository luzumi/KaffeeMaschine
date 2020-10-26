/*corat
 *27.09.2020
 *13:03
 *KaffeeMaschine
 */

package kaffeemaschine;

import UI.Menu;

import java.util.Scanner;

/**
 * @author corat
 * KaffeeMaschine hat verschiedene Behälter
 * und bereitet Getränk nach Usereingabe zu
 * Dabei fällt Müll an, der im Abfallbehälter geammelt wird
 */
public class Kaffeemaschine {


    public static AbstractBehaelter[] behaelterListe = new AbstractBehaelter[6];
    public static boolean betriebsbereit = true;

    /**
     * eine Kaffeemaschine hat 6 verschiedene Behältern,
     * einen für Müll und 5 weitere mit Zutaten für die Getränke
     * Diese finden sich im kaffeemaschinen-Array wieder
     */
    public Kaffeemaschine() {
        behaelterListe[0] = new ZutatenBehaelter("Wasser", 25, 25);
        behaelterListe[1] = new ZutatenBehaelter("Kaffee", 3, 3);
        behaelterListe[2] = new ZutatenBehaelter("Kakao", 3, 3);
        behaelterListe[3] = new ZutatenBehaelter("Zucker", 3, 3);
        behaelterListe[4] = new ZutatenBehaelter("Milch", 3, 3);
        behaelterListe[Constants.ABFALLBEHAELTER] = new AbfallBehaelter("Abfall", 0, 100);
    }


    public static boolean pruefeZutatenFuellstand(int eingabeUser, int zaehler) {

        return ((behaelterListe[zaehler].getFuellstand() - Rezept.getZutatenVerbrauch[eingabeUser][zaehler]) > 0);
    }

    /**
     * @return Auswahl des vom User gewählten Programms
     */
    //public static int programmAuswahl() { return Integer.parseInt(new Scanner(System.in).nextLine()); }

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

    /**
     * @param eingabeAuswahl Auswahl des Getränks auf Basis der {@link Menu}
     *                       Eingaben 1-5 erzeugt entsprechendes Getränk,
     *                       Entnimmt die Zutaten für das Produkt aus den jeweiligen Behältern
     *                       erzeugter Müll kommt in den Abfallbehältern
     */
    public static void zutatenEntnahme(int eingabeAuswahl) throws AbfallBehaelterVollException, ZutatLeerException {

        if (eingabeAuswahl > 0 && eingabeAuswahl <= Rezept.AuswahlProdukt.length) {
            if(behaelterListe[Constants.ABFALLBEHAELTER].getFuellstand() == behaelterListe[Constants.ABFALLBEHAELTER].getMaxFuellMenge()){
                try {
                    throw new AbfallBehaelterVollException(behaelterListe);
                } catch (AbfallBehaelterVollException e) {
                    System.out.println(e.toString());
                }
            }
            else {
                behaelterListe[Constants.ABFALLBEHAELTER].setFuellstand(behaelterListe[Constants.ABFALLBEHAELTER].getFuellstand() + 1);
                getraenkZuebereiten(eingabeAuswahl);
                getraenkAusgeben(eingabeAuswahl);
            }
        } else {
            if (eingabeAuswahl == Constants.PROGRAMM_ABBRUCH) {
                programmAbbruch("Auswahl \"0\" -> Programmabruch");
            } else if (eingabeAuswahl == Constants.WARTUNG) {
                Menu.wartungInitiieren();

            } else {
                programmAbbruch("Falsche Eingabe -> Programmabruch");
            }
        }
    }

    public static void programmAbbruch(String ausgabeText) {
        System.out.println(ausgabeText);

        System.exit(Constants.PROGRAMM_ABBRUCH);
    }

    public static void getraenkZuebereiten(int eingabeAuswahl) throws ZutatLeerException{

        for (int zaehler = 0; zaehler < behaelterListe.length - 1; zaehler++) {

            if (pruefeZutatenFuellstand(eingabeAuswahl - 1, zaehler)) {

                behaelterListe[zaehler].setFuellstand(behaelterListe[zaehler].getFuellstand() - Rezept.getZutatenVerbrauch[eingabeAuswahl - 1][zaehler]);

                System.out.println(behaelterListe[zaehler].toString(behaelterListe[zaehler]));

            } else {
                betriebsbereit = false;

                wartenAufWartung(zaehler);

            }
        }
        System.out.println(behaelterListe[Constants.ABFALLBEHAELTER].toString(behaelterListe[Constants.ABFALLBEHAELTER]));
    }

    private static void wartenAufWartung(int zaehler) throws ZutatLeerException {

        while (!betriebsbereit) {

            try {
                throw new ZutatLeerException(behaelterListe, zaehler);
            } catch (ZutatLeerException e) {
                System.out.println(e.toString());
            } finally {

                System.out.println(Menu.menu());

                if (programmAuswahl("Programm auswählen", "") == Constants.WARTUNG) {

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
}
