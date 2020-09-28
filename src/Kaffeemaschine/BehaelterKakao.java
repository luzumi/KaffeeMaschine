package Kaffeemaschine;/*corat
 *23.09.2020
 *17:36
 *KaffeeMaschine
 */

public class BehaelterKakao extends ZutatenBehaelter implements Wartbar{


    public BehaelterKakao(String rezeptZutat) {
        super(rezeptZutat);
        this.maxFuellMenge = 1;
        this.fuellstand = 1;
    }

    @Override
    public String toString() {
        return "Kakobehaelter Fuellmenge = "+ this.fuellstand;
    }

    @Override
    public void wartung() {
        this.fuellstand = 1;
        System.out.println("Kakao wieder aufgefüllt");
    }
}