/*corat
 *27.09.2020
 *13:03
 *KaffeeMaschine
 */

package kaffeemaschine;

/**
 * @author corat
 * KaffeeMaschine hat verschiedene Behälter
 * und bereitet Getränk nach Usereingabe zu
 * Dabei fällt Müll an, der im Abfallbehälter geammelt wird
 */
public class Kaffeemaschine {

    AbstractBehaelter[] behaelterListe = new AbstractBehaelter[6];
    static boolean betriebsbereit = true;
    final int WARTUNG = 9;
    final int PROGRAMM_ABBRUCH = 0;

    /**
     *
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
        behaelterListe[5] = new AbfallBehaelter("Abfall", 0, 100);
    }


    /**
     * @param eingabeAuswahl Auswahl des Getränks auf Basis der {@link Menu}
     *                    Eingaben 1-5 erzeugt entsprechendes Getränk,
     *                    Entnimmt die Zutaten für das Produkt aus den jeweiligen Behältern
     *                    erzeugter Müll kommt in den Abfallbehältern
     */
    public void zutatenEntnahme(int eingabeAuswahl) {

        if(eingabeAuswahl > 0 && eingabeAuswahl <= Rezept.AuswahlProdukt.length) {
            behaelterListe[5].setFuellstand( behaelterListe[5].getFuellstand() + 1);
            getraenkZuebereiten(eingabeAuswahl);
            getraenkAusgeben(eingabeAuswahl);
            System.out.println(Menu.menu());
        }
        else {                                                                          //TODO Exeptions
            if(eingabeAuswahl==PROGRAMM_ABBRUCH){
                programmAbbruch("Auswahl \"0\" -> Programmabruch");
            }
            else if(eingabeAuswahl == WARTUNG){
                wartungInitiieren();
                System.out.println(Menu.menu());
            }
            else {
                programmAbbruch("Falsche Eingabe -> Programmabruch");
            }
        }
    }


    public void programmAbbruch(String ausgabeText) {
        System.out.println(ausgabeText);

        System.exit(PROGRAMM_ABBRUCH);
    }


    public void wartungInitiieren() {

        for (int zaehler = 0; zaehler < behaelterListe.length; zaehler++){

            if(behaelterListe[zaehler].getFuellstand() < behaelterListe[zaehler].getMaxFuellMenge()){

                System.out.println(this.behaelterListe[zaehler].wartung(behaelterListe[zaehler]));
            }
        }
        System.out.println("============================");
        for (AbstractBehaelter ab : behaelterListe){
            System.out.println(ab.toString(ab));
        }
    }


    public void getraenkZuebereiten(int eingabeAuswahl) {

        for (int zaehler = 0; zaehler < behaelterListe.length - 1; zaehler++) {

            if (pruefeFuellstand(eingabeAuswahl - 1, zaehler)) {

                behaelterListe[zaehler].setFuellstand(behaelterListe[zaehler].getFuellstand() - Rezept.getZutatenVerbrauch[eingabeAuswahl - 1][zaehler]);

                System.out.println(behaelterListe[zaehler].toString(behaelterListe[zaehler]));

            } else {
                betriebsbereit = false;

                wartenAufWartung(zaehler);

                break;
            }
        }
        System.out.println(behaelterListe[5].toString(behaelterListe[5]));
    }


    private void wartenAufWartung(int zaehler) {

        while(!betriebsbereit){

            System.out.println(behaelterListe[zaehler].getBezeichner() + "Behälter ist LEER\n*****************\nDrücken Sie die 9!\n\n******************");

            System.out.println(Menu.menu());

            if (Menu.programmAuswahl() == WARTUNG) {

                for (AbstractBehaelter b: behaelterListe){

                    b.wartung(b);
                }
                betriebsbereit = true;
            }
        }
    }


    private void getraenkAusgeben(int eingabeUser) {

        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Bitte entnehmen Sie Ihr Getränk! " + Rezept.AuswahlProdukt[eingabeUser-1]);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }


    private boolean pruefeFuellstand(int eingabeUser, int zaehler) {

        return ((behaelterListe[zaehler].getFuellstand() - Rezept.getZutatenVerbrauch[eingabeUser][zaehler]) > 0);
    }
}
