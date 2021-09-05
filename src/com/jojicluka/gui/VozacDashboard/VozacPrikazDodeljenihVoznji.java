package com.jojicluka.gui.VozacDashboard;

import com.jojicluka.gui.VozacLogin;
import com.jojicluka.taxisluzba.TaxiSluzba;
import com.jojicluka.voznje.StatusVoznje;
import com.jojicluka.voznje.VoznjaTel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VozacPrikazDodeljenihVoznji extends JFrame {
    private JTable tabela;
    private DefaultTableModel dtm;
    private JButton btnPrihvati;
    private JButton btnOdbij;
    private JPanel mainPanel;

    private ArrayList<VoznjaTel> voznjeTel;

    public VozacPrikazDodeljenihVoznji(TaxiSluzba taxiSluzba, String username){
        setTitle("Prikaz dodeljenih voznji");
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
                "id", "Vreme porudzbine", "Adresa polaska", "Adresa Destinacije", "ID musterije", "Status"
        };
        String vozacId = taxiSluzba.nadjiVozacId(username);
        voznjeTel = taxiSluzba.sveVoznjeDodelaId(vozacId);
        Object [][] content = new Object[voznjeTel.size()][glava.length];
        for(int i=0;i<voznjeTel.size();i++){
            VoznjaTel voznjaTel = voznjeTel.get(i);
            content[i][0] = voznjaTel.getId();
            content[i][1] = voznjaTel.getVremePorudzbine();
            content[i][2] = voznjaTel.getAdresaPolaska();
            content[i][3] = voznjaTel.getAdresaDestinacije();
            content[i][4] = voznjaTel.getIdMusterije();
            content[i][5] = voznjaTel.getStatusVoznje();
        }
        DefaultTableModel dtm = new DefaultTableModel(content,glava);
        tabela = new JTable(dtm);
        tabela.setRowSelectionAllowed(true);
        tabela.setColumnSelectionAllowed(false);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setDefaultEditor(Object.class, null);
        scrollPane.setViewportView(tabela);
        btnPrihvati = new JButton("Prihvati");
        btnPrihvati.setBounds(400,400,120,60);
        mainPanel.add(btnPrihvati);
        btnOdbij = new JButton("Odbij");
        btnOdbij.setBounds(550,400,120,60);
        mainPanel.add(btnOdbij);


        btnPrihvati.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            int row = tabela.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null,"Izaberite voznju iz tabele!", "ERROR", JOptionPane.WARNING_MESSAGE );
            } else {
                String id = tabela.getValueAt(row,0).toString();
                VoznjaTel voznjaTel = taxiSluzba.nadjiVoznjuId(id);
                int i = JOptionPane.showConfirmDialog(null, "Da li sigurno zelite da prihvatite voznju?", "Prihvatanje voznje", JOptionPane.YES_NO_OPTION);
                if(i==JOptionPane.YES_OPTION){
                    voznjaTel.setStatusVoznje(StatusVoznje.PRIHVACENA);
                    dtm.removeRow(row);
                    taxiSluzba.saveVoznjeTel();
                    JOptionPane.showMessageDialog(null, "Izabrani voznja je prihvacena!", "Prihvatanje voznje", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            }
        });

        btnOdbij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tabela.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null,"Izaberite voznju iz tabele!", "ERROR", JOptionPane.WARNING_MESSAGE );
                } else {
                    String id = tabela.getValueAt(row,0).toString();
                    VoznjaTel voznjaTel = taxiSluzba.nadjiVoznjuId(id);
                    int i = JOptionPane.showConfirmDialog(null, "Da li sigurno zelite da odbijete voznju?" + username, "Odbijanje voznje", JOptionPane.YES_NO_OPTION);
                    if(i==JOptionPane.YES_OPTION){
                        voznjaTel.setStatusVoznje(StatusVoznje.ODBIJENA);
                        dtm.removeRow(row);
                        taxiSluzba.saveVoznjeTel();
                        JOptionPane.showMessageDialog(null, "Izabrani voznja je odbijena!", "Odbijanje voznje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

    }
}
