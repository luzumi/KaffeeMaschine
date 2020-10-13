/*corat
 *06.10.2020
 *14:30
 *KaffeeMaschine
 */

package kaffeemaschine;


import gui.KMGui;

import javax.swing.*;

public class GuiStart {

    static JFrame frame;
    static JPanel panel;

    public static void main(String[] args) throws Exception {

        //GuiKaffeeMaschine gui = new GuiKaffeeMaschine();
        Kaffeemaschine kaffeemaschine = new Kaffeemaschine();

        frame = KMGui.createFrame();
        panel = KMGui.invoke();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
