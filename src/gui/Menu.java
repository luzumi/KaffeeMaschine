/*corat
 *06.10.2020
 *17:56
 *KaffeeMaschine
 */

package gui;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class Menu {

    static JButton jbtnlinks, jbtnMenu, jbtnObenrechts, jbtnKaffeeSchwarz, jbtnKaffeeSchwarzWeiss, jbtnKaffeeSchwarzWeissZucker, jbtnMilch,
            jbtnrechts, jbtnKakao, jbtnfree1, jbtnfree2, jbtnfree3, jbtnWartung, jbtninfo, jbtnBlankoRechts;


    public static JPanel panelMenu() throws Exception {

        return invoke();
    }


    public static JPanel invoke() throws Exception {
        String bildPfad = "E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\";

        legeButtonsAn();
        erstelleBildPfade(bildPfad);

        JPanel menu = new JPanel(new BorderLayout());

        JPanel menuBox = new JPanel(new BorderLayout());

        JPanel menuOben = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
        menuOben.add(jbtnMenu);
        menuOben.add(jbtnObenrechts);

        JPanel menuMitteOben = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));

        JPanel menuMitteUnten = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
        menuMitteOben.add(jbtnKaffeeSchwarz);
        menuMitteOben.add(jbtnKaffeeSchwarzWeiss);
        menuMitteOben.add(jbtnKaffeeSchwarzWeissZucker);
        menuMitteOben.add(jbtnMilch);
        menuMitteUnten.add(jbtnfree1);
        menuMitteUnten.add(jbtnfree2);
        menuMitteUnten.add(jbtnfree3);
        menuMitteUnten.add(jbtnKakao);

        JPanel menuMitteOhneRechts = new JPanel(new BorderLayout());
        menuMitteOhneRechts.add(menuMitteOben, BorderLayout.NORTH);
        menuMitteOhneRechts.add(menuMitteUnten, BorderLayout.SOUTH);


        JPanel menuMitteRechts = new JPanel(new BorderLayout());
        menuMitteRechts.add(jbtnBlankoRechts, BorderLayout.WEST);

        JPanel menuMitteGesamt = new JPanel(new BorderLayout());
        menuMitteGesamt.add(menuMitteOhneRechts, BorderLayout.WEST);
        menuMitteGesamt.add(menuMitteRechts, BorderLayout.EAST);

        JPanel menuUnten = new JPanel(new FlowLayout(FlowLayout.LEFT, 0,0));

        menuUnten.add(jbtnWartung);
        menuUnten.add(jbtninfo);

        menuBox.add(menuOben, BorderLayout.NORTH);
        menuBox.add(menuMitteGesamt, BorderLayout.CENTER);
        menuBox.add(menuUnten, BorderLayout.SOUTH);



        menu.add(menuBox, BorderLayout.CENTER);
        menu.add(jbtnlinks,  BorderLayout.WEST);

        return menu;
        //TODO Größe Menu anpassen und positionieren

    }


    private static void erstelleBildPfade(String bildPfad) {

        ImageIcon linksImage = new ImageIcon(bildPfad + "blanko_Links.jpg");
        ImageIcon menuImage = new ImageIcon(bildPfad + "button_Menu.jpg");
        ImageIcon obenrechtsImage = new ImageIcon(bildPfad + "blanko_ObenRechts.jpg");
        ImageIcon kaffeeSchwarz = new ImageIcon(bildPfad + "Button_KaffeeSchwarz.jpg");
        ImageIcon kaffeeSchwarzWeiss = new ImageIcon(bildPfad + "Button_KaffeeSchwarzWeiss.jpg");
        ImageIcon kaffeeSchwarzWeissZucker = new ImageIcon(bildPfad + "Button_KaffeeSchwarzWeissZucker.jpg");
        ImageIcon milch = new ImageIcon(bildPfad + "Button_Milch.jpg");
        ImageIcon rechts = new ImageIcon(bildPfad + "blanko_Rechts.jpg");
        ImageIcon kakao = new ImageIcon(bildPfad + "Button_Kakao.jpg");
        ImageIcon free1 = new ImageIcon(bildPfad + "Button_Free1.jpg");
        ImageIcon free2 = new ImageIcon(bildPfad + "Button_Free2.jpg");
        ImageIcon free3 = new ImageIcon(bildPfad + "Button_Free3.jpg");
        ImageIcon wartung = new ImageIcon(bildPfad + "Button_Wartung.jpg");
        ImageIcon info = new ImageIcon(bildPfad + "Button_Info.jpg");
        ImageIcon blankoRechts = new ImageIcon(bildPfad + "blanko_Rechts.jpg");

        setIconAufButtons(linksImage, menuImage, obenrechtsImage, kaffeeSchwarz, kaffeeSchwarzWeiss, kaffeeSchwarzWeissZucker, milch, rechts, kakao, free1, free2, free3, wartung, info, blankoRechts);
    }


    private static void setIconAufButtons(ImageIcon linksImage, ImageIcon menuImage, ImageIcon obenrechtsImage, ImageIcon kaffeeSchwarz, ImageIcon kaffeeSchwarzWeiss, ImageIcon kaffeeSchwarzWeissZucker, ImageIcon milch, ImageIcon rechts, ImageIcon kakao, ImageIcon free1, ImageIcon free2, ImageIcon free3, ImageIcon wartung, ImageIcon info, ImageIcon blankoRechts) {

        jbtnKaffeeSchwarz.setIcon(kaffeeSchwarz);
        jbtnKaffeeSchwarzWeiss.setIcon(kaffeeSchwarzWeiss);
        jbtnKaffeeSchwarzWeissZucker.setIcon(kaffeeSchwarzWeissZucker);
        jbtnMilch.setIcon(milch);
        jbtnrechts.setIcon(rechts);
        jbtnKakao.setIcon(kakao);
        jbtnfree1.setIcon(free1);
        jbtnfree2.setIcon(free2);
        jbtnfree3.setIcon(free3);
        jbtnWartung.setIcon(wartung);
        jbtninfo.setIcon(info);
        jbtnlinks.setIcon(linksImage);
        jbtnMenu.setIcon(menuImage);
        jbtnObenrechts.setIcon(obenrechtsImage);
        jbtnBlankoRechts.setIcon(blankoRechts);




        setSizeFromOriginal(jbtnKaffeeSchwarz, kaffeeSchwarz);
        setSizeFromOriginal(jbtnKaffeeSchwarzWeiss, kaffeeSchwarzWeiss);
        setSizeFromOriginal(jbtnKaffeeSchwarzWeissZucker, kaffeeSchwarzWeissZucker);
        setSizeFromOriginal(jbtnMilch, milch);
        setSizeFromOriginal(jbtnrechts, rechts);
        setSizeFromOriginal(jbtnKakao, kakao);
        setSizeFromOriginal(jbtnfree1, free1);
        setSizeFromOriginal(jbtnfree2, free2);
        setSizeFromOriginal(jbtnfree3, free3);
        setSizeFromOriginal(jbtnWartung, wartung);
        setSizeFromOriginal(jbtninfo, info);
        setSizeFromOriginal(jbtnlinks, linksImage);
        setSizeFromOriginal(jbtnMenu, menuImage);
        setSizeFromOriginal(jbtnObenrechts, obenrechtsImage);
        setSizeFromOriginal(jbtnBlankoRechts, blankoRechts);


    }

    private static JButton setSizeFromOriginal(JButton jbtn ,ImageIcon imageIcon) {
        Dimension d = new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight());
        jbtn.setMaximumSize(d);
        jbtn.setBorder(new CompoundBorder(null, null));
        return jbtn;
    }


    private static void legeButtonsAn() {
        jbtnKaffeeSchwarz = new JButton();
        jbtnKaffeeSchwarzWeiss = new JButton();
        jbtnKaffeeSchwarzWeissZucker = new JButton();
        jbtnMilch = new JButton();
        jbtnrechts = new JButton();
        jbtnKakao = new JButton();
        jbtnfree1 = new JButton();
        jbtnfree2 = new JButton();
        jbtnfree3 = new JButton();
        jbtnWartung = new JButton();
        jbtninfo = new JButton();
        jbtnlinks = new JButton();
        jbtnMenu = new JButton();
        jbtnObenrechts = new JButton();
        jbtnBlankoRechts = new JButton();

    }


}