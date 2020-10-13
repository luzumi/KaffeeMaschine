/*corat
 *06.10.2020
 *14:03
 *KaffeeMaschine
 */

package gui;

import javax.swing.*;
import java.awt.*;

public class GuiKaffeeMaschine  extends JFrame{

    static ImageIcon ausgangsBild = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\Gui\\Bilder\\WMF_Professional_Coffeemachines_Menu_00.jpg");

    static int sizeWidht = ausgangsBild.getIconWidth();
    static int sizeHight = ausgangsBild.getIconHeight();
    static JPanel mainPanel;
    static JPanel menuPanel;
    static JButton backgroundButton;
    static boolean bereit = true;


    public GuiKaffeeMaschine() throws Exception {

        JPanel panel = createPanel();
        JFrame frame = createFrame();

        frame.setResizable(false);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


    private static JPanel createPanel() throws Exception {

        mainPanel = new JPanel();
        mainPanel.setLayout(new OverlayLayout(mainPanel));

        menuPanel = createMenuPanel(KMGui.invoke());


        backgroundButton = createBackgroundPanel(backgroundButton);
        backgroundButton.setIcon(new ImageIcon(Menu.bildPfad + "WMF_Professional_Coffeemachines_Menu_00.jpg"));

        Container container = createFrame().getContentPane();

        container.add(menuPanel);
        container.add(backgroundButton);


        mainPanel.add(backgroundButton);
        mainPanel.add(container);

        menuPanel.setBounds(0,-150, menuPanel.getWidth(), menuPanel.getHeight());
        menuPanel.setAlignmentX(1f);
        menuPanel.setAlignmentY(0f);

        backgroundButton.setIcon(ausgangsBild);

        backgroundButton.addActionListener(e -> {
            backgroundButton.setIcon(new ImageIcon(Menu.bildPfad + "WMF_Professional_Coffeemachines_Menu_00.jpg"));
            backgroundButton.setEnabled(true);
            backgroundButton.setVisible(false);

            container.setEnabled(true);
            container.setVisible(true);
        });


        return mainPanel;
    }

    private static JButton createBackgroundPanel(JButton jButton) {
        jButton = new JButton("");
        jButton.setAlignmentX(0.00f);
        jButton.setAlignmentY(0.0f);
        jButton.setVisible(true);
        return jButton;
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
        frame.setBackground(Color.BLACK);
        frame.setLocationByPlatform( true );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(sizeWidht, sizeHight));

        return frame;
    }

    private static JPanel createMenuPanel(JPanel panel) throws Exception {
        JPanel jPanel = new JPanel();
        jPanel.setMaximumSize(new Dimension((ausgangsBild.getIconWidth() / 2), ausgangsBild.getIconHeight() / 2));
        jPanel.add(panel);
        jPanel.setLayout(new GridLayout(4, 4));
        jPanel.setSize(sizeWidht, sizeHight);
        jPanel.setLayout(new GridBagLayout());
        jPanel.setVisible(true);

        return jPanel;

    }
}
