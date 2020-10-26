/*corat
 *13.10.2020
 *08:06
 *KaffeeMaschine
 */

package gui;

import UI.Menu;
import kaffeemaschine.Constants;
import kaffeemaschine.Kaffeemaschine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**Klasse zum erstellen der Displayausgaben
 * mit div Text
 * @author corat
 */
public class MenuSchreiber {

    private String[] systemMeldung;
    static int index = 0;

    public MenuSchreiber() {

    }

    public static String[] wartungAnfordern() {
        String[] wartungsMeldung = new String[Kaffeemaschine.behaelterListe.length];
        for (int zaehler = 0; zaehler < Kaffeemaschine.behaelterListe.length-1; zaehler++) {

            if (Kaffeemaschine.behaelterListe[zaehler].getFuellstand() < Kaffeemaschine.behaelterListe[zaehler].getMaxFuellMenge()) {
                wartungsMeldung[zaehler] = Kaffeemaschine.behaelterListe[zaehler].getBezeichner() + " : + Wartung nötig ";
                System.out.println(Kaffeemaschine.behaelterListe[zaehler].getBezeichner() + " : Wartung nötig");
            } else {
                wartungsMeldung[zaehler] = Kaffeemaschine.behaelterListe[zaehler].getBezeichner() + ": - keine Wartung";
            }
        }
        wartungsMeldung[Constants.ABFALLBEHAELTER] = Kaffeemaschine.behaelterListe[Constants.ABFALLBEHAELTER].getBezeichner() + ": + Wartung nötig";
        return wartungsMeldung;
    }

    public void schreibeWartungsinfo(JButton[] buttonliste) {
        setSystemMeldung(wartungAnfordern());
        createDisplayMessage(getSystemMeldung());

        KMGui.setTextLabel(new ImageIcon(".\\src\\gui\\Bilder\\Neu\\infoLog\\menu" + index + ".jpg"));

        buttonliste[0].setIcon(KMGui.getTextLabel());

        buttonliste[0].setActionCommand("");

        for (int i = 1; i < buttonliste.length; i++) {

            buttonliste[i].setVisible(false);
        }
    }


    public void createAbfallExceptionMessage(JButton[] buttonliste){

        String[] text = wartungAnfordern();

        createDisplayMessage(text);

        KMGui.setTextLabel(new ImageIcon(".\\src\\gui\\Bilder\\Neu\\infoLog\\menu" + index + ".jpg"));

        buttonliste[0].setIcon(KMGui.getTextLabel());

        buttonliste[0].setActionCommand("");

        for (int i = 1; i < buttonliste.length; i++) {
            buttonliste[i].remove(buttonliste[i]);
            //buttonliste[i].setVisible(false);
        }
    }


    public void schreibeInfoMenuItem(JButton[] buttonliste) {

        setSystemMeldung(Menu.infoAuslesen());

        createDisplayMessage(getSystemMeldung());

        KMGui.setTextLabel(new ImageIcon(".\\src\\gui\\Bilder\\Neu\\infoLog\\menu" + index + ".jpg"));

        KMGui.jLabels[3].setIcon(new ImageIcon(Constants.BILD_PFAD + "KM_UntenLeer.jpg"));

        buttonliste[0].setIcon(KMGui.getTextLabel());

        buttonliste[0].setActionCommand("");

        for (int i = 1; i < buttonliste.length; i++) {

            buttonliste[i].setVisible(false);
        }
    }


    public void createDisplayMessage(String[] text) {
        loescheLogFiles();
        index++;
        try  (DataOutputStream ioFileOutput = new DataOutputStream(new FileOutputStream(new File( Constants.BILD_PFAD + "\\infoLog\\menu" + index + ".jpg")))){
            System.out.println(index);
            BufferedImage menuImage = ImageIO.read(new File(Constants.BILD_PFAD + "\\menuBlanco.jpg"));

            Graphics g = menuImage.createGraphics();

            g.create(0, 0, menuImage.getWidth(), menuImage.getHeight());
            g.setFont(new Font("Monospaced", Font.BOLD, 11));
            g.setColor(Color.GREEN);

            for (int i = 0; i < text.length; i++) {
                g.drawString(text[i] + "\n", 21, 20 + 22 * i);
            }

            ImageIO.write(menuImage, "jpg", ioFileOutput);

            g.dispose();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    public void loescheLogFiles() {
        //erstellt dateiliste von Ordner
        File[] files = new File(Constants.BILD_PFAD + "\\infoLog\\").listFiles();
        //wenn mehr als 2 dateien, dann lösche die erste
        if(files.length>0) {
            if(files[0].delete()){
                System.out.println(files[0].getName() + " gelöscht");
                loescheLogFiles(); //sicherheitsausfruf. wenn programm vorher hart abgebrochen wurde, sind die alten dateien noch im ordner.
            }
            else{
                System.out.println(files[0].getName() + "konnte nicht gelöscht werden");
            }
        }
    }


    public String[] getSystemMeldung() {
        return systemMeldung;
    }

    public void setSystemMeldung(String[] sysMeldung) {
        systemMeldung = sysMeldung;
    }

}
