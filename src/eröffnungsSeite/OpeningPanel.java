package eröffnungsSeite;

import panelFramework.StandardPanel;
import preisBerechnung.KmBerechnung;
import preisBerechnung.MinBerechnung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class OpeningPanel implements ActionListener {

    StandardPanel f = new StandardPanel();
    JLabel labelWelcome = new JLabel("<html>Hallo und Willkommen<br>bei ScoooteQ</html>", SwingConstants.CENTER);
    JButton buttonZuKmBerechnung = new JButton("Peisberechnung in Kilometern");
    JButton buttonZurMinBerechnung = new JButton("Preisberechnung in Minuten");

    ImageIcon i = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/res/escooter.jpg")));
    ImageIcon l = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/res/logo.png")));
    ImageIcon iconinfo = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/res/iconButton.png")));
    JButton buttonInfo = new JButton(iconinfo);
    JButton logoInfo = new JButton(l);


    public OpeningPanel() {
        initframe();
    }

    JFrame initframe() {

        buttonZuKmBerechnung.setBounds(85, 250, 210, 30);
        buttonZuKmBerechnung.addActionListener(this);

        buttonZurMinBerechnung.setBounds(85, 290, 210, 30);
        buttonZurMinBerechnung.addActionListener(zurMinBerechnung);

        buttonInfo.setBounds(320, 10, 50, 50);
        buttonInfo.addActionListener(info);

        logoInfo.setBounds(10, 10, 50, 50);
        logoInfo.addActionListener(logo);

        labelWelcome.setBounds(90, 60, 300, 200);
        labelWelcome.setForeground(Color.WHITE);
        labelWelcome.setFont(new Font("Arial", Font.BOLD, 30));

        new JLabel();
        JLabel myLabel2;
        myLabel2 = new JLabel(l);
        myLabel2.setSize(40, 40);

        new JLabel();
        JLabel myLabel;
        myLabel = new JLabel(i);
        myLabel.setSize(400, 400);

        f.add(buttonInfo);
        f.add(logoInfo);
        f.add(buttonZuKmBerechnung);
        f.add(buttonZurMinBerechnung);
        f.add(labelWelcome);
        f.add(myLabel);
        f.setVisible(true);

        return f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new KmBerechnung();
        f.dispose();
    }

    ActionListener zurMinBerechnung = e ->  {
        new MinBerechnung();
        f.dispose();
    };

    ActionListener info = e -> JOptionPane.showMessageDialog(null,
            "Infoinfoinfo");

    ActionListener logo = e -> JOptionPane.showMessageDialog(null,
            "Wir sind ScooteQ und wir werden deine Mobilität revolutionieren!");

}



