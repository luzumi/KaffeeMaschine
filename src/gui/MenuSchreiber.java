/*corat
 *13.10.2020
 *08:06
 *KaffeeMaschine
 */

package gui;

import kaffeemaschine.Kaffeemaschine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MenuSchreiber {

    private static String[] systemMeldung;
    static Thread t;
    private static boolean running;
    public static void schreibeInfoMenuItem(String[] buttonLeerTexte, JButton[] buttonliste) {
        //index++;
        setSystemMeldung(Kaffeemaschine.infoAuslesen());

        createDisplayMessage(getSystemMeldung());

        //KMGui.menuNeuZeichnen(buttonLeerTexte);

        KMGui.setTextLabel(new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\Neu\\menuBlanco2.jpg"));

        buttonliste[0].setIcon(KMGui.getTextLabel());

        buttonliste[0].setActionCommand("");

        for (int i = 1; i < buttonliste.length; i++) {

            buttonliste[i].setVisible(false);
        }
    }


    public static void createDisplayMessage(String[] text) {

        try  (DataOutputStream ioFileOutput = new DataOutputStream(new FileOutputStream(new File("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\Neu\\menuBlanco2.jpg")))){

            BufferedImage menuImage = ImageIO.read(new File("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\Neu\\menuBlanco.jpg"));

            Graphics g = menuImage.createGraphics();

            g.create(0, 0, menuImage.getWidth(), menuImage.getHeight());
            g.setFont(new Font("Monospaced", Font.BOLD, 12));
            g.setColor(Color.GREEN);

            for (int i = 0; i < text.length; i++) {
                g.drawString(text[i] + "\n", 44, 22 * i);
            }

            ImageIO.write(menuImage, "jpg", ioFileOutput);

            g.dispose();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    public static String[] getSystemMeldung() {
        return systemMeldung;
    }

    public static void setSystemMeldung(String[] sysMeldung) {
        systemMeldung = sysMeldung;
    }


}
