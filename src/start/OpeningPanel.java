package start;

import panelFramework.StandardPanel;
import preisBerechnung.GUIPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class OpeningPanel implements ActionListener {

    StandardPanel f = new StandardPanel();
    JLabel labelWelcome = new JLabel("<html>Hallo und Willkommen<br>bei ScoooteQ</html>", SwingConstants.CENTER);
    JButton buttonZuBerechnung = new JButton("Zur Peisberechnung");

    ImageIcon i = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/res/escooter.jpg")));
    ImageIcon logo = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/res/logo.png")));
    ImageIcon iconinfo = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/res/iconButton.png")));
    JButton buttonInfo = new JButton(iconinfo);


    public OpeningPanel() {
        initframe();
    }

    JFrame initframe() {

        buttonZuBerechnung.setBounds(90, 250, 200, 50);
        buttonZuBerechnung.addActionListener(this);
        buttonInfo.setBounds(320, 10, 50, 50);
        buttonInfo.addActionListener(info);
        labelWelcome.setBounds(70, 100, 250, 100);
        labelWelcome.setForeground(Color.WHITE);
        labelWelcome.setFont(new Font("Arial", Font.BOLD, 20));

        new JLabel();
        JLabel myLabel2;
        myLabel2 = new JLabel(logo);
        myLabel2.setSize(40, 40);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        new GUIPanel();
        f.dispose();
    }

    ActionListener info = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,
                    "Infoinfoinfo");
        }
    };

}



