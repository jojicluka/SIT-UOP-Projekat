package com.jojicluka.gui.DispecerDashboard;

import com.jojicluka.gui.MusterijaDashboard.MusterijaDashboard;
import com.jojicluka.korisnici.Dispecer;
import com.jojicluka.taxisluzba.TaxiSluzba;
import com.jojicluka.voznje.Voznja;
import com.jojicluka.voznje.VoznjaTel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DispecerDashboard extends JFrame {

    private JButton btnPrikazVozaca = new JButton("Prikaz i izmena vozaca");
    private JButton btnPrikazVoznjiTel = new JButton("Prikaz voznji narucene telefonom");
    private JButton btnPrikazVoznjiApp = new JButton("Prikaz voznji narucene aplikacijom");
    private JButton btnPrikazAutomobila = new JButton("Prikaz svih automobila");
    private JButton btnDodelaVoznje = new JButton("Dodeli voznje vozacu");
    private JToolBar toolbar = new JToolBar();
    private JTable tabela;

    private ArrayList<VoznjaTel> voznje = new ArrayList<>();

    public DispecerDashboard(TaxiSluzba taxiSluzba, String username) {
        setTitle("Dashboard za dispecera: " + username);
        setBounds(100,100,1200,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        toolbar.add(btnPrikazVozaca);
        toolbar.add(btnPrikazVoznjiTel);
        toolbar.add(btnPrikazVoznjiApp);
        toolbar.add(btnDodelaVoznje);
        toolbar.add(btnPrikazAutomobila);
        add(toolbar, BorderLayout.NORTH);

        btnPrikazVozaca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DispecerPrikazVozaca dpv = new DispecerPrikazVozaca(taxiSluzba);
                dpv.setVisible(true);
            }
        });

        btnPrikazVoznjiTel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DispecerPrikazVoznjiTel dpvt = new DispecerPrikazVoznjiTel(taxiSluzba);
                dpvt.setVisible(true);
            }
        });

        btnPrikazVoznjiApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DispecerPrikazVoznjiAplikacija dpva = new DispecerPrikazVoznjiAplikacija(taxiSluzba);
                dpva.setVisible(true);
            }
        });

        btnDodelaVoznje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DispecerDodeliVoznju ddvoznju = new DispecerDodeliVoznju(taxiSluzba);
                ddvoznju.setVisible(true);
            }
        });

        btnPrikazAutomobila.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DispecerPrikazAutomobila dpa = new DispecerPrikazAutomobila(taxiSluzba);
                dpa.setVisible(true);
            }
        });
    }

}

