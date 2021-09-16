package com.jojicluka.gui.DispecerDashboard;

import com.jojicluka.automobili.Automobil;
import com.jojicluka.korisnici.Pol;
import com.jojicluka.korisnici.Vozac;
import com.jojicluka.taxisluzba.TaxiSluzba;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DispecerPretragaVozaca extends JFrame {
    private JPanel mainPanel;
    private JTextField imeField;
    private JTextField prezimeField;
    private JTextField plataField;
    Vozac vozac = null;
    private ArrayList<Vozac> trazeniVozaci;

    public DispecerPretragaVozaca(TaxiSluzba taxiSluzba){
        setTitle("Pretrazi vozaca ");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100,100,1000,600);
        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setBorder(new EmptyBorder(3,3,3,3));
        mainPanel.setLayout(null);

        JLabel lblIme = new JLabel("Ime: ");
        lblIme.setBounds(20,50,150,40);
        lblIme.setFont(new Font("Helvetica Neue", Font.BOLD,14));
        mainPanel.add(lblIme);

        imeField = new JTextField();
        imeField.setColumns(8);
        imeField.setBounds(160,50, 200,40);
        mainPanel.add(imeField);

        JLabel lblPrezime = new JLabel("Prezime: ");
        lblPrezime.setBounds(20,100,150,40);
        lblPrezime.setFont(new Font("Helvetica Neue", Font.BOLD,14));
        mainPanel.add(lblPrezime);

        prezimeField = new JTextField();
        prezimeField.setColumns(8);
        prezimeField.setBounds(160,100, 200,40);
        mainPanel.add(prezimeField);

        JLabel lblAutomobil = new JLabel("Automobil: ");
        lblAutomobil.setBounds(20,200,150,40);
        lblAutomobil.setFont(new Font("Helvetica Neue", Font.BOLD,14));
        mainPanel.add(lblAutomobil);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel());
        comboBox.setBounds(160,200,200,40);
        comboBox.setFont(new Font("Helvetica Neue", Font.BOLD,14));
        comboBox.setMaximumRowCount(100);
        mainPanel.add(comboBox);
        comboBox.addItem("Izbor automobila");

        for (Automobil automobil: taxiSluzba.getAutomobili()){
            comboBox.addItem(automobil.getBrTablica());
        }

        JLabel lblPlata = new JLabel("Plata: ");
        lblPlata.setBounds(20,150,150,40);
        lblPlata.setFont(new Font("Helvetica Neue", Font.BOLD,14));
        mainPanel.add(lblPlata);

        plataField = new JTextField();
        plataField.setColumns(8);
        plataField.setBounds(160,150, 200,40);
        mainPanel.add(plataField);

        JButton btnPretrazi = new JButton("Pretrazi");
        btnPretrazi.setBounds(400,520,150,40);
        btnPretrazi.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        mainPanel.add(btnPretrazi);

        btnPretrazi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ime = imeField.getText();
                String prezime = prezimeField.getText();
                int plata = Integer.parseInt(plataField.getText());
                int idVozila = -1;

                //if(!comboBox.equals("Izbor automobila")){
                //    idVozila = Integer.parseInt(comboBox.getSelectedItem().toString());
               // }

                vozac = new Vozac(ime,prezime,plata,idVozila);
                ArrayList<Vozac> trazeniVozaci = taxiSluzba.kombinovanaPretraga(vozac);

                DispecerPrikazPretrazenihVozaca dppv = new DispecerPrikazPretrazenihVozaca(trazeniVozaci);
                dppv.setVisible(true);
            }
        });
    }
}
