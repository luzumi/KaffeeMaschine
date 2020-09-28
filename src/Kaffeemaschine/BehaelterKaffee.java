package Kaffeemaschine;/*corat
 *23.09.2020
 *17:34
 *KaffeeMaschine
 */

public class BehaelterKaffee extends ZutatenBehaelter implements Wartbar{

    public BehaelterKaffee(String rezeptZutat) {
        super(rezeptZutat);
        this.maxFuellMenge = 1;
        this.fuellstand = 1;
    }

    @Override
    public String toString() {
        return "Kaffeebehaelter Fuellmenge = "+ this.fuellstand;
    }

    @Override
    public void wartung() {
        this.fuellstand = 1;
        System.out.println("Kaffee wieder aufgefüllt");
    }
}
