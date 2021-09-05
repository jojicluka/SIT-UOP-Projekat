package com.jojicluka.gui.VozacDashboard;

import com.jojicluka.taxisluzba.TaxiSluzba;
import com.jojicluka.voznje.VoznjaTel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VozacPrikazPrihvacenihVoznji extends JFrame {
    private JTable tabela;
    private DefaultTableModel dtm;
    private JButton btnZavrsi;
    private JPanel mainPanel;

    private ArrayList<VoznjaTel> voznjeTel;

    public VozacPrikazPrihvacenihVoznji(TaxiSluzba taxiSluzba, String username){
        setTitle("Prikaz prihvacenih voznji");
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
        voznjeTel = taxiSluzba.sveVoznjePrihvaceneId(vozacId);
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
        btnZavrsi = new JButton("Zavrsi voznju");
        btnZavrsi.setBounds(400,400,120,60);
        mainPanel.add(btnZavrsi);

        btnZavrsi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int row = tabela.getSelectedRow();
               if(row == -1) {
                   JOptionPane.showMessageDialog(null, "Izaberite voznju iz tabele! ", "ERROR", JOptionPane.WARNING_MESSAGE);
               } else {
                   String voznjaId = tabela.getValueAt(row,0).toString();
                   VoznjaTel voznjaTel = taxiSluzba.nadjiVoznjuId(voznjaId);
                   if (voznjaTel==null){
                       JOptionPane.showMessageDialog(null, "Ta voznja ne postoji!", "ERROR", JOptionPane.WARNING_MESSAGE);
                   } else {
                       VozacZavrsiVoznju vzv = new VozacZavrsiVoznju(taxiSluzba, voznjaTel);
                       vzv.setVisible(true);
                   }
               }
            }
        });
    }



}
