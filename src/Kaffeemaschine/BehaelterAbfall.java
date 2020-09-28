/*corat
 *28.09.2020
 *13:25
 *KaffeeMaschine
 */

package Kaffeemaschine;

/**
 * Abfallbehälter sammelt Abfälle bei der Getränkeherstellung -> 1 Einheit je Getränk
 * wird dem fuellstand abgezogen
 */
public class BehaelterAbfall extends Behaelter implements Wartbar{

    public BehaelterAbfall(String bezeichner) {
        super(bezeichner);
        this.maxFuellMenge = 0;
        this.fuellstand = 100;
    }

    @Override
    public String toString() {
        return "Abfallbehaelter Fuellmenge = "+ this.fuellstand;
    }

    @Override
    public void wartung() {
        this.fuellstand = 100;
        System.out.println("Abfallbehälter entleert");
    }
}
