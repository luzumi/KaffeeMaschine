/*corat
 *28.09.2020
 *16:54
 *KaffeeMaschine
 */

package kaffeemaschine;

/**
 * @author corat
 */
public interface IWartbar {

    /**
     * stellt für alle wartbaren Behälter die Methode wartung() bereit
     * Darin wird die Wartung in den Klassen spezifiziert
     */
    String wartung(AbstractBehaelter behaelter);
}
