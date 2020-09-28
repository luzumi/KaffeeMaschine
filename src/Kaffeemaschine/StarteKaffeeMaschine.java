/*corat
 *28.09.2020
 *13:31
 *KaffeeMaschine
 */

package Kaffeemaschine;

/**
 * @author corat
 * Programmieraufgabe
 * {@see Kaffeemaschine.pdf}
 *
 */
public class StarteKaffeeMaschine {
    public static void main(String[] args) {


        Kaffeemaschine kaffeemaschine = new Kaffeemaschine();

        while (Kaffeemaschine.betriebsbereit) {
            Auswahl auswahl = new Auswahl();
            kaffeemaschine.zutatenEntnahme(kaffeemaschine.programmAuswahl());

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
/*TODO Status
        Schreiben Sie nach jeder Benutzeraktion den Maschinen-Status (Füllstand der Zutaten und
        des AbfallBehaelters) auf stdout.
        Verwenden Sie dazu in geeigneter Weise die Methode public String toString() aller
        beteiligen Klassen (KaffeeMaschine, AbfallBehaelter und ZutatenBehaelter).*/
