package com.jojicluka.gui.MusterijaDashboard;

import com.jojicluka.korisnici.Musterija;
import com.jojicluka.taxisluzba.TaxiSluzba;
import com.jojicluka.voznje.NacinPorucivanja;
import com.jojicluka.voznje.StatusVoznje;
import com.jojicluka.voznje.VoznjaApp;
import com.jojicluka.voznje.VoznjaTel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MusterijaNaruciApp extends JFrame {
    private JPanel mainPanel;
    private JTextField adresaPolaskaField;
    private JTextField adresaDestinacijeField;
    private JTextField opisField;
    private JButton btnNaruci;

    public MusterijaNaruciApp(TaxiSluzba taxiSluzba, String username){
        setTitle("Naruci voznju putem aplikacije");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250,250,750,350);

        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setLayout(null);
        mainPanel.setBorder(new EmptyBorder(3,3,3,3));

        JLabel lblAp = new JLabel("Unos adrese polaska: ");
        lblAp.setBounds(75, 40, 180, 40);
        lblAp.setFont(new Font("Helvetica neue", Font.BOLD, 14));
        mainPanel.add(lblAp);

        adresaDestinacijeField = new JTextField();
        adresaDestinacijeField.setColumns(12);
        adresaDestinacijeField.setBounds(300,90,300,40);
        mainPanel.add(adresaDestinacijeField);

        JLabel lblAd = new JLabel("Unos adrese destinacije: ");
        lblAd.setBounds(75, 90, 180, 40);
        lblAd.setFont(new Font("Helvetica neue", Font.BOLD, 14));
        mainPanel.add(lblAd);

        adresaPolaskaField = new JTextField();
        adresaPolaskaField.setColumns(12);
        adresaPolaskaField.setBounds(300,40,300,40);
        mainPanel.add(adresaPolaskaField);

        JLabel lblOpis = new JLabel("Napomena: ");
        lblOpis.setBounds(75, 140, 180, 40);
        lblOpis.setFont(new Font("Helvetica neue", Font.BOLD, 14));
        mainPanel.add(lblOpis);

        opisField = new JTextField();
        opisField.setColumns(12);
        opisField.setBounds(300,140,300,40);
        mainPanel.add(opisField);

        btnNaruci = new JButton("Naruci");
        btnNaruci.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        btnNaruci.setBounds(300,220,150,75);
        mainPanel.add(btnNaruci);


        btnNaruci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String adresaPolaska = adresaPolaskaField.getText();
                String adresaDestinacije = adresaDestinacijeField.getText();
                if (adresaPolaska.equals("") || adresaDestinacije.equals("")) {
                    System.out.println("Unesite sve podatke!");
                }
                int idInt = 0;
                for (VoznjaApp voznjaApp : taxiSluzba.getVoznjeApp()) {
                    if (idInt <= Integer.parseInt(voznjaApp.getId())) {
                        idInt = (Integer.parseInt(voznjaApp.getId()) + 1);
                    }
                }
                String id = String.valueOf(idInt);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date datum = new Date();
                String datumString = format.format(datum);
                StatusVoznje statusVoznje = StatusVoznje.KREIRANA_NA_CEKANJU;
                Musterija musterija = taxiSluzba.nadjiMusteriju(username);
                String napomena = opisField.getText();

                VoznjaApp narucenaVoznja = new VoznjaApp(id, datumString, adresaPolaska, adresaDestinacije, musterija, null, 0, 0, statusVoznje, true, musterija.getId(), "0", NacinPorucivanja.APLIKACIJA, napomena);
                taxiSluzba.getVoznjeApp().add(narucenaVoznja);
                taxiSluzba.saveVoznjeApp();
                JOptionPane.showMessageDialog(null, "Narudzbina poslata!", "NARUDZBINA APLIKACIJOM POSLATA", JOptionPane.INFORMATION_MESSAGE);
            }
        });

    }
}
