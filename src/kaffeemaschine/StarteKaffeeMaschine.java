/*corat
 *28.09.2020
 *13:31
 *KaffeeMaschine
 */

package kaffeemaschine;

/**
 * @author corat
 * Programmieraufgabe
 * {@see Kaffeemaschine.pdf}
 *
 */
public class StarteKaffeeMaschine {

    public static void main(String[] args) {
        AbstractBehaelter[] kaffeemaschinen = new AbstractBehaelter[6];
        baueKaffeeMaschine(kaffeemaschinen);

        Kaffeemaschine kaffeemaschine = new Kaffeemaschine(kaffeemaschinen);

        IAuswahl menu = new Menu();

        while (Kaffeemaschine.betriebsbereit) {

            kaffeemaschine.zutatenEntnahme(menu.programmAuswahl());
        }
    }

    public static void baueKaffeeMaschine(AbstractBehaelter[] kaffeemaschinen) {
        kaffeemaschinen[0] = new BehaelterWasser("Wasser");
        kaffeemaschinen[1] = new BehaelterKaffee("Kaffee");
        kaffeemaschinen[2] = new BehaelterKakao("Kakao");
        kaffeemaschinen[3] = new BehaelterZucker("Zucker");
        kaffeemaschinen[4] = new BehaelterMilch("Milch");
        kaffeemaschinen[5] = new BehaelterAbfall("Abfall");
    }
}


/*TODO  Fehlerbehandlung
        Erweitern Sie die Kaffeemaschine um eine Fehlerbehandlung mittels Exceptions.
        Definieren Sie zwei Exception-Klassen:
        • BehaelterVollException: wird geworfen, falls der AbfallBehaelter voll ist.
        • ZutatLeerException: wird geworfen, falls ein ZutatenBehaelter leer ist.
        Erweitern Sie die Metode getraenkErstellen und die Hauptschleife um geeignete
        Fehlerbehandlung:
        • Eine BehaelterVollException soll dazu führen, dass nur noch eine Wartung
        möglich ist
        • Eine ZutatLeerException soll eine Warnung an den Benutzer ausgeben, dass
        seine Wahl zur Zeit nicht möglich ist.*/
