package start;

import panelFramework.StandardPanel;
import preisBerechnung.GUIPanel;
import javax.swing.*;
import java.awt.event.*;

public class StartPanel extends StandardPanel implements ActionListener {

    JLabel welcomeLabel;
    JButton buttonZuBerechnung;

    public StartPanel() {
        super();

        buttonZuBerechnung = new JButton("Zur Peisberechnung");
        buttonZuBerechnung.setBounds(200, 150, 100, 50);
        buttonZuBerechnung.addActionListener(this);

        welcomeLabel = new JLabel("Hallo und Willkommen bei ScoooteQ");
        welcomeLabel.setBounds(50, 10, 150, 100);

        add(buttonZuBerechnung);
        add(welcomeLabel);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        new GUIPanel();
    }
};


