package start;

import com.sun.xml.internal.bind.api.impl.NameConverter;
import panelFramework.StandardPanel;
import preisBerechnung.GUIPanel;

import javax.swing.*;
import java.awt.event.*;

public class StartPanel extends StandardPanel {
    JLabel welcomeLabel = new JLabel("Hallo und Willkommen bei ScoooteQ");
    JButton buttonZuBerechnung = new JButton();
    StandardPanel f = new StandardPanel();

    public StartPanel() {
        initframe();
    }

    JFrame initframe() {
        f.add(welcomeLabel);
        f.add(buttonZuBerechnung);
        buttonZuBerechnung.addActionListener(buttonCLickBerechnung);
        return f;
    }


    ActionListener buttonCLickBerechnung = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new GUIPanel();
        }
    };

}
