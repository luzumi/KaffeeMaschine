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

    AbstractBehaelter[] kaffeemaschinen = new AbstractBehaelter[6];
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
        kaffeemaschinen[0] = new BehaelterWasser("Wasser");
        kaffeemaschinen[1] = new BehaelterKaffee("Kaffee");
        kaffeemaschinen[2] = new BehaelterKakao("Kakao");
        kaffeemaschinen[3] = new BehaelterZucker("Zucker");
        kaffeemaschinen[4] = new BehaelterMilch("Milch");
        kaffeemaschinen[5] = new BehaelterAbfall("Abfall");
    }


    /**
     * @param eingabeAuswahl Auswahl des Getränks auf Basis der {@link Menu}
     *                    Eingaben 1-5 erzeugt entsprechendes Getränk,
     *                    Entnimmt die Zutaten für das Produkt aus den jeweiligen Behältern
     *                    erzeugter Müll kommt in den Abfallbehältern
     */
    public void zutatenEntnahme(int eingabeAuswahl) {

        if(eingabeAuswahl > 0 && eingabeAuswahl <= Rezept.AuswahlProdukt.length) {
            getraenkZuebereiten(eingabeAuswahl);
            kaffeemaschinen[5].fuellstand -= 1;
            getraenkAusgeben(eingabeAuswahl);
        }
        else {
            if(eingabeAuswahl==PROGRAMM_ABBRUCH){
                programmAbbruch("Auswahl \"0\" -> Programmabruch");
            }
            else if(eingabeAuswahl == WARTUNG){
                wartungInitiieren();
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

        for (int zaehler = 0; zaehler < kaffeemaschinen.length - 1; zaehler++){

            if(kaffeemaschinen[zaehler].fuellstand == 0 ){

                this.kaffeemaschinen[zaehler].wartung();
            }
        }
    }


    public void getraenkZuebereiten(int eingabeAuswahl) {

        for (int zaehler = 0; zaehler < kaffeemaschinen.length - 1; zaehler++) {

            if (pruefeFuellstand(eingabeAuswahl - 1, zaehler)) {

                kaffeemaschinen[zaehler].fuellstand -= Rezept.getZutatenVerbrauch[eingabeAuswahl - 1][zaehler];

                System.out.println(kaffeemaschinen[zaehler].toString());

            } else {
                betriebsbereit = false;

                wartenAufWartung(zaehler);

                break;
            }
        }
        System.out.println(kaffeemaschinen[5].toString());
    }


    private void wartenAufWartung(int zaehler) {

        while(!betriebsbereit){

            System.out.println(kaffeemaschinen[zaehler].bezeichner + "Behälter ist LEER\n*****************\nDrücken Sie die 9!\n\n******************");

            IAuswahl menu = new Menu();

            if (menu.programmAuswahl() == WARTUNG) {

                for (AbstractBehaelter b: kaffeemaschinen){

                    b.wartung();
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

        return ((kaffeemaschinen[zaehler].fuellstand - Rezept.getZutatenVerbrauch[eingabeUser][zaehler]) > 0);
    }
}
