package com.jojicluka.gui.DispecerDashboard;

import com.jojicluka.taxisluzba.TaxiSluzba;
import com.jojicluka.voznje.StatusVoznje;
import com.jojicluka.voznje.VoznjaTel;
import com.jojicluka.korisnici.Vozac;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DispecerDodeliVoznju extends JFrame {
    private JPanel mainPanel;
    private JTable tabela;

    public DispecerDodeliVoznju(TaxiSluzba taxiSluzba){
        setTitle("Dodeli voznju");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100,100,1000,500);
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(3,3,3,3));
        setContentPane(mainPanel);
        mainPanel.setLayout(null);
        String [] glava = new String[] {
                "id", "Vreme porudzbine", "Adresa polaska", "Adresa destinacije",
                "Predjeni KM", "Trajanje", "Status", "ID musterije", "ID vozaca"
        };
        Object [][] content = new Object [taxiSluzba.sveVoznjeDodela().size()][glava.length];
        for(int i=0; i < taxiSluzba.sveVoznjeDodela().size();i++){
            VoznjaTel voznjaTel = taxiSluzba.sveVoznjeDodela().get(i);
            content[i][0] = voznjaTel.getId();
            content[i][1] = voznjaTel.getVremePorudzbine();
            content[i][2] = voznjaTel.getAdresaPolaska();
            content[i][3] = voznjaTel.getAdresaDestinacije();
            content[i][4] = voznjaTel.getBrojKmPredjenih();
            content[i][5] = voznjaTel.getTrajanjeVoznje();
            content[i][6] = voznjaTel.getStatusVoznje();
            content[i][7] = voznjaTel.getIdMusterije();
            content[i][8] = voznjaTel.getIdVozaca();
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20,20,800,250);
        mainPanel.add(scrollPane);
        tabela = new JTable();
        scrollPane.setViewportView(tabela);
        tabela.setModel(new DefaultTableModel(content,glava));
        tabela.setRowSelectionAllowed(true);
        tabela.setColumnSelectionAllowed(false);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setDefaultEditor(Object.class, null);

        JButton btnDodeli = new JButton("Dodeli");
        btnDodeli.setBounds(20,350,200,40);
        btnDodeli.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        mainPanel.add(btnDodeli);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel());
        comboBox.addItem("Odaberi vozaca");
        for (Vozac vozac: taxiSluzba.getVozaci()){
            comboBox.addItem(vozac.getUsername());
        }
        comboBox.setBounds(250,350,200,40);
        mainPanel.add(comboBox);

        btnDodeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int row = tabela.getSelectedRow();
                    if (row == -1) {
                        JOptionPane.showMessageDialog(null, "Izaberite voznju iz tabele!", "ERROR", JOptionPane.WARNING_MESSAGE);
                    } else {
                        String id = tabela.getValueAt(row, 0).toString();
                        String username = String.valueOf(comboBox.getSelectedItem());
                        String idVozaca = "";
                        for (Vozac vozac: taxiSluzba.getVozaci()){
                            if(vozac.getUsername().equals(username)){
                                idVozaca = vozac.getId();
                            }
                        }
                        if(idVozaca == "0"){
                            throw new Exception();
                        }
                        for (VoznjaTel voznjaTel : taxiSluzba.getVoznjeTel()){
                            if (voznjaTel.getId().equals(id)){
                                voznjaTel.setStatusVoznje(StatusVoznje.DODELJENA);
                                voznjaTel.setIdVozaca(idVozaca);
                            }
                        }
                        taxiSluzba.saveVoznjeTel();
                        JOptionPane.showMessageDialog(null, "Voznja uspesno dodeljena vozacu: " + username, "Dodeli voznju", JOptionPane.INFORMATION_MESSAGE);

                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Greska prilikom dodele voznje", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }





}

