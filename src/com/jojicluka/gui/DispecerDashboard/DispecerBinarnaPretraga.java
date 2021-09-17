package com.jojicluka.gui.DispecerDashboard;

import com.jojicluka.korisnici.Vozac;
import com.jojicluka.taxisluzba.TaxiSluzba;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class DispecerBinarnaPretraga extends JFrame {
    private JPanel mainPanel;
    private JTextField idField;
    private JButton btnPretrazi;

    private ArrayList<Vozac> vozaci;


    public DispecerBinarnaPretraga(TaxiSluzba taxiSluzba){
        setTitle("Unesi id vozaca");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250,250,750,350);

        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setLayout(null);
        mainPanel.setBorder(new EmptyBorder(3,3,3,3));

        JLabel lblVreme = new JLabel("Unos ID-a vozaca: ");
        lblVreme.setBounds(75, 40, 180, 40);
        lblVreme.setFont(new Font("Helvetica neue", Font.BOLD, 14));
        mainPanel.add(lblVreme);

        idField = new JTextField();
        idField.setColumns(12);
        idField.setBounds(300,140,300,40);
        mainPanel.add(idField);

        btnPretrazi = new JButton("Pretrazi");
        btnPretrazi.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        btnPretrazi.setBounds(300,220,150,75);
        mainPanel.add(btnPretrazi);

        btnPretrazi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vozaci = taxiSluzba.sviVozaci();
                Collections.sort(vozaci);
                int index = Collections.binarySearch(vozaci, new Vozac(idField.getText()));
                System.out.println(index);
                if(index <= -1){
                    JOptionPane.showMessageDialog(null, "Taj id ne postoji!", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
                Vozac vozac1 = taxiSluzba.nadjiVozacaId(idField.getText());
                DispecerIzmeniVozaca div = new DispecerIzmeniVozaca(taxiSluzba,vozac1);
                div.setVisible(true);
            }
        });
    }


}
