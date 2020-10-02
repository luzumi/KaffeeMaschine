package kaffeemaschine;/*corat
 *23.09.2020
 *17:16
 *KaffeeMaschine
 */

/**
 * abstrakter Behälter als Vorlage für Zutatenbehälter und Abfallbehälter
 * @author corat
 */
public abstract class AbstractBehaelter implements IWartbar {
    private final String bezeichner;
    private double fuellstand;
    final private double maxFuellMenge;

    public String getBezeichner() {
        return bezeichner;
    }

    public double getFuellstand() {
        return fuellstand;
    }

    public void setFuellstand(double fuellstand) {
        this.fuellstand = fuellstand;
    }

    public double getMaxFuellMenge() {
        return maxFuellMenge;
    }


    public AbstractBehaelter(String rezeptZutat, double fuellstand, double maxFuellMenge) {
        this.bezeichner = rezeptZutat;
        this.fuellstand = fuellstand;
        this.maxFuellMenge = maxFuellMenge;
    }

    /**
     *  Jeder Behälter bekommt die Ausgabefunktion
     * @return fuellstand des Behälters und Bestätigung der Aktion in der Console
     */

    public abstract String toString(AbstractBehaelter behaelter);

}
