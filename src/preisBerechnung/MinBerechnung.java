package preisBerechnung;

import eröffnungsSeite.OpeningPanel;
import panelFramework.Hint;
import panelFramework.StandardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class MinBerechnung extends StandardPanel implements ActionListener {

    JTextField tfEingabe, tfPreis, tfErgebnis, tfClock;
    JButton buttonBerechnung, buttonzurück;

    double preisProMin = 0.1;
    double c = 0;


    public MinBerechnung() {
        super();

        Timer t = new Timer(1000, updateClockAction);
        t.start();
        tfClock = new JTextField();
        tfClock.setBounds(130, 25, 120, 20);
        tfClock.setBackground(Color.white);

        tfEingabe = new JTextField();
        tfEingabe.setBounds(115, 100, 150, 20);
        tfEingabe.setUI(new Hint("Gefahrene Minuten", false));
        tfEingabe.addActionListener(this);

        tfPreis = new JTextField();
        tfPreis.setBounds(115, 150, 150, 20);
        tfPreis.setEditable(false);
        tfPreis.setText("15ct pro Minute");

        tfErgebnis = new JTextField();
        tfErgebnis.setBounds(115, 200, 150, 20);
        tfErgebnis.setEditable(false);
        tfErgebnis.setText("Kosten in €");

        new JLabel();
        JLabel myLabel;

        ImageIcon i = new ImageIcon(this.getClass().getResource("/res/escooter.jpg"));
        myLabel = new JLabel(i);
        myLabel.setSize(400, 400);

        buttonBerechnung = new JButton("Berechne den Preis");
        buttonBerechnung.setBounds(115, 250, 150, 50);
        buttonBerechnung.addActionListener(this);

        buttonzurück= new JButton("Zurück");
        buttonzurück.setBounds(10,10,90,50);
        buttonzurück.addActionListener(actionzurueck);

        add(tfEingabe);
        add(tfPreis);
        add(tfErgebnis);
        add(buttonBerechnung);
        add(tfClock);
        add(buttonzurück);
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
            c = (a * preisProMin);
        }
        String result = String.valueOf(Math.round(c * 100) / 100.);
        tfErgebnis.setText(result + ("€"));
    }

    ActionListener updateClockAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            tfClock.setText(cutBack(new Date().toString(), " ", 2));
        }
    };

    ActionListener actionzurueck = e -> {
        new OpeningPanel();
        dispose();
    };

    public String cutBack(String txt, String teil, int number) {
        for (int i = 0; i < number; i++) {
            txt = txt.substring(0, txt.lastIndexOf(teil));
        }
        return txt;
    }


}