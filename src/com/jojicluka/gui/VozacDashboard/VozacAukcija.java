package com.jojicluka.gui.VozacDashboard;

import com.jojicluka.taxisluzba.TaxiSluzba;
import com.jojicluka.voznje.VoznjaApp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VozacAukcija extends JFrame {
    private JPanel mainPanel;
    private JTable tabela;

    public VozacAukcija(TaxiSluzba taxiSluzba, String username){
        setTitle("Aukcija voznje");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100,100,1000,500);
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(3,3,3,3));
        setContentPane(mainPanel);
        mainPanel.setLayout(null);
        String [] glava = new String[] {
                "id", "Vreme porudzbine", "Adresa polaska", "Adresa destinacije",
                "Predjeni KM", "Trajanje", "Status", "ID musterije", "ID vozaca", "Napomena"
        };
        Object [][] content = new Object [taxiSluzba.sveVoznjeCekanje().size()][glava.length];
        for(int i=0; i < taxiSluzba.sveVoznjeCekanje().size();i++){
            VoznjaApp voznjaApp = taxiSluzba.sveVoznjeCekanje().get(i);
            content[i][0] = voznjaApp.getId();
            content[i][1] = voznjaApp.getVremePorudzbine();
            content[i][2] = voznjaApp.getAdresaPolaska();
            content[i][3] = voznjaApp.getAdresaDestinacije();
            content[i][4] = voznjaApp.getBrojKmPredjenih();
            content[i][5] = voznjaApp.getTrajanjeVoznje();
            content[i][6] = voznjaApp.getStatusVoznje();
            content[i][7] = voznjaApp.getIdMusterije();
            content[i][8] = voznjaApp.getIdVozaca();
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20,20,800,250);
        mainPanel.add(scrollPane);
        tabela = new JTable();
        scrollPane.setViewportView(tabela);
        tabela.setModel(new DefaultTableModel(content,glava));
        tabela.setRowSelectionAllowed(true);
        tabela.setColumnSelectionAllowed(false);
        tabela.setAutoCreateRowSorter(true);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setDefaultEditor(Object.class, null);

        JButton btnUnesiVreme = new JButton("Unesi vreme");
        btnUnesiVreme.setBounds(20,350,200,40);
        btnUnesiVreme.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        mainPanel.add(btnUnesiVreme);

        btnUnesiVreme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int row = tabela.getSelectedRow();
                    if(row == -1) {
                        JOptionPane.showMessageDialog(null, "Izaberite voznju iz tabele!", "ERROR", JOptionPane.WARNING_MESSAGE);
                    } else {
                        String idVoznje = tabela.getValueAt(row, 0).toString();
                        VozacUnesiVreme vuv = new VozacUnesiVreme(taxiSluzba, username, idVoznje);
                        vuv.setVisible(true);
                    }
                } catch (Exception exception){

                }
            }
        });
    }
}
