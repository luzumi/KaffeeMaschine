/*corat
 *06.10.2020
 *14:30
 *KaffeeMaschine
 */

package kaffeemaschine;


import gui.KMGui;

import javax.swing.*;

/**
 * @author corat
 */
public class GuiStart {

    static JFrame frame;
    static JPanel panel;

    public static void main(String[] args) {

        //noinspection InstantiationOfUtilityClass
        Kaffeemaschine kaffeemaschine = new Kaffeemaschine();


        frame = KMGui.createFrame();
        panel = KMGui.invoke();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
