package com.jojicluka.gui.VozacDashboard;

import com.jojicluka.korisnici.Ponuda;
import com.jojicluka.taxisluzba.TaxiSluzba;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VozacUnesiVreme extends JFrame {
    private JPanel mainPanel;
    private JTextField vremeField;
    private JButton btnPonudi;

    public VozacUnesiVreme(TaxiSluzba taxiSluzba, String username, String idVoznje){
        setTitle("Unesi vreme potrebno do destinacije");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250,250,750,350);

        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setLayout(null);
        mainPanel.setBorder(new EmptyBorder(3,3,3,3));

        JLabel lblVreme = new JLabel("Unos vremena: ");
        lblVreme.setBounds(75, 40, 180, 40);
        lblVreme.setFont(new Font("Helvetica neue", Font.BOLD, 14));
        mainPanel.add(lblVreme);

        vremeField = new JTextField();
        vremeField.setColumns(12);
        vremeField.setBounds(300,140,300,40);
        mainPanel.add(vremeField);

        btnPonudi = new JButton("Ponudi");
        btnPonudi.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        btnPonudi.setBounds(300,220,150,75);
        mainPanel.add(btnPonudi);

        btnPonudi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vreme = vremeField.getText();
                String idVozaca = taxiSluzba.nadjiVozacId(username);

                Ponuda ponuda = new Ponuda(idVozaca,vreme,username,idVoznje);
                taxiSluzba.getPonude().add(ponuda);
                taxiSluzba.savePonude();
                JOptionPane.showMessageDialog(null, "Ponuda poslata!", "PONUDA POSLATA", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
