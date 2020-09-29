package KaffeeMaschine;/*corat
 *23.09.2020
 *17:19
 *KaffeeMaschine
 */

/**
 * @author corat
 */
public class ZutatenBehaelter extends AbstractBehaelter implements IWartbar {

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
