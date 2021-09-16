package com.jojicluka.gui.DispecerDashboard;

import com.jojicluka.korisnici.Vozac;
import com.jojicluka.taxisluzba.TaxiSluzba;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class DispecerPrikazPretrazenihVozaca extends JFrame {
    private JTable tabela;
    private DefaultTableModel dtm;
    private JPanel mainPanel;
    private ArrayList<Vozac> vozaci;

    public DispecerPrikazPretrazenihVozaca(ArrayList<Vozac> pretrazeniVozaci){
        setTitle("Prikaz pretrazenih vozaca");
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
                "Ime", "Prezime", "Plata"
        };
        Object [][] content = new Object[pretrazeniVozaci.size()][glava.length];
        for(int i = 0; i < pretrazeniVozaci.size(); i++){
            Vozac vozac = pretrazeniVozaci.get(i);
            content[i][0] = vozac.getIme();
            content[i][1] = vozac.getPrezime();
            content[i][2] = vozac.getPlata();
        }
        DefaultTableModel dtm = new DefaultTableModel(content,glava);
        tabela = new JTable(dtm);
        tabela.setRowSelectionAllowed(true);
        tabela.setColumnSelectionAllowed(false);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setDefaultEditor(Object.class, null);
        tabela.setAutoCreateRowSorter(true);
        scrollPane.setViewportView(tabela);
    }
}
