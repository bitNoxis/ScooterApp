package start;

import panelFramework.StandardPanel;
import preisBerechnung.GUIPanel;
import javax.swing.*;
import java.awt.event.*;

public class StartPanel extends StandardPanel implements ActionListener {

    JLabel welcomeLabel;
    JButton buttonZuBerechnung;

    JFrame initframe() {
        f.add(welcomeLabel);
        f.add(buttonZuBerechnung);
        buttonZuBerechnung.addActionListener(buttonCLickBerechnung);
        return f;
    }


    public void actionPerformed(ActionEvent e) {
        new GUIPanel();
    }
};


