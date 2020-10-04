/*corat
 *03.10.2020
 *11:56
 *KaffeeMaschine
 */

package kaffeemaschine;

/**
 * Erweitern Sie die Kaffeemaschine um eine Fehlerbehandlung mittels Exceptions.
 * • ZutatLeerException: wird geworfen, falls ein ZutatenBehaelter leer ist.
 * • Eine ZutatLeerException soll eine Warnung an den Benutzer ausgeben, dass
 * seine Wahl zur Zeit nicht möglich ist.
 *
 * @author corat
 */
public class ZutatLeerException extends Exception {

    public ZutatLeerException(AbstractBehaelter[] behaelterListe, int zaehler) {
        super(behaelterListe[zaehler].getBezeichner() + "Behälter ist LEER_____\n*Auswahl z.Z. nicht möglich*\nDrücken Sie zur Wartung '9'!\n\n******************");
    }

    @Override
    public String toString() {
        return (getLocalizedMessage());
    }
}
