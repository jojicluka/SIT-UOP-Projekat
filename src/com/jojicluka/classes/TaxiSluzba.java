package com.jojicluka.classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
    private static ArrayList<Dispecer> dispeceri;
    private ArrayList<Korisnik> korisnici;
    private ArrayList<Automobil> automobili;
    private ArrayList<Musterija> musterije;
    private static ArrayList<Voznja> voznje;


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
        boolean verify = Korisnik.verifyLogin(userCheck, passCheck);
        if(verify == true){
            provera.setText("Login uspesan!");
            TaxiSluzba.crudMenu();
        } else {
            provera.setText("Login neuspesan...");
        }
    }

    public static ArrayList<Musterija> loadMusterije() {
        ArrayList<Musterija> musterije = new ArrayList<Musterija>();
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

                Musterija musterija = new Musterija(username, password, ime, prezime, jmbg, adress, pol, brTel);
                musterije.add(musterija);
            }
            reader.close();
        }catch (Exception e) {
            System.out.println("Greska u ucitavanju musterija!");
        }
        System.out.println(musterije);
        System.out.println("Musterije ucitane!");
        return musterije;
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

    public static ArrayList<Dispecer> loadDispecere() {
        ArrayList<Dispecer> dispeceri = new ArrayList<Dispecer>();

        try {
            File file = new File("src/com/jojicluka/text/dispeceri.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null) {
                String[] split = line.split("\\|");
                String username = split[0];
                String password = split[1];
                String ime = split[2];
                String prezime = split[3];
                long jmbg = Long.parseLong(split[4]);
                String adress = split[5];
                String pol = split[6];
                long brTel = Long.parseLong(split[7]);
                int plata = Integer.parseInt(split[8]);
                int brTelLinije = Integer.parseInt(split[9]);
                int telOdeljenje = Integer.parseInt(split[10]);

                Dispecer dispecer = new Dispecer(username, password, ime, prezime, jmbg, adress, pol, brTel, plata, brTelLinije, telOdeljenje);
                dispeceri.add(dispecer);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Greska u ucitavanju dispecera!");
        }
        return dispeceri;
    }

    public static ArrayList<Vozac> loadVozace() {
        ArrayList<Vozac> vozaci = new ArrayList<Vozac>();

        try {
            File file = new File("src/com/jojicluka/text/vozaci.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null) {
                String[] split = line.split("\\|");
                String username = split[0];
                String password = split[1];
                String ime = split[2];
                String prezime = split[3];
                long jmbg = Long.parseLong(split[4]);
                String adress = split[5];
                String pol = split[6];
                long brTel = Long.parseLong(split[7]);
                int plata = Integer.parseInt(split[8]);
                int brClanskeKarte = Integer.parseInt(split[9]);

                Vozac vozac = new Vozac(username, password, ime, prezime, jmbg, adress, pol, brTel, plata, brClanskeKarte);
                vozaci.add(vozac);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Greska u ucitavanju vozaca!");
        }
        return vozaci;
    }

    public static ArrayList<Voznja> loadVoznje() {
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        try {
            File file = new File("src/com/jojicluka/text/voznje.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null) {
                String[] split = line.split("\\|");
                String vremePorudzbine = split[0];
                String adresaPolaska = split[1];
                String adresaDestinacije = split[2];
                String musterija = split[3];
                String vozac = split[4];
                int brojKmPredjenih = Integer.parseInt(split[5]);
                int trajanjeVoznje = Integer.parseInt(split[6]);
                byte statusVoznje = Byte.parseByte(split[7]);
                Voznja voznja = new Voznja(vremePorudzbine, adresaPolaska, adresaDestinacije, musterija, vozac, brojKmPredjenih, trajanjeVoznje, statusVoznje);
                voznje.add(voznja);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Greska u ucitavanju vozaca!");
        }
        return voznje;
    }

    public static ArrayList<Dispecer> getDispecere() {
        return dispeceri;
    }

    public static void crudMenu(){
        Scanner izbor = new Scanner(System.in);
        System.out.println("1. Dispeceri\n");
        System.out.println("2. Vozaci\n");
        System.out.println("3. Voznje\n");
        System.out.println("4. Izlaz\n");
        System.out.println("Izaberite: ");
        int izborInt = izbor.nextInt();
        if (izborInt == 1) {
            System.out.println("Dispeceri rade");
            TaxiSluzba.crudDispecerMeni();
        }else if (izborInt == 2) {
            System.out.println("Vozaci");
            TaxiSluzba.crudVozacMeni();
        }else if (izborInt == 3) {
            System.out.println("Voznje");
            TaxiSluzba.crudVoznjaMeni();
        }else if (izborInt == 4) {
            System.exit(0);
        }else{
            System.out.println("Nepostojeci izbor");
            TaxiSluzba.crudMenu();
        }
    }

    public static void crudDispecerMeni(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Tabela dispecera\n");
        System.out.println("2. Izmeni dispecera\n");
        System.out.println("3. Obrisi dispecera\n");
        System.out.println("4. Nazad\n");
        System.out.println("Izaberite: ");
        int input = sc.nextInt();
        if (input == 1){
            TaxiSluzba.tabelaDispecera();
        } else if (input == 2){
            TaxiSluzba.crudDispecerMeni();
        } else if (input == 3){
            TaxiSluzba.crudDispecerMeni();
        } else if (input == 4){
            TaxiSluzba.crudMenu();
        } else {
            System.out.println("Nepostojeci izbor!\n");
            TaxiSluzba.crudDispecerMeni();
        }
    }

    public static void tabelaDispecera() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Username | Password | Ime | Prezime | JMBG | Adresa | Pol | Broj Telefona | Plata | Broj telefonske linije | Odeljenje");
        for(int i = 0 ; i < TaxiSluzba.loadDispecere().size() ; i++) {
            Dispecer dispecer = TaxiSluzba.loadDispecere().get(i);
            System.out.println(dispecer.getUsername() + " | " + dispecer.getPassword() + " | " + dispecer.getIme() + " | "
            + dispecer.getPrezime() + " | " + dispecer.getJmbg() + " | " + dispecer.getAdress() + " | " + dispecer.getPol()
            + " | " + dispecer.getBrTel() + " | " + dispecer.getPlata() + " | " + dispecer.getBrTelLinije() + " | " +
                    dispecer.getTelOdeljenje());
        }
        System.out.println("1. Nazad\n");
        System.out.println("Unesite izbor: ");
        int input = sc.nextInt();
        if (input == 1){
            TaxiSluzba.crudDispecerMeni();
        } else {
            TaxiSluzba.crudDispecerMeni();
        }
    }

    public static void crudVozacMeni(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Tabela vozaca\n");
        System.out.println("2. Izmeni vozaca\n");
        System.out.println("3. Obrisi vozaca\n");
        System.out.println("4. Nazad\n");
        System.out.println("Izaberite: ");
        int input = sc.nextInt();
        if (input == 1){
            TaxiSluzba.tabelaVozaca();
        } else if (input == 2){
            TaxiSluzba.crudVozacMeni();
        } else if (input == 3){
            TaxiSluzba.crudVozacMeni();
        } else if (input == 4){
            TaxiSluzba.crudMenu();
        } else {
            System.out.println("Nepostojeci izbor!\n");
            TaxiSluzba.crudVozacMeni();
        }
    }

    public static void tabelaVozaca() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Username | Password | Ime | Prezime | JMBG | Adresa | Pol | Broj Telefona | Plata | Broj clanske karte");
        for(int i = 0 ; i < TaxiSluzba.loadVozace().size() ; i++) {
            Vozac vozac = TaxiSluzba.loadVozace().get(i);
            System.out.println(vozac.getUsername() + " | " + vozac.getPassword() + " | " + vozac.getIme() + " | "
                    + vozac.getPrezime() + " | " + vozac.getJmbg() + " | " + vozac.getAdress() + " | " + vozac.getPol()
                    + " | " + vozac.getBrTel() + " | " + vozac.getPlata() + " | " + vozac.getBrClanskeKarte());
        }
        System.out.println("1. Nazad\n");
        System.out.println("Unesite izbor: ");
        int input = sc.nextInt();
        if (input == 1){
            TaxiSluzba.crudVozacMeni();
        } else {
            TaxiSluzba.crudVozacMeni();
        }
    }

    public static void crudVoznjaMeni(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Tabela voznji\n");
        System.out.println("2. Izmeni voznji\n");
        System.out.println("3. Obrisi voznji\n");
        System.out.println("4. Nazad\n");
        System.out.println("Izaberite: ");
        int input = sc.nextInt();
        if (input == 1){
            TaxiSluzba.tabelaVoznji();
        } else if (input == 2){
            TaxiSluzba.crudVoznjaMeni();
        } else if (input == 3){
            TaxiSluzba.crudVoznjaMeni();
        } else if (input == 4){
            TaxiSluzba.crudMenu();
        } else {
            System.out.println("Nepostojeci izbor!\n");
            TaxiSluzba.crudVoznjaMeni();
        }
    }

    public static void tabelaVoznji() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vreme porudzbine | Adresa polaska | Adresa destinacije | Musterija | Vozac | Predjeni KM | Trajanje voznje | Status ");
        for(int i = 0 ; i < TaxiSluzba.loadVoznje().size() ; i++) {
            Voznja voznja = TaxiSluzba.loadVoznje().get(i);
            System.out.println(voznja.getVremePorudzbine() + " | " + voznja.getAdresaPolaska() + " | " + voznja.getAdresaDestinacije() + " | "
                    + voznja.getMusterija() + " | " + voznja.getVozac() + " | " + voznja.getBrojKmPredjenih() + " | " + voznja.getTrajanjeVoznje()
                    + " | " + voznja.getStatusVoznje());
        }
        System.out.println("1. Nazad\n");
        System.out.println("Unesite izbor: ");
        int input = sc.nextInt();
        if (input == 1){
            TaxiSluzba.crudVoznjaMeni();
        } else {
            TaxiSluzba.crudVoznjaMeni();
        }
    }
}

