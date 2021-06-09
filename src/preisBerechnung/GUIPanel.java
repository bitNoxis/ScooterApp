package preisBerechnung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Scanner;

public class GUIPanel implements ActionListener {
    JTextField tfEingabe, tfPreis, tfErgebnis, tfClock;
    JButton buttonBerechnung;

    double b = 0.3;
    double c = 0;

    public GUIPanel() {
        JFrame f = new JFrame();
        f.setTitle("eScooter Berechnung");
        f.setLocation(430, 100);

        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("" + "res/logo.png"));
        f.setIconImage(logo.getImage());

        Timer t = new Timer(1000, updateClockAction);
        t.start();
        tfClock = new JTextField();
        tfClock.setBounds(40, 10, 185, 20);
        tfClock.setBackground(Color.white);

        tfEingabe = new JTextField();
        tfEingabe.setBounds(50, 50, 150, 20);
        tfEingabe.setUI(new Hint("Gefahrene Kilometer", true));
        tfEingabe.addActionListener(this);

        tfPreis = new JTextField();
        tfPreis.setBounds(50, 100, 150, 20);
        tfPreis.setEditable(false);
        tfPreis.setText("30ct pro Kilometer");

        tfErgebnis = new JTextField();
        tfErgebnis.setBounds(50, 150, 150, 20);
        tfErgebnis.setEditable(false);
        tfErgebnis.setText("Kosten in €");

        new ImageIcon();
        new JLabel();
        JLabel myLabel;

        ImageIcon i = new ImageIcon(this.getClass().getResource("/res/escooter.jpg"));
        myLabel = new JLabel(i);
        myLabel.setSize(300, 300);

        buttonBerechnung = new JButton("Berechne den Preis");
        buttonBerechnung.setBounds(50, 200, 150, 50);
        buttonBerechnung.addActionListener(this);

        f.add(tfEingabe);
        f.add(tfPreis);
        f.add(tfErgebnis);
        f.add(buttonBerechnung);
        f.add(tfClock);
        f.add(myLabel);
        f.setSize(280, 340);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s1 = tfEingabe.getText();
        double a = 0;
        try {
            a = Double.parseDouble(s1);
            tfEingabe.setBackground(Color.white);
        } catch (Exception error) {
            tfEingabe.setText("Fehlerhafte Angabe");
            tfEingabe.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Bitte nur eine Kilometeranzahl im Format wie z.B. 0.75 eingeben.");
            tfEingabe.setBackground(Color.white);
            tfEingabe.setText("");
        }
        if (e.getSource() == buttonBerechnung) {
            c = (a * b);
        }
        String result = String.valueOf(c);
        tfErgebnis.setText(result + ("€"));
    }

    ActionListener updateClockAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            tfClock.setText(new Date().toString());
        }
    };


}
