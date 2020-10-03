/*corat
 *28.09.2020
 *13:25
 *KaffeeMaschine
 */

package kaffeemaschine;

/**
 * Abfallbehälter sammelt Abfälle bei der Getränkeherstellung -> 1 Einheit je Getränk
 * wird dem fuellstand (Startwert 0) abgezogen
 * @author corat
 */
public class AbfallBehaelter extends AbstractBehaelter implements IWartbar {



    public AbfallBehaelter(String abfall, double fuellstand, double maxFuellMenge) {
        super(abfall, (int)fuellstand, (int)maxFuellMenge);
    }


    @Override
    public String toString(AbstractBehaelter behaelter) {
        return "\tAbfallbehaelter: . ."+ (int)behaelter.getFuellstand() + " %";
    }


    @Override
    public String wartung(AbstractBehaelter behaelter) {
        this.setFuellstand(0);
        return "Abfallbehälter entleert";
    }
}
