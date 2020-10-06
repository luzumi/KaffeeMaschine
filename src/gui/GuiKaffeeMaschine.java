/*corat
 *06.10.2020
 *14:03
 *KaffeeMaschine
 */

package gui;

import javax.swing.*;
import java.awt.*;

public class GuiKaffeeMaschine {
    static ImageIcon betriebsBereitImage = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\Gui\\Bilder\\WMF_Professional_Coffeemachines_Betriebspause_00.jpg");

    public GuiKaffeeMaschine(String[] args) {

        JPanel panel = createPanel();
        JFrame frame = createFrame();
        frame.add(panel);
        frame.setVisible(true);
    }

    private static JPanel createPanel() {

        JPanel mainPanel = new JPanel();
        mainPanel.setSize(betriebsBereitImage.getIconWidth(), betriebsBereitImage.getIconHeight());
        mainPanel.setLayout(new OverlayLayout(mainPanel));


        JButton button = new JButton("");
        //button.setAlignmentX(0.5f);
        //button.setAlignmentY(0.5f);

        JPanel popupPanel = createPopupPanel(button);
        popupPanel.setSize(304, 459);

        //popupPanel.setAlignmentX(0.1f);
        //popupPanel.setAlignmentY(0.1f);

        button.addActionListener(e -> {
            button.setEnabled(false);
            popupPanel.setVisible(true);
        });

        JLabel backgroundPaper = new JLabel("");

        mainPanel.add(popupPanel);
        button.setIcon(betriebsBereitImage);
        mainPanel.add(button);
        //mainPanel.add(backgroundPaper);

        return mainPanel;
    }

    private static JPanel createPopupPanel(JComponent overlapComponent) {
        ImageIcon menuIcon = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\Gui\\Bilder\\WMF_Professional_Coffeemachines_Menu_00.jpg");
        //popupPanel.setOpaque(true);
        JPanel popupPanel = new JPanel();
        popupPanel.setSize(menuIcon.getIconWidth(), menuIcon.getIconHeight());
        popupPanel.setLayout(new OverlayLayout(popupPanel));

        popupPanel.setVisible(false);

        JButton popupCloseButton = new JButton("");
        popupCloseButton.setIcon(menuIcon);
        popupPanel.add(popupCloseButton);

        popupCloseButton.addActionListener(e -> {
            overlapComponent.setEnabled(true);
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
        frame.setSize(new Dimension(betriebsBereitImage.getIconWidth(), betriebsBereitImage.getIconHeight()));

        return frame;
    }

    private static JPanel createMenu() {
        JPanel jPanel = new JPanel();

        Menu.invoke();
        JPanel menuOben = new JPanel(new BorderLayout());
        menuOben.add(Menu.jbtnMenu);
        menuOben.add(Menu.jbtnObenrechts);


        return jPanel;
    }
}
