package com.jojicluka.gui;


import com.jojicluka.taxisluzba.TaxiSluzba;
import com.jojicluka.gui.DispecerLogin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.FieldPosition;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Login extends JFrame {


    private JLabel lblTitle = new JLabel("TAXI SLUZBA");
    private JLabel lblMusterija = new JLabel("Musterija");
    private JLabel lblVozac = new JLabel("Vozac");
    private JLabel lblDispecer = new JLabel("Dispecer");
    private ImageIcon iconMusterija = new ImageIcon("src/com/jojicluka/png/musterija.png");
    private JButton btnMusterija = new JButton(iconMusterija);
    private ImageIcon iconVozac = new ImageIcon("src/com/jojicluka/png/vozac.png");
    private JButton btnVozac = new JButton(iconVozac);
    private ImageIcon iconDispecer = new ImageIcon("src/com/jojicluka/png/dispecer.png");
    private JButton btnDispecer = new JButton(iconDispecer);
    private JPanel mainPanel;

    public Login(TaxiSluzba taxiSluzba){
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,725,475);
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(3,3,3,3));
        setContentPane(mainPanel);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(null);

        btnDispecer.setBounds(60,180,150,150);
        btnDispecer.setBackground(Color.WHITE);
        mainPanel.add(btnDispecer);
        btnMusterija.setBounds(270,180,150,150);
        btnMusterija.setBackground(Color.WHITE);
        mainPanel.add(btnMusterija);
        btnVozac.setBounds(480,180,150,150);
        btnVozac.setBackground(Color.WHITE);
        mainPanel.add(btnVozac);

        lblTitle.setBounds(220, 80, 300, 50);
        lblTitle.setFont(new Font("Helvetica Neue", Font.BOLD, 40));
        mainPanel.add(lblTitle);
        lblDispecer.setBounds(95,340,100,60);
        lblDispecer.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        mainPanel.add(lblDispecer);
        lblMusterija.setBounds(305,340,100,60);
        lblMusterija.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        mainPanel.add(lblMusterija);
        lblVozac.setBounds(525,340,100,60);
        lblVozac.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        mainPanel.add(lblVozac);

        btnDispecer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DispecerLogin dl = new DispecerLogin(taxiSluzba);
                dl.setVisible(true);
            }
        });

        btnMusterija.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MusterijaLogin ml = new MusterijaLogin(taxiSluzba);
                ml.setVisible(true);
            }
        });

        btnVozac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VozacLogin vl = new VozacLogin(taxiSluzba);
                vl.setVisible(true);
            }
        });
    }
}
