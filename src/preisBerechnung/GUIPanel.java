package preisBerechnung;

import panelFramework.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;


public class GUIPanel extends StandardPanel implements ActionListener {

    JTextField tfEingabe, tfPreis, tfErgebnis, tfClock;
    JButton buttonBerechnung;

    double normalerPreis = 0.3;
    double c = 0;


    public GUIPanel() {
        super();

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

        new JLabel();
        JLabel myLabel;

        ImageIcon i = new ImageIcon(this.getClass().getResource("/res/escooter.jpg"));
        myLabel = new JLabel(i);
        myLabel.setSize(300, 300);

        buttonBerechnung = new JButton("Berechne den Preis");
        buttonBerechnung.setBounds(50, 200, 150, 50);
        buttonBerechnung.addActionListener(this);

        add(tfEingabe);
        add(tfPreis);
        add(tfErgebnis);
        add(buttonBerechnung);
        add(tfClock);
        add(myLabel);
        setLayout(null);
        setVisible(true);
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
            c = (a * normalerPreis);
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
