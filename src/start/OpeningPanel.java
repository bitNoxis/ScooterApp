package start;

import panelFramework.StandardPanel;
import preisBerechnung.GUIPanel;

import javax.swing.*;
import java.awt.event.*;

public class OpeningPanel implements ActionListener {

    JLabel welcomeLabel = new JLabel("Hallo und Willkommen bei ScoooteQ",SwingConstants.CENTER);
    JButton buttonZuBerechnung = new JButton("Zur Peisberechnung");
    StandardPanel f = new StandardPanel();

    public OpeningPanel() {
        initframe();
    }

    JFrame initframe() {

        buttonZuBerechnung.setBounds(30, 200, 200, 50);
        buttonZuBerechnung.addActionListener(this);

        welcomeLabel.setBounds(50, 10, 150, 20);

        f.add(buttonZuBerechnung);
        f.add(welcomeLabel);
        f.setVisible(true);

        return f;
    }

    public void actionPerformed(ActionEvent e) {
        new GUIPanel();
        f.setVisible(false);
    }
};



