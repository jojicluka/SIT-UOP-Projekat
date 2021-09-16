package com.jojicluka.gui.DispecerDashboard;

import com.jojicluka.taxisluzba.TaxiSluzba;
import com.jojicluka.voznje.Voznja;
import com.jojicluka.voznje.VoznjaApp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class DispecerPrikazVoznjiAplikacija extends JFrame {
    private JTable tabela;
    private ArrayList<VoznjaApp> voznje = new ArrayList<>();

    public DispecerPrikazVoznjiAplikacija(TaxiSluzba taxiSluzba) {
        setTitle("Prikaz svih voznji narucenih aplikacijom");
        setBounds(100,100,1200,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String [] glava = new String[] {
                "id", "Vreme porudzbine", "Adresa polaska", "Adresa destinacije", "Musterija", "Vozac",
                "Predjeni KM", "Trajanje", "Status", "ID musterije", "ID vozaca", "Napomena"
        };
        System.out.println(voznje);
        voznje = taxiSluzba.sveVoznjeApp();
        System.out.println(voznje);
        Object [][] content = new Object [voznje.size()][glava.length];

        for(int i=0;i<voznje.size();i++){
            VoznjaApp voznja = voznje.get(i);
            content[i][0] = voznja.getId();
            content[i][1] = voznja.getVremePorudzbine();
            content[i][2] = voznja.getAdresaPolaska();
            content[i][3] = voznja.getAdresaDestinacije();
            content[i][4] = voznja.getMusterija();
            content[i][5] = voznja.getVozac();
            content[i][6] = voznja.getBrojKmPredjenih();
            content[i][7] = voznja.getTrajanjeVoznje();
            content[i][8] = voznja.getStatusVoznje();
            content[i][9] = voznja.getIdMusterije();
            content[i][10] = voznja.getIdVozaca();
            content[i][11] = voznja.getNapomena();
        }
        DefaultTableModel dtm = new DefaultTableModel(content,glava);
        tabela = new JTable(dtm);
        tabela.setRowSelectionAllowed(true);
        tabela.setColumnSelectionAllowed(false);
        tabela.setAutoCreateRowSorter(true);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);
    }
}
