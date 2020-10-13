/*corat
 *03.10.2020
 *11:55
 *KaffeeMaschine
 */

package kaffeemaschine;

import gui.KMGui;

/**
 * Erweitern Sie die Kaffeemaschine um eine Fehlerbehandlung mittels Exceptions.
 *         • BehaelterVollException: wird geworfen, falls der AbfallBehaelter voll ist.
 *         Fehlerbehandlung:
 *         • Eine BehaelterVollException soll dazu führen, dass nur noch eine Wartung
 *         möglich ist
 * @author corat
 */
public class AbfallBehaelterVollException extends Exception {

    public AbfallBehaelterVollException(AbstractBehaelter[] behaelterListe) {
        super(behaelterListe[5].getBezeichner() + "-Behälter ist Voll____\n" +
                "Die KaffeeMaschine----------\n" +
                "muss gewartet werden.------\n" +
                "Drücken Sie die '9'--------\n");
        KMGui.menuNeuZeichnen(KMGui.getButtonLeerTexte());
    }


    @Override
    public String toString() {
        return (getLocalizedMessage());
    }
}
