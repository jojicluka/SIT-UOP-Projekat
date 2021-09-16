package com.jojicluka.gui.VozacDashboard;

import com.jojicluka.taxisluzba.TaxiSluzba;
import com.jojicluka.voznje.VoznjaApp;
import com.jojicluka.voznje.VoznjaTel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VozacPrikazPrihvacenihVoznjiApp extends JFrame {
    private JTable tabela;
    private DefaultTableModel dtm;
    private JButton btnZavrsi;
    private JPanel mainPanel;

    private ArrayList<VoznjaApp> voznje;

    public VozacPrikazPrihvacenihVoznjiApp(TaxiSluzba taxiSluzba, String username){
        setTitle("Prikaz prihvacenih voznji aplikacija");
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
        voznje = taxiSluzba.sveVoznjePrihvaceneApp(vozacId);
        Object [][] content = new Object[voznje.size()][glava.length];
        for(int i=0;i<voznje.size();i++){
            VoznjaApp voznjaApp = voznje.get(i);
            content[i][0] = voznjaApp.getId();
            content[i][1] = voznjaApp.getVremePorudzbine();
            content[i][2] = voznjaApp.getAdresaPolaska();
            content[i][3] = voznjaApp.getAdresaDestinacije();
            content[i][4] = voznjaApp.getIdMusterije();
            content[i][5] = voznjaApp.getStatusVoznje();
        }
        DefaultTableModel dtm = new DefaultTableModel(content,glava);
        tabela = new JTable(dtm);
        tabela.setRowSelectionAllowed(true);
        tabela.setColumnSelectionAllowed(false);
        tabela.setAutoCreateRowSorter(true);
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
                    VoznjaApp voznjaApp = taxiSluzba.nadjiVoznjuIdApp(voznjaId);
                    if (voznjaApp==null){
                        JOptionPane.showMessageDialog(null, "Ta voznja ne postoji!", "ERROR", JOptionPane.WARNING_MESSAGE);
                    } else {
                        VozacZavrsiVoznjuApp vzva = new VozacZavrsiVoznjuApp(taxiSluzba, voznjaApp);
                        vzva.setVisible(true);
                    }
                }
            }
        });
    }



}
