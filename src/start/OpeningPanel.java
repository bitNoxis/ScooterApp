package start;

import panelFramework.StandardPanel;
import preisBerechnung.GUIPanel;

import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class OpeningPanel implements ActionListener {

    StandardPanel f = new StandardPanel();
    JLabel labelWelcome = new JLabel("Hallo und Willkommen bei ScoooteQ", SwingConstants.CENTER);
    JButton buttonZuBerechnung = new JButton("Zur Peisberechnung");

    ImageIcon i = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/res/background.jpg")));
    ImageIcon iconinfo = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/res/iconButton.png")));
    JButton buttonInfo = new JButton(iconinfo);


    public OpeningPanel() {
        initframe();
    }

    JFrame initframe() {

        buttonZuBerechnung.setBounds(30, 200, 200, 50);
        buttonZuBerechnung.addActionListener(this);
        buttonInfo.setBounds(20, 300, 50, 50);
        buttonInfo.addActionListener(info);
        labelWelcome.setBounds(50, 10, 150, 20);

        new JLabel();
        JLabel myLabel;
        myLabel = new JLabel(i);
        myLabel.setSize(400, 400);

        f.add(buttonInfo);
        f.add(buttonZuBerechnung);
        f.add(labelWelcome);
        f.add(myLabel);
        f.setVisible(true);


        return f;
    }

    public void actionPerformed(ActionEvent e) {
        new GUIPanel();
        f.setVisible(false);
    }
};



