/*corat
 *06.10.2020
 *17:56
 *KaffeeMaschine
 */

package gui;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Menu {

    static String bildPfad = ".\\gui\\Bilder\\";
    static JButton[] buttonliste = new JButton[15];
    static ImageIcon[] imageIcons = new ImageIcon[15];
    static String[] buttonTexte = new String[]{
            /* 0 */    "jbtnKaffeeSchwarz",
            /* 1 */    "jbtnKaffeeSchwarzWeiss",
            /* 2 */    "jbtnKaffeeSchwarzWeissZucker",
            /* 3 */    "jbtnMilch",
            /* 4 */    "jbtnKakao",
            /* 5 */    "jbtnWartung",
            /* 6 */    "jbtninfo",
            /* 7 */    "jbtnfree1",
            /* 8 */    "jbtnfree2",
            /* 9 */    "jbtnfree3",
            /* 10 */    "jbtnBlankoRechts",
            /* 11 */    "jbtnrechts",
            /* 12 */    "jbtnlinks",
            /* 13 */    "jbtnMenu",
            /* 14 */    "jbtnObenrechts"};


    public static JPanel invoke() throws Exception {

        legeButtonsAn();


        JPanel menuOben = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        menuOben.add(buttonliste[13]);
        menuOben.add(buttonliste[11]);

        JPanel menuMitteOben = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        menuMitteOben.add(buttonliste[0]);
        menuMitteOben.add(buttonliste[1]);
        menuMitteOben.add(buttonliste[2]);
        menuMitteOben.add(buttonliste[3]);

        JPanel menuMitteUnten = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        menuMitteUnten.add(buttonliste[7]);
        menuMitteUnten.add(buttonliste[8]);
        menuMitteUnten.add(buttonliste[9]);
        menuMitteUnten.add(buttonliste[4]);

        JPanel menuMitteOhneRechts = new JPanel(new BorderLayout());
        menuMitteOhneRechts.add(menuMitteOben, BorderLayout.NORTH);
        menuMitteOhneRechts.add(menuMitteUnten, BorderLayout.SOUTH);

        JPanel menuMitteRechts = new JPanel(new BorderLayout());
        menuMitteRechts.add(buttonliste[10], BorderLayout.WEST);

        JPanel menuMitteGesamt = new JPanel(new BorderLayout());
        menuMitteGesamt.add(menuMitteOhneRechts, BorderLayout.WEST);
        menuMitteGesamt.add(menuMitteRechts, BorderLayout.EAST);

        JPanel menuUnten = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        menuUnten.add(buttonliste[5]);
        menuUnten.add(buttonliste[6]);

        JPanel menuBox = new JPanel(new BorderLayout());
        menuBox.add(menuOben, BorderLayout.NORTH);
        menuBox.add(menuMitteGesamt, BorderLayout.CENTER);
        menuBox.add(menuUnten, BorderLayout.SOUTH);

        JPanel finalMenu = new JPanel(new BorderLayout());
        finalMenu.add(buttonliste[12], BorderLayout.EAST);
        finalMenu.add(menuBox, BorderLayout.CENTER);
        finalMenu.setLayout(new GridBagLayout());
        finalMenu.setBounds(1110, 110, 110, 330);

        //TODO Größe Menu anpassen und positionieren

        return finalMenu;

    }

    private static void createAndSetIcons(String bildPfad) {

        imageIcons[0] = new ImageIcon(bildPfad + "Button_KaffeeSchwarz.jpg");
        imageIcons[1] = new ImageIcon(bildPfad + "Button_KaffeeSchwarzWeiss.jpg");
        imageIcons[2] = new ImageIcon(bildPfad + "Button_KaffeeSchwarzWeissZucker.jpg");
        imageIcons[3] = new ImageIcon(bildPfad + "Button_Milch.jpg");
        imageIcons[4] = new ImageIcon(bildPfad + "Button_Kakao.jpg");
        imageIcons[5] = new ImageIcon(bildPfad + "Button_Wartung.jpg");
        imageIcons[6] = new ImageIcon(bildPfad + "Button_Info.jpg");
        imageIcons[7] = new ImageIcon(bildPfad + "Button_Free1.jpg");
        imageIcons[8] = new ImageIcon(bildPfad + "Button_Free2.jpg");
        imageIcons[9] = new ImageIcon(bildPfad + "Button_Free3.jpg");
        imageIcons[10] = new ImageIcon(bildPfad + "blanko_Rechts.jpg");
        imageIcons[11] = new ImageIcon(bildPfad + "blanko_ObenRechts.jpg");
        imageIcons[12] = new ImageIcon(bildPfad + "blanko_Links.jpg");
        imageIcons[13] = new ImageIcon(bildPfad + "button_Menu.jpg");
        imageIcons[14] = new ImageIcon(bildPfad + "Button_Free");

    }

    private static Dimension setSizeFromOriginal(JButton button) {

        return new Dimension(button.getIcon().getIconWidth() / 2, button.getIcon().getIconHeight() / 2);
    }

    private static void legeButtonsAn() {
        createAndSetIcons(bildPfad);
        for (int i = 0; i < buttonliste.length; i++) {
            buttonliste[i] = new JButton();
            buttonliste[i].setBorder(new CompoundBorder(null, null));
            buttonliste[i].setActionCommand(buttonTexte[i]);
            buttonliste[i].setIcon(imageIcons[i]);
            buttonliste[i].setSize(setSizeFromOriginal(buttonliste[i]));
            buttonliste[i].addActionListener(Menu::actionPerformed);


        }
    }

    static void actionPerformed(ActionEvent e) {
        GuiKaffeeMaschine.backgroundButton.setEnabled(true);
        GuiKaffeeMaschine.backgroundButton.setVisible(true);

        GuiKaffeeMaschine.menuPanel.setEnabled(true);
        GuiKaffeeMaschine.menuPanel.setVisible(true);

        switch (e.getActionCommand()) {
            case "jbtnKaffeeSchwarz":
                GuiKaffeeMaschine.backgroundButton.setIcon(new ImageIcon(bildPfad + "WMF_Professional_Coffeemachines_KaffeeSchwarz.jpg"));
                System.out.println(e.getActionCommand());
                break;
            case "jbtnKaffeeSchwarzWeiss":
                GuiKaffeeMaschine.backgroundButton.setIcon(new ImageIcon(bildPfad + "WMF_Professional_Coffeemachines_KaffeeSchwarzWeiss.jpg"));
                System.out.println(e.getActionCommand());
                break;
            case "jbtnKaffeeSchwarzWeissZucker":
                GuiKaffeeMaschine.backgroundButton.setIcon(new ImageIcon(bildPfad + "WMF_Professional_Coffeemachines_KaffeeSchwarzWeissZucker.jpg"));
                System.out.println(e.getActionCommand());
                break;
            case "jbtnMilch":
                GuiKaffeeMaschine.backgroundButton.setIcon(new ImageIcon(bildPfad + "WMF_Professional_Coffeemachines_Milch.jpg"));
                System.out.println(e.getActionCommand());
                break;
            case "jbtnKakao":
                GuiKaffeeMaschine.backgroundButton.setIcon(new ImageIcon(bildPfad + "WMF_Professional_Coffeemachines_Kakao0.jpg"));
                System.out.println(e.getActionCommand());
                break;
            //case "jbtnWartung":
            //    GuiKaffeeMaschine.button.setIcon(new ImageIcon(bildPfad + "WMF_Professional_Coffeemachines_Betriebspause_00.jpg"));
            //    System.out.println(e.getActionCommand());
            //    break;
            //case "jbtninfo":
            //    GuiKaffeeMaschine.button.setIcon(new ImageIcon(bildPfad + "WMF_Professional_Coffeemachines_Betriebspause_00.jpg"));
            //    System.out.println(e.getActionCommand());
            //    break;
            case "blanko_ObenRechts":
                GuiKaffeeMaschine.bereit = false;
            default:
                GuiKaffeeMaschine.backgroundButton.setIcon(new ImageIcon(bildPfad + "WMF_Professional_Coffeemachines_Menu_00.jpg"));
                System.out.println(e.getActionCommand());
                break;
        }
    }
}