package com.jojicluka.classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

    private ArrayList<Vozac> vozaci;
    private ArrayList<Dispecer> dispeceri;
    private ArrayList<Korisnik> korisnici;
    private ArrayList<Automobil> automobili;
    private ArrayList<Musterija> musterije;
    private ArrayList<Voznja> voznje;

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

    public static ArrayList<Korisnik> loadKorisnike() {
        ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
        try {
            File file = new File("src/com/jojicluka/text/korisnici.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null){
                String[] split = line.split("\\|");
                String username = split[0];
                String password = split[1];
                String ime = split[2];
                String prezime = split[3];
                long jmbg = Long.parseLong(split[4]);
                String adress = split[5];
                String pol = split[6];
                long brTel = Long.parseLong(split[7]);

                Korisnik korisnik = new Korisnik(username, password, ime, prezime, jmbg, adress, pol, brTel);
                korisnici.add(korisnik);
            }
            reader.close();
        }catch (Exception e) {
            System.out.println("Greska u ucitavanju korisnika!");
        }
        System.out.println(korisnici);
        System.out.println("Korisnici ucitani!");
        return korisnici;
    }

    public static ArrayList<Automobil> loadAutomobile(){
        ArrayList<Automobil> automobili = new ArrayList<Automobil>();

        try{
            File file = new File("src/com/jojicluka/text/automobili.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null) {
                String[] split = line.split("\\|");
                String model = split[0];
                String proizvodjac = split[1];
                int godProizvodnje = Integer.parseInt(split[2]);
                String brTablica = split[3];
                byte idVozila = Byte.parseByte(split[4]);
                byte vrsta = Byte.parseByte(split[5]);

                Automobil automobil = new Automobil(model, proizvodjac, godProizvodnje, brTablica, idVozila, vrsta);
                automobili.add(automobil);
            }
            reader.close();
        } catch(Exception e) {
            System.out.println("Greska u ucitavanju automobila!");
        }
        System.out.println(automobili);
        System.out.println("Automobili ucitani!");
        return automobili;
    }

}
