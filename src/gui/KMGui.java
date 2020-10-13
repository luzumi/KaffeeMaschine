/*corat
 *11.10.2020
 *14:53
 *KaffeeMaschine
 */

package gui;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class KMGui {
    static JPanel menuPanel;
    static JButton[] buttonliste = new JButton[16];
    static JLabel[] jLabels = new JLabel[4];
    static ImageIcon[] imageIcons = new ImageIcon[16];

    static String bildPfad = "E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\Neu\\";
    static String[] buttonTexte = new String[]{"M_O1", "M_O2", "M_O3", "M_O4", "M_KS", "M_KSW", "M_KSWZ", "M_M", "free_1",
            "free_2", "free_3", "M_Kak", "M_U1", "M_U2", "M_U3", "M_U4"};
    static String[] buttonLeerTexte = new String[]{"M_O1_L", "M_O2_L", "M_O3_L", "M_O4_L", "M_KS_L", "M_KSW_L", "M_KSWZ_L",
            "M_M_L", "free_1_L", "free_2_L", "free_3_L", "M_Kak_L", "M_U1_L", "M_U2_L", "M_U3_L", "M_U4_L"};
    static String[] labelTexte = new String[]{"KM_Leer_Links", "KM_Leer_Oben", "KM_Leer_Rechts", "KM_UntenLeer"};


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


    private static void actionPerformed(ActionEvent e) throws Exception {

        switch (e.getActionCommand()) {
            case "M_O1":
                menuNeuZeichnen(buttonLeerTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                System.out.println(e.getActionCommand() + " M_O0 _L");
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
                System.out.println(e.getActionCommand());
                break;
            case "M_KSW":
                menuNeuZeichnen(buttonTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_Unten_KS.jpg"));
                System.out.println(e.getActionCommand());
                break;
            case "M_KSWZ":
                menuNeuZeichnen(buttonTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_Unten_KSZ.jpg"));
                System.out.println(e.getActionCommand());
                break;
            case "M_M":
                menuNeuZeichnen(buttonTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_Unten_Milch.jpg"));
                System.out.println(e.getActionCommand());
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
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_Unten_Kak.jpg"));
                System.out.println(e.getActionCommand());
                break;
            case "M_U1":

            case "M_U2":
                menuNeuZeichnen(buttonLeerTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                System.out.println(e.getActionCommand() + " U 1, 2 _L");
                break;
            case "M_U3":

            case "M_U4":
                menuNeuZeichnen(buttonLeerTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                System.out.println(e.getActionCommand() + bildPfad + buttonTexte[15] + "_L" + ".jpg");
                break;
            default:
                menuNeuZeichnen(buttonTexte);
                jLabels[3].setIcon(new ImageIcon(bildPfad + "KM_UntenLeer.jpg"));
                System.out.println(e.getActionCommand() + " DEFAULT");
        }
    }

    private static void menuNeuZeichnen(String[] texte) {
        for (int i = 0; i < buttonliste.length; i++) {
            buttonliste[i].setIcon(new ImageIcon(bildPfad + texte[i] + ".jpg"));
            buttonliste[i].setActionCommand(texte[i]);
        }
    }
}


