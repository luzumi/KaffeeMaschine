package Kaffeemaschine;/*corat
 *23.09.2020
 *18:01
 *KaffeeMaschine
 */

public class BehaelterWasser extends ZutatenBehaelter implements Wartbar{

    public BehaelterWasser(String rezeptZutat) {
        super(rezeptZutat);
        this.maxFuellMenge=10;
        this.fuellstand=10;
    }

    @Override
    public String toString() {
        return "Wasserbehaelter Fuellmenge = "+ this.fuellstand;
    }

    @Override
    public void wartung() {
        this.fuellstand = 10;
        System.out.println("Wasser wieder aufgefüllt");
    }
}
