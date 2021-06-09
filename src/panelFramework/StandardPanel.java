package panelFramework;

import javax.swing.*;

public class StandardPanel extends JFrame {
    public StandardPanel() {

        setTitle("eScooter Berechnung");
        setVisible(true);
        setLocation(430, 100);
        setSize(280,340);
        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("" + "res/logo.png"));
        setIconImage(logo.getImage());
    }

}
