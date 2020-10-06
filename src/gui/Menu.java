/*corat
 *06.10.2020
 *17:56
 *KaffeeMaschine
 */

package gui;

import javax.swing.*;

public class Menu {

    static JButton jbtnlinks, jbtnMenu, jbtnObenrechts, jbtnKaffeeSchwarz, jbtnKaffeeSchwarzWeiss, jbtnKaffeeSchwarzWeissZucker, jbtnMilch,
            jbtnrechts, jbtnKakao, jbtnfree1, jbtnfree2, jbtnfree3, jbtnWartung, jbtninfo;

    public static void invoke() {
        ImageIcon linksImage = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\blanko_Links.jpg");
        ImageIcon menuImage = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\button_Menu.jpg");
        ImageIcon obenrechtsImage = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\blanko_ObenRechts.jpg");
        ImageIcon kaffeeSchwarz = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\Button_KaffeeSchwarz.jpg");
        ImageIcon kaffeeSchwarzWeiss = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\Button_KaffeeSchwarzWeiss.jpg");
        ImageIcon kaffeeSchwarzWeissZucker = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\Button_KaffeeSchwarzWeissZucker.jpg");
        ImageIcon milch = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\Button_Milch.jpg");
        ImageIcon rechts = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\blanko_Rechts.jpg");
        ImageIcon kakao = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\Button_Kakao.jpg");
        ImageIcon free1 = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\Button_Free1.jpg");
        ImageIcon free2 = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\Button_Free2.jpg");
        ImageIcon free3 = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\Button_Free3.jpg");
        ImageIcon wartung = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\Button_Wartung.jpg");
        ImageIcon info = new ImageIcon("E:\\intelliJ-Workspace\\KaffeeMaschine\\src\\gui\\Bilder\\Button_Info.jpg");

        jbtnKaffeeSchwarzWeissZucker = new JButton("");
        jbtnKaffeeSchwarz.setIcon(kaffeeSchwarzWeissZucker);

        jbtnMilch = new JButton("");
        jbtnKaffeeSchwarz.setIcon(milch);

        jbtnrechts = new JButton("");
        jbtnKaffeeSchwarz.setIcon(rechts);

        jbtnKakao = new JButton("");
        jbtnKaffeeSchwarz.setIcon(kakao);

        jbtnfree1 = new JButton("");
        jbtnKaffeeSchwarz.setIcon(free1);

        jbtnfree2 = new JButton("");
        jbtnKaffeeSchwarz.setIcon(free2);

        jbtnfree3 = new JButton("");
        jbtnKaffeeSchwarz.setIcon(free3);

        jbtnWartung = new JButton("");
        jbtnKaffeeSchwarz.setIcon(wartung);

        jbtninfo = new JButton("");
        jbtnKaffeeSchwarz.setIcon(info);
        jbtnlinks = new JButton("");
        jbtnlinks.setIcon(linksImage);

        jbtnMenu = new JButton("");
        jbtnMenu.setIcon(menuImage);

        jbtnObenrechts = new JButton("");
        jbtnObenrechts.setIcon(obenrechtsImage);

        jbtnKaffeeSchwarz = new JButton("");
        jbtnKaffeeSchwarz.setIcon(kaffeeSchwarz);

        jbtnKaffeeSchwarzWeiss = new JButton("");
        jbtnKaffeeSchwarz.setIcon(kaffeeSchwarzWeiss);
    }
}