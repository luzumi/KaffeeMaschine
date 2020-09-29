package kaffeemaschine;/*corat
 *23.09.2020
 *17:35
 *KaffeeMaschine
 */

/**
 * @author corat
 */
public class BehaelterMilch extends ZutatenBehaelter implements IWartbar {

    public BehaelterMilch(String rezeptZutat) {

        super(rezeptZutat);

        this.maxFuellMenge = 1;

        this.fuellstand = 1;
    }

    @Override
    public String toString() {
        return "Milchbehaelter Fuellmenge = "+ this.fuellstand;
    }

    @Override
    public void wartung() {

        this.fuellstand = 1;

        System.out.println("Milch wieder aufgefüllt");
    }
}
