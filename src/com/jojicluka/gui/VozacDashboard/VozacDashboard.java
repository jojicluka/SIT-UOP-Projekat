package com.jojicluka.gui.VozacDashboard;

import com.jojicluka.taxisluzba.TaxiSluzba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VozacDashboard extends JFrame {
    private JButton btnPrikazVoznji = new JButton("Prikaz dodeljenih voznji");
    private JButton btnPrikazVoznjiPrihvacenih = new JButton("Prikaz prihvacenih voznji");
    private JButton btnPrikazVoznjiDodeljenihApp = new JButton("Prikaz dodeljenih voznji aplikacija");
    private JButton btnPrikazPrihvacenihVoznjiApp = new JButton("Prikaz prihvacenih voznji aplikacija");
    private JButton btnAukcija = new JButton("Aukcija");
    private JToolBar toolbar = new JToolBar();

    public VozacDashboard(TaxiSluzba taxiSluzba, String username){
        setTitle("Dashboard za vozaca: " + username);
        setBounds(100,100,1200,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        toolbar.add(btnPrikazVoznji);
        toolbar.add(btnPrikazVoznjiDodeljenihApp);
        toolbar.add(btnPrikazVoznjiPrihvacenih);
        toolbar.add(btnPrikazPrihvacenihVoznjiApp);
        toolbar.add(btnAukcija);
        add(toolbar, BorderLayout.NORTH);

        btnPrikazVoznji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VozacPrikazDodeljenihVoznji vpdv = new VozacPrikazDodeljenihVoznji(taxiSluzba, username);
                vpdv.setVisible(true);
            }
        });

        btnPrikazVoznjiPrihvacenih.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VozacPrikazPrihvacenihVoznji vppv = new VozacPrikazPrihvacenihVoznji(taxiSluzba, username);
                vppv.setVisible(true);
            }
        });

        btnPrikazVoznjiPrihvacenih.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VozacPrikazDodeljenihAppVoznji vpdav = new VozacPrikazDodeljenihAppVoznji(taxiSluzba, username);
                vpdav.setVisible(true);
            }
        });

        btnPrikazPrihvacenihVoznjiApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VozacPrikazPrihvacenihVoznjiApp vppa = new VozacPrikazPrihvacenihVoznjiApp(taxiSluzba, username);
                vppa.setVisible(true);
            }
        });

        btnAukcija.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VozacAukcija va = new VozacAukcija(taxiSluzba, username);
                va.setVisible(true);
            }
        });
    }
}
