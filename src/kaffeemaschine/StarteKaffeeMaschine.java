/*corat
 *28.09.2020
 *13:31
 *KaffeeMaschine
 */

package kaffeemaschine;

import UI.Menu;

/**
 * @author corat
 * Programmieraufgabe
 * {@see Kaffeemaschine.pdf}
 *
 */
public class StarteKaffeeMaschine {

    public static void main(String[] args) throws ZutatLeerException, AbfallBehaelterVollException {

        Kaffeemaschine kaffeemaschine = new Kaffeemaschine();


        while (Kaffeemaschine.betriebsbereit) {

            System.out.println(Menu.menu());
            Kaffeemaschine.zutatenEntnahme(Kaffeemaschine.programmAuswahl("Programm auswählen", ""));
        }
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

