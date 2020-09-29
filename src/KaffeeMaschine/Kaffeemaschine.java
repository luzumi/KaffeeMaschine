/*corat
 *27.09.2020
 *13:03
 *KaffeeMaschine
 */

package KaffeeMaschine;

import java.util.Scanner;

/**
 * @author corat
 * KaffeeMaschine hat verschiedene Behälter
 * und bereitet Getränk nach Usereingabe zu
 * Dabei fällt Müll an, der im Abfallbehälter geammelt wird
 */
public class Kaffeemaschine {
    AbstractBehaelter[] kaffeemaschinen = new AbstractBehaelter[6];
    static boolean betriebsbereit = true;
    Scanner sc = new Scanner(System.in);
    final int WARTUNG = 9;

    public Kaffeemaschine() {
        kaffeemaschinen[0] = new BehaelterWasser("Wasser");
        kaffeemaschinen[1] = new BehaelterKaffee("Kaffee");
        kaffeemaschinen[2] = new BehaelterKakao("Kakao");
        kaffeemaschinen[3] = new BehaelterZucker("Zucker");
        kaffeemaschinen[4] = new BehaelterMilch("Milch");
        kaffeemaschinen[5] = new BehaelterAbfall("Abfall");
    }

    /**
     *
     * @return Auswahl des vom User gewählten Programms
     */
    public int programmAuswahl() {
        return sc.nextInt();
    }

    /**
     * @param eingabeUser Auswahl des Getränks auf Basis der {@link Auswahl}
     *                    Eingaben 1-5 erzeugt entsprechendes Getränk,
     *                    Entnimmt die Zutaten für das Produkt aus den jeweiligen Behältern
     *                    erzeugter Müll kommt in den Abfallbehältern
     */
    public void zutatenEntnahme(int eingabeUser) {
        if(eingabeUser > 0 && eingabeUser <= Rezept.AuswahlProdukt.length) {

            getraenkZuebereiten(eingabeUser);
            kaffeemaschinen[5].fuellstand -= 1;
            getraenkAusgeben(eingabeUser);
        }
        else {
            if(eingabeUser==0){
                System.out.println("Auswahl \"0\" -> Programmabruch");
                System.exit(0);
            }
            else if(eingabeUser == WARTUNG){
                wartungInitiieren();
            }
            else {
                System.out.println("Falsche Eingabe -> Programmabruch");
                System.exit(0);
            }
        }
    }

    public void wartungInitiieren() {
        for (int i = 0; i < kaffeemaschinen.length - 1; i++){
            if(kaffeemaschinen[i].fuellstand == 0 ){
                this.kaffeemaschinen[i].wartung();
            }
        }
    }

    public void getraenkZuebereiten(int eingabeUser) {
        for (int i = 0; i < kaffeemaschinen.length - 1; i++) {

            if (pruefeFuellstand(eingabeUser - 1, i)) {
                kaffeemaschinen[i].fuellstand -= Rezept.getZutatenVerbrauch[eingabeUser - 1][i];
                System.out.println(kaffeemaschinen[i].toString());
            } else {
                betriebsbereit = false;
                wartenAufWartung(i);
                break;
            }
        }
    }

    private void wartenAufWartung(int zaehler) {
        while(!betriebsbereit){
            System.out.println(kaffeemaschinen[zaehler].bezeichner + "Behälter ist LEER\n*****************\nDrücken Sie die 9!\n\n******************");
            Auswahl auswahl = new Auswahl();
            if(programmAuswahl() == 9){
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
