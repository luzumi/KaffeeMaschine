package KaffeeMaschine;/*corat
 *23.09.2020
 *17:16
 *KaffeeMaschine
 */

/**
 * abstrakter Behälter als Vorlage für Zutatenbehälter und Abfallbehälter
 * @author corat
 */
public abstract class AbstractBehaelter implements IWartbar {
    public String bezeichner;
    double fuellstand;
    double maxFuellMenge;

    public AbstractBehaelter(String bezeichner) {
        this.bezeichner = bezeichner;
    }

    /**
     *  Jeder Behälter bekommt die Ausgabefunktion
     * @return fuellstand des Behälters und Bestätigung der Aktion in der Console
     */
    @Override
    public abstract String toString();

}
