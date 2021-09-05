package com.jojicluka.gui.DispecerDashboard;

import com.jojicluka.korisnici.Pol;
import com.jojicluka.korisnici.Vozac;
import com.jojicluka.taxisluzba.TaxiSluzba;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DispecerIzmeniVozaca extends JFrame {
    private JPanel mainPanel;
    private JTextField usernameField = new JTextField(8);
    private JTextField passwordField = new JTextField(8);
    private JTextField imeField = new JTextField(8);
    private JTextField prezimeField = new JTextField(8);
    private JTextField adressField = new JTextField(8);
    private JTextField jmbgField = new JTextField(8);
    private JTextField brTelField = new JTextField(8);
    private JTextField brClanskeKarteField = new JTextField(8);
    private JTextField plataField = new JTextField(8);
    private Vozac vozac;
    private TaxiSluzba taxiSluzba;

    public DispecerIzmeniVozaca(TaxiSluzba taxiSluzba, Vozac vozac){
        this.taxiSluzba = taxiSluzba;
        this.vozac = vozac;
        setTitle("Izmeni vozaca " + vozac.getUsername());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100,100,1000,600);
        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setBorder(new EmptyBorder(3,3,3,3));
        mainPanel.setLayout(null);

        String jmbgString = String.valueOf(vozac.getJmbg());
        String brTelString = String.valueOf(vozac.getBrTel());
        String plataString = String.valueOf(vozac.getPlata());
        String brClanskeKarteString = String.valueOf(vozac.getBrClanskeKarte());

        JLabel lblUsername = new JLabel("Username: ");
        lblUsername.setBounds(20,50,150,40);
        lblUsername.setFont(new Font("Helvetica Neue", Font.BOLD,14));
        mainPanel.add(lblUsername);

        usernameField = new JTextField();
        usernameField.setColumns(8);
        usernameField.setBounds(160,50, 200,40);
        usernameField.setText(vozac.getUsername());
        mainPanel.add(usernameField);

        JLabel lblPassword = new JLabel("Password: ");
        lblPassword.setBounds(20,100,150,40);
        lblPassword.setFont(new Font("Helvetica Neue", Font.BOLD,14));
        mainPanel.add(lblPassword);

        passwordField = new JTextField();
        passwordField.setColumns(8);
        passwordField.setBounds(160,100, 200,40);
        passwordField.setText(vozac.getPassword());
        mainPanel.add(passwordField);

        JLabel lblIme = new JLabel("Ime: ");
        lblIme.setBounds(20,150,150,40);
        lblIme.setFont(new Font("Helvetica Neue", Font.BOLD,14));
        mainPanel.add(lblIme);

        imeField = new JTextField();
        imeField.setColumns(8);
        imeField.setBounds(160,150, 200,40);
        imeField.setText(vozac.getIme());
        mainPanel.add(imeField);

        JLabel lblPrezime = new JLabel("Prezime: ");
        lblPrezime.setBounds(20,200,150,40);
        lblPrezime.setFont(new Font("Helvetica Neue", Font.BOLD,14));
        mainPanel.add(lblPrezime);

        prezimeField = new JTextField();
        prezimeField.setColumns(8);
        prezimeField.setBounds(160,200, 200,40);
        prezimeField.setText(vozac.getPrezime());
        mainPanel.add(prezimeField);

        JLabel lblJmbg = new JLabel("JMBG: ");
        lblJmbg.setBounds(20,250,150,40);
        lblJmbg.setFont(new Font("Helvetica Neue", Font.BOLD,14));
        mainPanel.add(lblJmbg);

        jmbgField = new JTextField();
        jmbgField.setColumns(8);
        jmbgField.setBounds(160,250, 200,40);
        jmbgField.setText(jmbgString);
        mainPanel.add(jmbgField);

        JLabel lblAdress = new JLabel("Adresa: ");
        lblAdress.setBounds(20,300,150,40);
        lblAdress.setFont(new Font("Helvetica Neue", Font.BOLD,14));
        mainPanel.add(lblAdress);

        adressField = new JTextField();
        adressField.setColumns(8);
        adressField.setBounds(160,300, 200,40);
        adressField.setText(vozac.getAdress());
        mainPanel.add(adressField);

        JLabel lblPol = new JLabel("Pol: ");
        lblPol.setBounds(20,350,150,40);
        lblPol.setFont(new Font("Helvetica Neue", Font.BOLD,14));
        mainPanel.add(lblPol);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(Pol.values()));
        comboBox.setBounds(160,350,200,40);
        comboBox.setFont(new Font("Helvetica Neue", Font.BOLD,14));
        comboBox.setMaximumRowCount(2);
        mainPanel.add(comboBox);

        JLabel lblBrTel = new JLabel("Broj telefona: ");
        lblBrTel.setBounds(20,400,150,40);
        lblBrTel.setFont(new Font("Helvetica Neue", Font.BOLD,14));
        mainPanel.add(lblBrTel);

        brTelField = new JTextField();
        brTelField.setColumns(8);
        brTelField.setBounds(160,400, 200,40);
        brTelField.setText(brTelString);
        mainPanel.add(brTelField);

        JLabel lblPlata = new JLabel("Plata: ");
        lblPlata.setBounds(460,50,150,40);
        lblPlata.setFont(new Font("Helvetica Neue", Font.BOLD,14));
        mainPanel.add(lblPlata);

        plataField = new JTextField();
        plataField.setColumns(8);
        plataField.setBounds(610,50, 200,40);
        plataField.setText(plataString);
        mainPanel.add(plataField);

        JLabel lblBrClanskeKarte = new JLabel("Broj clanske karte: ");
        lblBrClanskeKarte.setBounds(460,100,150,40);
        lblBrClanskeKarte.setFont(new Font("Helvetica Neue", Font.BOLD,14));
        mainPanel.add(lblBrClanskeKarte);

        brClanskeKarteField = new JTextField();
        brClanskeKarteField.setColumns(8);
        brClanskeKarteField.setBounds(610,100, 200,40);
        brClanskeKarteField.setText(brClanskeKarteString);
        mainPanel.add(brClanskeKarteField);

        JButton btnIzmeni = new JButton("Izmeni");
        btnIzmeni.setBounds(400,520,150,40);
        btnIzmeni.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        mainPanel.add(btnIzmeni);

        btnIzmeni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(provera()) {
                    String username = usernameField.getText();
                    String password = passwordField.getText();
                    String ime = imeField.getText();
                    String prezime = prezimeField.getText();
                    long jmbg = Long.parseLong(jmbgField.getText());
                    String adress = adressField.getText();
                    Pol pol = (Pol) comboBox.getSelectedItem();
                    long brTel = Long.parseLong(brTelField.getText());
                    int plata = Integer.parseInt(plataField.getText());
                    int brClanskeKarte = Integer.parseInt(brClanskeKarteField.getText());
                    if (vozac != null) {
                        vozac.setUsername(username);
                        vozac.setPassword(password);
                        vozac.setIme(ime);
                        vozac.setPrezime(prezime);
                        vozac.setJmbg(jmbg);
                        vozac.setAdress(adress);
                        vozac.setPol(pol);
                        vozac.setBrTel(brTel);
                        vozac.setPlata(plata);
                        vozac.setBrClanskeKarte(brClanskeKarte);
                    }
                    taxiSluzba.saveVozace();
                    JOptionPane.showMessageDialog(null, "Vozac je uspesno izmenjen!", "Izmena", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
    private boolean provera() {
        boolean ok = true;
        String poruka = "Ispravite greske!\n";

        if(usernameField.getText().trim().equals("")) {
            poruka += "- Unesite username\n";
            ok = false;
        }
        if(passwordField.getText().trim().equals("")) {
            poruka += "- Unesite password\n";
            ok = false;
        }
        if(imeField.getText().trim().equals("")) {
            poruka += "- Unesite ime\n";
            ok = false;
        }
        if(prezimeField.getText().trim().equals("")) {
            poruka += "- Unesite  prezime\n";
            ok = false;
        }
        if(jmbgField.getText().trim().equals("")) {
            poruka += "- Unesite  JMBG\n";
            ok = false;
        }
        if(brTelField.getText().trim().equals("")) {
            poruka += "- Unesite  broj telefona\n";
            ok = false;
        }
        if(plataField.getText().trim().equals("")) {
            poruka += "- Unesite  platu\n";
            ok = false;
        }
        if(brClanskeKarteField.getText().trim().equals("")) {
            poruka += "- Unesite  broj clanske karte\n";
            ok = false;
        }
        if(adressField.getText().trim().equals("")) {
            poruka += "- Unesite  adresu\n";
            ok = false;
        }


        else if(vozac == null){
            String username = usernameField.getText().trim();
            Vozac vozacChk = taxiSluzba.nadjiVozaca(username);
            if(vozacChk != null) {
                poruka += "- Taj username je vec u upotrebi!\n";
                ok = false;
            }
        }
        if(ok == false) {
            JOptionPane.showMessageDialog(null, poruka, "Pogresni podaci", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }
}
