package com.jojicluka.classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaxiSluzba implements ActionListener {
    public TaxiSluzba(){

    }

    public TaxiSluzba(long pib, String naziv, String adress, int cenaStartaVoznje, int cenaPoKilometru) {
        this.pib = pib;
        this.naziv = naziv;
        this.adress = adress;
        this.cenaStartaVoznje = cenaStartaVoznje;
        this.cenaPoKilometru = cenaPoKilometru;
    }

    public long getPib() {
        return pib;
    }

    public void setPib(long pib) {
        this.pib = pib;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getCenaStartaVoznje() {
        return cenaStartaVoznje;
    }

    public void setCenaStartaVoznje(int cenaStartaVoznje) {
        this.cenaStartaVoznje = cenaStartaVoznje;
    }

    public int getCenaPoKilometru() {
        return cenaPoKilometru;
    }

    public void setCenaPoKilometru(int cenaPoKilometru) {
        this.cenaPoKilometru = cenaPoKilometru;
    }

    private long pib;
    private String naziv;
    private String adress;
    private int cenaStartaVoznje;
    private int cenaPoKilometru;

    private static JLabel userLabel;
    private static JTextField usernameText;
    private static JLabel passLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel provera;

    public static void login(){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setSize(400,250);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("User:");
        userLabel.setBounds(50, 20, 80, 30);
        panel.add(userLabel);

        usernameText = new JTextField();
        usernameText.setBounds(140, 20, 150, 30);
        panel.add(usernameText);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 50, 80, 30);
        panel.add(passLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(140, 50, 150, 30);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(50, 80, 90, 30);
        button.addActionListener(new TaxiSluzba());
        panel.add(button);

        provera = new JLabel("");
        provera.setBounds(50, 120, 250, 30);
        panel.add(provera);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userCheck = usernameText.getText();
        String passCheck = passwordText.getText();

        if(userCheck.equals("provera") && passCheck.equals("provera")){
            provera.setText("Login uspesan!");
        } else {
            provera.setText("Login neuspesan...");
        }

    }
}
