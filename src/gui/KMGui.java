/*corat
 *11.10.2020
 *14:53
 *KaffeeMaschine
 */

package gui;

import kaffeemaschine.AbfallBehaelterVollException;
import kaffeemaschine.Kaffeemaschine;
import kaffeemaschine.ZutatLeerException;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class KMGui {
    private static JPanel menuPanel;

    private static JButton menuAusgaben = new JButton();
    private static JButton[] buttonliste = new JButton[16];
    private static JLabel[] jLabels = new JLabel[4];

    private static ImageIcon textLabel = new ImageIcon(".\\src\\gui\\Bilder\\Neu\\menuBlanco.jpg");
    private static ImageIcon[] imageIcons = new ImageIcon[16];

    private static String bildPfad = ".\\src\\gui\\Bilder\\Neu\\";
    private static String[] buttonTexte = new String[]{"M_O1", "M_O2", "M_O3", "M_O4", "M_KS", "M_KSW", "M_KSWZ", "M_M", "free_1",
            "free_2", "free_3", "M_Kak", "M_U1", "M_U2", "M_U3", "M_U4"};
    private static String[] buttonLeerTexte = new String[]{"M_O1_L", "M_O2_L", "M_O3_L", "M_O4_L", "M_KS_L", "M_KSW_L", "M_KSWZ_L",
            "M_M_L", "free_1_L", "free_2_L", "free_3_L", "M_Kak_L",
            "M_U1_L", "M_U2_L", "M_U3_L", "M_U4_L"};
    private static String[] labelTexte = new String[]{"KM_Leer_Links", "KM_Leer_Oben", "KM_Leer_Rechts", "KM_UntenLeer"};


    private static Graphics g;


    public static JPanel invoke() {
        legeButtonsAn("");
        erstelleJlabels();

        JPanel gesamtPanel = new JPanel();
        JPanel obenGesamtPanel = new JPanel();

        menuPanel = createMenuPanel();

        JPanel mitteObenPanel = new JPanel();
        mitteObenPanel.setLayout(new BorderLayout());
        mitteObenPanel.add(jLabels[1], BorderLayout.NORTH);
        mitteObenPanel.add(menuPanel, BorderLayout.CENTER);

        obenGesamtPanel.setLayout(new BorderLayout());
        obenGesamtPanel.add(jLabels[0], BorderLayout.WEST);
        obenGesamtPanel.add(mitteObenPanel, BorderLayout.CENTER);
        obenGesamtPanel.add(jLabels[2], BorderLayout.EAST);

        gesamtPanel.setLayout(new BorderLayout());
        gesamtPanel.add(obenGesamtPanel, BorderLayout.NORTH);
        gesamtPanel.add(jLabels[3], BorderLayout.CENTER);

        return gesamtPanel;
    }


    private static void legeButtonsAn(String zusatz) {
        createAndSetIcons(bildPfad, zusatz);
        for (int i = 0; i < buttonliste.length; i++) {
            buttonliste[i] = new JButton();
            buttonliste[i].setBorder(new CompoundBorder(null, null));
            buttonliste[i].setActionCommand(buttonTexte[i] + zusatz);
            buttonliste[i].setIcon(imageIcons[i]);
            buttonliste[i].setSize(setSizeFromOriginal(buttonliste[i]));
            buttonliste[i].addActionListener(e -> {
                try {
                    actionPerformed(e);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });
        }
    }


    private static JPanel createMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.add(createRowPanel(1, 0));
        menuPanel.add(createRowPanel(2, 4));
        menuPanel.add(createRowPanel(3, 8));
        menuPanel.add(createRowPanel(4, 12));

        return menuPanel;
    }


    private static void erstelleJlabels() {

        for (int i = 0; i < jLabels.length; i++) {
            jLabels[i] = new JLabel();
            jLabels[i].setBorder(new CompoundBorder(null, null));
            jLabels[i].setIcon(new ImageIcon(bildPfad + labelTexte[i] + ".jpg"));
            jLabels[i].setSize(setSizeFromOriginal(jLabels[i]));
        }
    }


    private static JPanel createRowPanel(int rows, int startButton) {

        JPanel menuRow1Panel = new JPanel();

        menuRow1Panel.setLayout(new BoxLayout(menuRow1Panel, BoxLayout.X_AXIS));
        menuRow1Panel.setSize(4 * buttonliste[startButton].getWidth(), buttonliste[0].getHeight());

        for (int i = startButton; i < 4 * rows; i++) {
            menuRow1Panel.add(buttonliste[i]);
        }

        menuRow1Panel.setVisible(true);

        return menuRow1Panel;
    }


    public static JFrame createFrame() {
        JFrame frame = new JFrame("OverlayLayout Example");
        frame.setBackground(Color.BLACK);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return frame;
    }


    private static Dimension setSizeFromOriginal(JButton button) {
        return new Dimension(button.getIcon().getIconWidth() / 2, button.getIcon().getIconHeight() / 2);
    }


    private static Dimension setSizeFromOriginal(JLabel button) {
        return new Dimension(button.getIcon().getIconWidth() / 2, button.getIcon().getIconHeight() / 2);
    }


    private static void createAndSetIcons(String bildPfad, String zusatz) {
        for (int i = 0; i < imageIcons.length; i++) {
            try {
                imageIcons[i] = new ImageIcon(bildPfad + buttonTexte[i] + zusatz + ".jpg");
                System.out.println(bildPfad + buttonTexte[i] + zusatz + ".jpg");
            } catch (NullPointerException e) {
                e.getMessage();
            }
        }
    }


    private static void actionPerformed(ActionEvent e) throws AbfallBehaelterVollException, ZutatLeerException {

        switch (e.getActionCommand()) {
            case "M_O1":
                MenuSchreiber.schreibeInfoMenuItem(buttonLeerTexte, buttonliste);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                break;
            case "M_O2":
                menuNeuZeichnen(buttonLeerTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                System.out.println(e.getActionCommand() + " M_O1 _L");
                break;
            case "M_O3":
                menuNeuZeichnen(buttonLeerTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                System.out.println(e.getActionCommand() + " M_O2 _L");
                break;
            case "M_O4":
                menuNeuZeichnen(buttonLeerTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                System.out.println(e.getActionCommand() + " M_O3 _L");
                break;
            case "M_KS":
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_Unten_K.jpg"));
                menuNeuZeichnen(buttonTexte);
                Kaffeemaschine.zutatenEntnahme(1);
                break;
            case "M_KSW":
                menuNeuZeichnen(buttonTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_Unten_KS.jpg"));
                Kaffeemaschine.zutatenEntnahme(2);
                break;
            case "M_KSWZ":
                menuNeuZeichnen(buttonTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_Unten_KSZ.jpg"));
                Kaffeemaschine.zutatenEntnahme(3);
                break;
            case "M_M":
                menuNeuZeichnen(buttonTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_Unten_Milch.jpg"));
                Kaffeemaschine.zutatenEntnahme(4);
                break;
            case "free_1":
                menuNeuZeichnen(buttonLeerTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                System.out.println(e.getActionCommand() + " Free 1 _L");
                break;
            case "free_2":
                menuNeuZeichnen(buttonLeerTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                System.out.println(e.getActionCommand() + " Free 2 _L");
                break;
            case "free_3":
                menuNeuZeichnen(buttonLeerTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                System.out.println(e.getActionCommand() + " Free 3 _L");
                break;
            case "M_Kak":
                menuNeuZeichnen(buttonTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                Kaffeemaschine.zutatenEntnahme(5);
                break;
            case "M_U1":
                menuNeuZeichnen(buttonLeerTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                Kaffeemaschine.zutatenEntnahme(9);
                System.out.println(e.getActionCommand() + " U 1, 2 _L");
                break;
            case "M_U2":
                menuNeuZeichnen(buttonLeerTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                Kaffeemaschine.zutatenEntnahme(9);
                System.out.println(e.getActionCommand() + " U 2, 2 _L");
                break;
            case "M_U3":
                menuNeuZeichnen(buttonLeerTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                Kaffeemaschine.zutatenEntnahme(9);
                System.out.println(e.getActionCommand() + " U 3, 2 _L");
                break;

            case "M_U4":
                menuNeuZeichnen(buttonLeerTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                Kaffeemaschine.zutatenEntnahme(10);
                break;
            default:
                menuNeuZeichnen(buttonTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                System.out.println(e.getActionCommand() + " DEFAULT");
        }
    }

    public static void menuNeuZeichnen(String[] texte) {
        for (int i = 0; i < buttonliste.length; i++) {
            buttonliste[i].setIcon(new ImageIcon(bildPfad + texte[i] + ".jpg"));
            buttonliste[i].setActionCommand(texte[i]);
            buttonliste[i].setVisible(true);

        }
    }


    public static String[] getButtonTexte() {
        return buttonTexte;
    }

    public static String[] getButtonLeerTexte() {
        return buttonLeerTexte;
    }

    public static ImageIcon getTextLabel() {
        return textLabel;
    }

    public static void setTextLabel(ImageIcon textLabel) {
        KMGui.textLabel = textLabel;
    }

    public static JButton getMenuAusgaben() {
        return menuAusgaben;
    }

    public static void setMenuAusgaben(JButton menuAusgaben) {
        KMGui.menuAusgaben = menuAusgaben;
    }

    public static JButton[] getButtonliste() {
        return buttonliste;
    }

    public static void setButtonliste(JButton[] buttonliste) {
        KMGui.buttonliste = buttonliste;
    }

    public static ImageIcon[] getImageIcons() {
        return imageIcons;
    }

    public static void setImageIcons(ImageIcon[] imageIcons) {
        KMGui.imageIcons = imageIcons;
    }
}


