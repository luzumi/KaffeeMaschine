/*corat
 *06.10.2020
 *14:03
 *KaffeeMaschine
 */

package gui;

import javax.swing.*;
import java.awt.*;

public class GuiKaffeeMaschine extends JFrame {
    static ImageIcon ausgangsBild = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\Gui\\Bilder\\WMF_Professional_Coffeemachines_Menu_00.jpg");
    static int sizeWidht = ausgangsBild.getIconWidth();
    static int sizeHight = ausgangsBild.getIconHeight();
    static JPanel mainPanel;
    static JPanel popupPanel;
    static JButton button;
    static boolean bereit = true;


    public GuiKaffeeMaschine(String[] args) throws Exception {


        JPanel panel = createPanel();
        JFrame frame = createFrame();
        frame.setResizable(false);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    private static JPanel createPanel() throws Exception {
        Container container = new Container();

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(sizeWidht * 21, sizeHight * 21));
        mainPanel.setLayout(new OverlayLayout(mainPanel));


        popupPanel = createPopupPanel();
        popupPanel.setLayout(new GridLayout(4, 4));
        popupPanel.setSize(sizeWidht, sizeHight);
        popupPanel = createMenu();
        popupPanel.setLayout(new GridBagLayout());
        popupPanel.setEnabled(false);
        popupPanel.setVisible(false);

        button = new JButton("");
        button.setAlignmentX(0.00f);
        button.setAlignmentY(0.0f);


        mainPanel.add(button);
        mainPanel.add(popupPanel);

        popupPanel.setBounds(220,0, popupPanel.getWidth(), popupPanel.getHeight());
        popupPanel.setAlignmentX(0f);
        popupPanel.setAlignmentY(0f);

        button.setIcon(ausgangsBild);

        JPanel finalPopupPanel = popupPanel;
        button.addActionListener(e -> {
            button.setEnabled(false);
            button.setVisible(false);
            finalPopupPanel.setEnabled(true);
            finalPopupPanel.setVisible(true);
        });


        return mainPanel;
    }


    private static JPanel createPopupPanel(/*JComponent overlapComponent*/) throws Exception {
        ImageIcon menuIcon = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\Gui\\Bilder\\WMF_Professional_Coffeemachines_Menu_00.jpg");
        JPanel popupPanel = Menu.invoke();
        JButton popupCloseButton = new JButton("");
        popupPanel.setOpaque(true);
        popupPanel.setSize(ausgangsBild.getIconWidth(), ausgangsBild.getIconHeight());
        popupPanel.setLayout(new OverlayLayout(wrapInPanel(popupCloseButton)));

        popupPanel.setVisible(false);

        popupCloseButton.addActionListener(e -> {
            popupCloseButton.setEnabled(true);
            popupPanel.setVisible(false);
        });

        return popupPanel;
    }

    private static JPanel wrapInPanel(JComponent component) {
        JPanel jPanel = new JPanel();
        jPanel.setLocation(0, 0);
        jPanel.setBackground(new Color(250, 210, 250, 150));
        jPanel.add(component);
        return jPanel;
    }


    private static JFrame createFrame() {
        JFrame frame = new JFrame("OverlayLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(ausgangsBild.getIconWidth(), ausgangsBild.getIconHeight()));

        return frame;
    }

    private static JPanel createMenu() throws Exception {
        JPanel jPanel = new JPanel();
        jPanel.setMaximumSize(new Dimension((ausgangsBild.getIconWidth() / 2), ausgangsBild.getIconHeight() / 2));
        jPanel.add(Menu.invoke());

        jPanel.setVisible(false);


        return jPanel;

    }
}
