package kaffeemaschine;/*corat
 *23.09.2020
 *17:34
 *KaffeeMaschine
 */

/**
 * @author corat
 */
public class BehaelterZucker extends ZutatenBehaelter implements IWartbar {

    public BehaelterZucker(String rezeptZutat) {

        super(rezeptZutat);

        this.maxFuellMenge = 1;

        this.fuellstand = 1;
    }


    @Override
    public String toString() {
        return "Zuckerbehaelter Fuellmenge = "+ this.fuellstand;
    }


    @Override
    public void wartung() {

        this.fuellstand = 1;

        System.out.println("Zucker wieder aufgefüllt");
    }
}
