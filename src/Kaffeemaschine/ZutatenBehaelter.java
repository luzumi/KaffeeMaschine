package Kaffeemaschine;/*corat
 *23.09.2020
 *17:19
 *KaffeeMaschine
 */

public class ZutatenBehaelter extends Behaelter implements Wartbar{

    public ZutatenBehaelter(String rezeptZutat) {
        super(rezeptZutat);

    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void wartung() {

    }
}
