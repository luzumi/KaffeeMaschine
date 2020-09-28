package Kaffeemaschine;/*corat
 *23.09.2020
 *17:16
 *KaffeeMaschine
 */

/**
 * abstrakter Behälter als Vorlage für Zutatenbehälter und Abfallbehälter
 */
public abstract class Behaelter implements Wartbar {
    public String bezeichner;
    double fuellstand;
    double maxFuellMenge;

    public Behaelter(String bezeichner) {
        this.bezeichner = bezeichner;
    }

    @Override
    public abstract String toString();

}
