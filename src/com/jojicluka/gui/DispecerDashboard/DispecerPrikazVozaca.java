package com.jojicluka.gui.DispecerDashboard;

import com.jojicluka.korisnici.Vozac;
import com.jojicluka.taxisluzba.TaxiSluzba;
import com.jojicluka.voznje.VoznjaTel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DispecerPrikazVozaca extends JFrame {
    private JTable tabela;
    private DefaultTableModel dtm;
    private JButton btnDodajVozaca;
    private JButton btnIzmeniVozaca;
    private JButton btnObrisiVozaca;
    private JPanel mainPanel;

    private ArrayList<Vozac> vozaci;

    public DispecerPrikazVozaca(TaxiSluzba taxiSluzba) {
        setTitle("Prikaz i izmena vozaca");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100,100, 1000,500);
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(3,3,3,3));
        setContentPane(mainPanel);
        mainPanel.setLayout(null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10,20,800,300);
        mainPanel.add(scrollPane);
        String [] glava = new String[] {
                "id", "Username", "Password", "Ime", "Prezime", "JMBG",
                "Adresa", "Pol", "Broj telefona", "Plata", "Broj clanske karte"
        };
        vozaci = taxiSluzba.sviVozaci();
        Object [][] content = new Object [vozaci.size()][glava.length];

        for(int i=0;i<vozaci.size();i++){
            Vozac vozac = vozaci.get(i);
            content[i][0] = vozac.getId();
            content[i][1] = vozac.getUsername();
            content[i][2] = vozac.getPassword();
            content[i][3] = vozac.getIme();
            content[i][4] = vozac.getPrezime();
            content[i][5] = vozac.getJmbg();
            content[i][6] = vozac.getAdress();
            content[i][7] = vozac.getPol();
            content[i][8] = vozac.getBrTel();
            content[i][9] = vozac.getPlata();
            content[i][10] = vozac.getBrClanskeKarte();
        }
        DefaultTableModel dtm = new DefaultTableModel(content,glava);
        tabela = new JTable(dtm);
        tabela.setRowSelectionAllowed(true);
        tabela.setColumnSelectionAllowed(false);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setDefaultEditor(Object.class, null);
        tabela.setAutoCreateRowSorter(true);
        scrollPane.setViewportView(tabela);
        btnDodajVozaca = new JButton("Dodaj");
        btnDodajVozaca.setFont(new Font("Helvetica Neue", Font.BOLD,12));
        btnIzmeniVozaca = new JButton("Izmeni");
        btnIzmeniVozaca.setFont(new Font("Helvetica Neue", Font.BOLD,12));
        btnObrisiVozaca = new JButton("Obrisi");
        btnObrisiVozaca.setFont(new Font("Helvetica Neue", Font.BOLD,12));
        btnObrisiVozaca.setBounds(200,400,120,60);
        btnDodajVozaca.setBounds(400,400,120,60);
        btnIzmeniVozaca.setBounds(600,400,120,60);
        mainPanel.add(btnDodajVozaca);
        mainPanel.add(btnIzmeniVozaca);
        mainPanel.add(btnObrisiVozaca);

        btnObrisiVozaca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tabela.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null,"Izaberite vozaca iz tabele!", "ERROR", JOptionPane.WARNING_MESSAGE );
                } else {
                    String username = tabela.getValueAt(row, 1).toString();
                    Vozac vozac = taxiSluzba.nadjiVozaca(username);
                    int i = JOptionPane.showConfirmDialog(null, "Da li sigurno zelite da obrisete vozaca" + username, "Brisanje korisnika: " + username, JOptionPane.YES_NO_OPTION);
                    if(i == JOptionPane.YES_OPTION){
                        vozac.setPostoji(false);
                        dtm.removeRow(row);
                        taxiSluzba.saveVozace();
                        JOptionPane.showMessageDialog(null, "Izabrani vozac je izbrisan...", "Brisanje  ", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        btnIzmeniVozaca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tabela.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Izaberite vozaca iz tabele! ", "ERROR", JOptionPane.WARNING_MESSAGE);
                } else {
                    String username = tabela.getValueAt(row, 1).toString();
                    Vozac vozac = taxiSluzba.nadjiVozaca(username);
                    if (vozac == null){
                        JOptionPane.showMessageDialog(null, "Taj vozac ne postoji!", "ERROR", JOptionPane.WARNING_MESSAGE);
                    } else {
                        DispecerIzmeniVozaca div = new DispecerIzmeniVozaca(taxiSluzba, vozac);
                        div.setVisible(true);
                    }
                }

            }
        });

        btnDodajVozaca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DispecerDodajVozaca ddv = new DispecerDodajVozaca(taxiSluzba);
                ddv.setVisible(true);
            }
        });
    }

}
