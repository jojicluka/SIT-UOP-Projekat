package com.jojicluka.gui.MusterijaDashboard;

import com.jojicluka.taxisluzba.*;
import com.jojicluka.voznje.*;
import com.jojicluka.korisnici.Musterija;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MusterijaDashboard extends JFrame {
    private JButton btnNaruci = new JButton("Naruci voznju telefonom");
    private JTable tabela;
    private JToolBar toolbar = new JToolBar();
    private JLabel lblIstorija = new JLabel("Istorija mojih voznji: ");

    private ArrayList<VoznjaTel> voznje = new ArrayList<>();


    public MusterijaDashboard(TaxiSluzba taxiSluzba, String username){
        setTitle("Dashboard za musteriju: " + username);
        setBounds(100,100,1200,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        toolbar.add(btnNaruci);
        add(toolbar, BorderLayout.NORTH);
        String[] glava = new String[] {
                "Datum", "Polazak", "Destinacija", "Vozac","KM predjeni", "Trajanje",
                "Status voznje"
        };
        String musterijaId = taxiSluzba.nadjiMusterijaId(username);
        System.out.println(musterijaId);
        voznje = taxiSluzba.sveVoznjeTelMusterija(musterijaId);
        Musterija musterija = taxiSluzba.nadjiMusteriju(username);
        System.out.println(musterija.getId());
        Object [][] content = new Object [voznje.size()][glava.length];

        for(int i=0;i<voznje.size();i++){
            Voznja voznja = voznje.get(i);
            content[i][0] = voznja.getVremePorudzbine();
            content[i][1] = voznja.getAdresaPolaska();
            content[i][2] = voznja.getAdresaDestinacije();
            content[i][3] = voznja.getVozac().getUsername();
            content[i][4] = voznja.getBrojKmPredjenih();
            content[i][5] = voznja.getTrajanjeVoznje();
            content[i][6] = voznja.getStatusVoznje();
        }
        DefaultTableModel dtm = new DefaultTableModel(content,glava);
        tabela = new JTable(dtm);
        tabela.setRowSelectionAllowed(true);
        tabela.setColumnSelectionAllowed(false);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);

        btnNaruci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NaruciTelefon nt = new NaruciTelefon(taxiSluzba, username);
                nt.setVisible(true);
            }
        });
    }
}
