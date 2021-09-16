package com.jojicluka.taxisluzba;

import com.jojicluka.automobili.Automobil;
import com.jojicluka.korisnici.*;
import com.jojicluka.voznje.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TaxiSluzba {

    private ArrayList<Vozac> vozaci;
    private ArrayList<Dispecer> dispeceri;
    private ArrayList<Automobil> automobili;
    private ArrayList<Musterija> musterije;
    private ArrayList<VoznjaApp> voznje;
    private ArrayList<VoznjaTel> voznjeTel;
    private ArrayList<Ponuda> ponude;

    public TaxiSluzba(){
        this.vozaci = new ArrayList<Vozac>();
        this.dispeceri = new ArrayList<Dispecer>();
        this.automobili = new ArrayList<Automobil>();
        this.musterije = new ArrayList<Musterija>();
        this.voznje = new ArrayList<VoznjaApp>();
        this.voznjeTel = new ArrayList<VoznjaTel>();
        this.ponude = new ArrayList<Ponuda>();

        loadAutomobile();
        loadVoznjeApp();
        loadDispecere();
        loadMusterije();
        loadVozace();
        loadVoznjeTel();
        loadPonude();
    }

   /* public TaxiSluzba(long pib, String naziv, String adress, int cenaStartaVoznje, int cenaPoKilometru) {
        this.pib = pib;
        this.naziv = naziv;
        this.adress = adress;
        this.cenaStartaVoznje = cenaStartaVoznje;
        this.cenaPoKilometru = cenaPoKilometru;
    } */

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

    public ArrayList<VoznjaTel> getVoznjeTel() {
        return voznjeTel;
    }

    public void setVoznjeTel(ArrayList<VoznjaTel> voznjeTel) {
        this.voznjeTel = voznjeTel;
    }

    public ArrayList<Automobil> getAutomobili() {
        return automobili;
    }

    public void setAutomobili(ArrayList<Automobil> automobili) {
        this.automobili = automobili;
    }

    public ArrayList<Vozac> getVozaci() {
        return vozaci;
    }

    public void setVozaci(ArrayList<Vozac> vozaci) {
        this.vozaci = vozaci;
    }

    public ArrayList<VoznjaApp> getVoznjeApp(){
        return voznje;
    }

    public ArrayList<Ponuda> getPonude(){return ponude;}

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

//////////////////////////////////////////////////////////
/////////////// PRONADJI FUNKCIJE ///////////////////////

    public Musterija nadjiMusteriju (String username) {
        for (Musterija musterija : musterije) {
            if (musterija.getUsername().equals(username)) {
                return musterija;
            }
        }
        return null;
    }

    public String nadjiMusterijaId(String username) {
        for (Musterija musterija : musterije) {
            if(musterija.getUsername().equals(username)){
                return musterija.getId();
            }
        }
        return null;
    }

    public Vozac nadjiVozaca (String username) {
        for (Vozac vozac : vozaci) {
            if (vozac.getUsername().equals(username)) {
                return vozac;
            }
        }
        return null;
    }

    public String nadjiVozacId(String username) {
        for (Vozac vozac: vozaci) {
            if (vozac.getUsername().equals(username)){
                return vozac.getId();
            }
        }
        return null;
    }

    public VoznjaTel nadjiVoznjuId(String id) {
        for (VoznjaTel voznjaTel: voznjeTel){
            if(voznjaTel.getId().equals(id)){
                return voznjaTel;
            }
        }
        return null;
    }

    public VoznjaApp nadjiVoznjuIdApp(String id){
        for(VoznjaApp voznjaApp:voznje){
            if(voznjaApp.getId().equals(id)){
                return voznjaApp;
            }
        }
        return null;
    }

////////////////////////////////////////////////////////
//////////////// FUNKCIJE VREMENA /////////////////////

    public GregorianCalendar vremeString (String f) {
        String[] split = f.split("\\ ");
        String[] date = split[0].split("\\.");
        String[] time = split[1].split("\\:");
        int dan = Integer.parseInt(date[0]);
        int mesec = Integer.parseInt(date[1]);
        int godina = Integer.parseInt(date[2]);
        int sat = Integer.parseInt(time[0]);
        int minuta = Integer.parseInt(time[1]);
        GregorianCalendar vreme = new GregorianCalendar(godina, mesec-1, dan, sat, minuta);
        return vreme;
    }

///////////////////////////////////////////////////////
/////////////// FUNKCIJE UCITAVANJA ///////////////////
    public void loadMusterije() {
        try {
            File file = new File("src/com/jojicluka/text/musterije.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
                String[] split = line.split("\\|");
                String id = split[0];
                String username = split[1];
                String password = split[2];
                String ime = split[3];
                String prezime = split[4];
                long jmbg = Long.parseLong(split[5]);
                String adress = split[6];
                Pol pol = Pol.valueOf(split[7]);
                long brTel = Long.parseLong(split[8]);
                //Role role = Role.valueOf(split[8]);
                boolean postoji = Boolean.parseBoolean(split[9]);

                Musterija musterija = new Musterija(id, username, password, ime, prezime, jmbg, adress, pol, brTel, postoji);
                musterije.add(musterija);
            }
            reader.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Musterije ucitane!");
    }

    public void loadAutomobile(){
        try{
            File file = new File("src/com/jojicluka/text/automobili.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] split = line.split("\\|");
                String model = split[0];
                String proizvodjac = split[1];
                int godProizvodnje = Integer.parseInt(split[2]);
                String brTablica = split[3];
                byte idVozila = Byte.parseByte(split[4]);
                byte vrsta = Byte.parseByte(split[5]);
                boolean postoji = Boolean.parseBoolean(split[6]);
                int idVozaca = Integer.parseInt(split[7]);
                Automobil automobil = new Automobil(model, proizvodjac, godProizvodnje, brTablica, idVozila, vrsta, postoji, idVozaca);
                automobili.add(automobil);
            }
            reader.close();
        } catch(Exception e) {
            System.out.println("Greska u ucitavanju automobila!");
        }
        System.out.println("Automobili ucitani!");
    }

    public void loadDispecere() {
        try {
            File file = new File("src/com/jojicluka/text/dispeceri.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] split = line.split("\\|");
                String id = split[0];
                String username = split[1];
                String password = split[2];
                String ime = split[3];
                String prezime = split[4];
                long jmbg = Long.parseLong(split[5]);
                String adress = split[6];
                Pol pol = Pol.valueOf(split[7]);
                long brTel = Long.parseLong(split[8]);
                //Role role = Role.valueOf(split[9]);
                int plata = Integer.parseInt(split[9]);
                int brTelLinije = Integer.parseInt(split[10]);
                int telOdeljenje = Integer.parseInt(split[11]);
                boolean postoji = Boolean.parseBoolean(split[12]);

                Dispecer dispecer = new Dispecer(id ,username, password, ime, prezime, jmbg, adress, pol, brTel, plata, brTelLinije, telOdeljenje, postoji);
                dispeceri.add(dispecer);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadVozace() {
        try {
            File file = new File("src/com/jojicluka/text/vozaci.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] split = line.split("\\|");
                String id = split[0];
                String username = split[1];
                String password = split[2];
                String ime = split[3];
                String prezime = split[4];
                long jmbg = Long.parseLong(split[5]);
                String adress = split[6];
                Pol pol = Pol.valueOf(split[7]);
                long brTel = Long.parseLong(split[8]);
                //Role role = Role.valueOf(split[9]);
                int plata = Integer.parseInt(split[9]);
                int brClanskeKarte = Integer.parseInt(split[10]);
                boolean postoji = Boolean.parseBoolean(split[11]);

                Vozac vozac = new Vozac(id, username, password, ime, prezime, jmbg, adress, pol, brTel, plata, brClanskeKarte, postoji);
                vozaci.add(vozac);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadVoznjeApp() {
        try {
            File file = new File("src/com/jojicluka/text/voznjeapp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] split = line.split("\\|");
                String id = split[0];
                String vremePorudzbine = split[1];
                String adresaPolaska = split[2];
                String adresaDestinacije = split[3];
                Musterija musterija = nadjiMusteriju(split[4]);
                Vozac vozac = nadjiVozaca(split[5]);
                int brojKmPredjenih = Integer.parseInt(split[6]);
                int trajanjeVoznje = Integer.parseInt(split[7]);
                StatusVoznje statusVoznje = StatusVoznje.valueOf(split[8]);
                boolean postoji = Boolean.parseBoolean(split[9]);
                String idMusterije = split[10];
                String idVozaca = split[11];
                NacinPorucivanja nacinPorucivanja = NacinPorucivanja.APLIKACIJA;
                String napomena = split[12];
                VoznjaApp voznja = new VoznjaApp(id, vremePorudzbine, adresaPolaska, adresaDestinacije, musterija, vozac, brojKmPredjenih, trajanjeVoznje, statusVoznje, postoji, idMusterije,
                        idVozaca, nacinPorucivanja, napomena);
                voznje.add(voznja);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadVoznjeTel() {
        try{
            File file = new File("src/com/jojicluka/text/voznjetel.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println(line);
                String[] split = line.split("\\|");
                String id = split[0];
                String vremePorudzbine = split[1];
                String adresaPolaska = split[2];
                String adresaDestinacije = split[3];
                Musterija musterija = nadjiMusteriju(split[4]);
                Vozac vozac = nadjiVozaca(split[5]);
                int brojKmPredjenih = Integer.parseInt(split[6]);
                int trajanjeVoznje = Integer.parseInt(split[7]);
                StatusVoznje statusVoznje = StatusVoznje.valueOf(split[8]);
                boolean postoji = Boolean.parseBoolean(split[9]);
                String idMusterije = split[10];
                String idVozaca = split[11];
                VoznjaTel voznja = new VoznjaTel(id, vremePorudzbine, adresaPolaska, adresaDestinacije, musterija, vozac,
                        brojKmPredjenih, trajanjeVoznje, statusVoznje, postoji, idMusterije, idVozaca);
                voznjeTel.add(voznja);

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadPonude(){
        try{
            File file = new File("src/com/jojicluka/text/ponude.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println(line);
                String[] split = line.split("\\|");
                String idVozaca = split[0];
                String vreme = split[1];
                String usernameVozaca = split[2];
                String idVoznje = split[3];
                Ponuda ponuda = new Ponuda(idVozaca, vreme, usernameVozaca, idVoznje);
                ponude.add(ponuda);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
/////////////////////////////////////////////////////
                //RETURN FUNKCIJE//
/////////////////////////////////////////////////////
    public ArrayList<Automobil> sviAutomobili() {
        ArrayList<Automobil> sviAutomobili = new ArrayList<Automobil>();
        for (Automobil automobil : automobili) {
            sviAutomobili.add(automobil);
        }
        return sviAutomobili;
    }

    public ArrayList<VoznjaTel> sveVoznjeTel(){
        ArrayList<VoznjaTel> sveVoznje = new ArrayList<VoznjaTel>();
            for (VoznjaTel voznjaTel : voznjeTel) {
                if(voznjaTel.isPostoji()){
                    sveVoznje.add(voznjaTel);
                }
            }
            return sveVoznje;
        }

    public ArrayList<VoznjaTel> sveVoznjeTelMusterija(String musterijaId){
        ArrayList<VoznjaTel> sveVoznje = new ArrayList<VoznjaTel>();
        for (VoznjaTel voznjaTel : voznjeTel) {
            if(voznjaTel.isPostoji() && voznjaTel.getIdMusterije().equals(musterijaId)){
                sveVoznje.add(voznjaTel);
            }
        }
        return sveVoznje;
    }

    public ArrayList<VoznjaApp> sveVoznjeApp() {
        ArrayList<VoznjaApp> sveVoznje = new ArrayList<VoznjaApp>();
        for (VoznjaApp voznjaApp : voznje) {
            if (voznjaApp.isPostoji()) {
                sveVoznje.add(voznjaApp);
            }
        }
        return sveVoznje;
    }

    public ArrayList<Vozac> sviVozaci(){
        ArrayList<Vozac> sviVozaci = new ArrayList<Vozac>();
        for (Vozac vozac: vozaci) {
            if (vozac.isPostoji()){
                sviVozaci.add(vozac);
            }
        }
        return sviVozaci;
    }

    public ArrayList<VoznjaTel> sveVoznjeDodela(){
        ArrayList<VoznjaTel> dodela = new ArrayList<VoznjaTel>();
        for (VoznjaTel voznjaTel : voznjeTel){
            if(voznjaTel.isPostoji() && voznjaTel.getStatusVoznje().equals(StatusVoznje.KREIRANA)){
                dodela.add(voznjaTel);
            }
        }
        return dodela;
    }

    public ArrayList<VoznjaApp> sveVoznjeCekanje(){
        ArrayList<VoznjaApp> cekanje = new ArrayList<VoznjaApp>();
        for(VoznjaApp voznjaApp : voznje){
            if(voznjaApp.isPostoji() && voznjaApp.getStatusVoznje().equals(StatusVoznje.KREIRANA_NA_CEKANJU)){
                cekanje.add(voznjaApp);
            }
        }
        return cekanje;
    }

    public ArrayList<VoznjaTel> sveVoznjeDodelaId(String vozacId){
        ArrayList<VoznjaTel> dodela = new ArrayList<VoznjaTel>();
        for (VoznjaTel voznjaTel : voznjeTel){
            if(voznjaTel.isPostoji() && voznjaTel.getStatusVoznje().equals(StatusVoznje.DODELJENA) && voznjaTel.getIdVozaca().equals(vozacId)){
                dodela.add(voznjaTel);
            }
        }
        return dodela;
    }

    public ArrayList<VoznjaApp> sveVoznjeDodelaIdApp(String vozacId){
        ArrayList<VoznjaApp> dodela = new ArrayList<VoznjaApp>();
        for ( VoznjaApp voznjaApp : voznje) {
            if (voznjaApp.isPostoji() && voznjaApp.getStatusVoznje().equals(StatusVoznje.DODELJENA) && voznjaApp.getIdVozaca().equals(vozacId)){
                dodela.add(voznjaApp);
            }
        }
        return dodela;
    }

    public ArrayList<VoznjaTel> sveVoznjePrihvaceneId(String vozacId) {
        ArrayList<VoznjaTel> prihvacene = new ArrayList<VoznjaTel>();
        for (VoznjaTel voznjaTel : voznjeTel) {
            if (voznjaTel.isPostoji() && voznjaTel.getStatusVoznje().equals(StatusVoznje.PRIHVACENA) && voznjaTel.getIdVozaca().equals(vozacId)) {
                prihvacene.add(voznjaTel);
            }
        }
        return prihvacene;
    }

    public ArrayList<VoznjaApp> sveVoznjePrihvaceneApp(String vozacId){
        ArrayList<VoznjaApp> prihvacene = new ArrayList<VoznjaApp>();
        for (VoznjaApp voznjaApp : voznje){
            if(voznjaApp.isPostoji() && voznjaApp.getStatusVoznje().equals(StatusVoznje.PRIHVACENA) && voznjaApp.getIdVozaca().equals(vozacId)){
                prihvacene.add(voznjaApp);
            }
        }
        return prihvacene;
    }

    public Integer returnIdVozaca(String ime) {
        String id = new String("");
        int idInt = 0;
        for(Vozac vozac: vozaci){
            if(ime.equals(vozac.getIme())){
                id.equals(vozac.getId());
                idInt = Integer.parseInt(id);
                return idInt;
            }
        }
        return idInt;
    }

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
    ////////////////FUNKCIJE SNIMANJA//////////////////

    public void saveVoznjeTel(){
        try{
            File file = new File("src/com/jojicluka/text/voznjetel.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String s = "";
            for (VoznjaTel voznjaTel : voznjeTel){
                s += voznjaTel.getId() + "|" + voznjaTel.getVremePorudzbine() + "|" + voznjaTel.getAdresaPolaska() + "|" +
                        voznjaTel.getAdresaDestinacije() + "|" + voznjaTel.getMusterija() + "|" + voznjaTel.getVozac() + "|" +
                        voznjaTel.getBrojKmPredjenih() + "|" + voznjaTel.getTrajanjeVoznje() + "|" + voznjaTel.getStatusVoznje() + "|" +
                        voznjaTel.isPostoji() + "|" + voznjaTel.getIdMusterije() + "|" + voznjaTel.getIdVozaca() + "\n";
            }
            bw.write(s);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveVoznjeApp(){
        try{
            File file = new File("src/com/jojicluka/text/voznjeapp.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String s = "";
            for (VoznjaApp voznjaApp : voznje){
                s += voznjaApp.getId() + "|" + voznjaApp.getVremePorudzbine() + "|" + voznjaApp.getAdresaPolaska() + "|" +
                        voznjaApp.getAdresaDestinacije() + "|" + voznjaApp.getMusterija() + "|" + voznjaApp.getVozac() + "|" +
                        voznjaApp.getBrojKmPredjenih() + "|" + voznjaApp.getTrajanjeVoznje() + "|" + voznjaApp.getStatusVoznje() + "|" +
                        voznjaApp.isPostoji() + "|" + voznjaApp.getIdMusterije() + "|" + voznjaApp.getIdVozaca() + "|" + voznjaApp.getNacinPorucivanja() + "|" + voznjaApp.getNapomena() + "\n";
            }
            bw.write(s);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveMusterije() {
        try{
            File file = new File("src/com/jojicluka/text/musterije.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String s = "";
            for (Musterija musterija : musterije) {
                s += musterija.getId() + "|" + musterija.getUsername() + "|" + musterija.getPassword() + "|" + musterija.getIme()
                        + "|" + musterija.getPrezime() + "|" + musterija.getJmbg() + "|" + musterija.getAdress() + "|" + musterija.getPol()
                        + "|" + musterija.getBrTel() + "|" + musterija.isPostoji() + "\n";
            }
            bw.write(s);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveVozace() {
        try{
            File file = new File("src/com/jojicluka/text/vozaci.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String s = "";
            for (Vozac vozac : vozaci) {
                s += vozac.getId() + "|" + vozac.getUsername() + "|" + vozac.getPassword() + "|" + vozac.getIme()
                        + "|" + vozac.getPrezime() + "|" + vozac.getJmbg() + "|" + vozac.getAdress() + "|" + Pol.Muski
                        + "|" + vozac.getBrTel() + "|" + vozac.getPlata() + "|" + vozac.getBrClanskeKarte() + "|" + vozac.isPostoji() + "\n";
            }
            bw.write(s);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveDispecere() {
        try{
            File file = new File("src/com/jojicluka/text/dispeceri.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String s = "";
            for (Dispecer dispecer : dispeceri) {
                s += dispecer.getId() + "|" + dispecer.getUsername() + "|" + dispecer.getPassword() + "|" + dispecer.getIme()
                        + "|" + dispecer.getPrezime() + "|" + dispecer.getJmbg() + "|" + dispecer.getAdress() + "|" + dispecer.getPol()
                        + "|" + dispecer.getBrTel() + "|" + dispecer.getPlata() + "|" + dispecer.getBrTelLinije() + "|" + dispecer.getTelOdeljenje() + "|" + dispecer.isPostoji() + "\n";
            }
            bw.write(s);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveAutomobile() {
        try{
            File file = new File("src/com/jojicluka/text/automobili.txt");
             BufferedWriter bw = new BufferedWriter(new FileWriter(file));
             String s = "";
             for(Automobil automobil : automobili) {
                 s+= automobil.getModel() + "|" + automobil.getProizvodjac() + "|" + automobil.getGodProizvodnje() + "|" +
                         automobil.getBrTablica() + "|" + automobil.getIdVozila() + "|" + automobil.getVrsta() + "|" +
                         automobil.isPostoji() + "|" + automobil.getIdVozaca() + "\n";
             }
             bw.write(s);
             bw.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void savePonude(){
        try{
            File file = new File("src/com/jojicluka/text/ponude.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String s = "";
            for(Ponuda ponuda: ponude){
                s+= ponuda.getIdVozaca() + "|" + ponuda.getVreme() + "|" + ponuda.getUsernameVozaca() + "|" + ponuda.getIdVoznje() + "\n";
            }
            bw.write(s);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
////////////////////////////////////////////////////////////////
    ///////////////// FUNKCIJE AISP-a /////////////////////////

    public ArrayList<Vozac> kombinovanaPretraga(Vozac vozac) {
        ArrayList<Vozac> returnIme = new ArrayList<>();
        ArrayList<Vozac> returnPrezime = new ArrayList<>();
        ArrayList<Vozac> returnPlata = new ArrayList<>();
        ArrayList<Vozac> returnAutomobil = new ArrayList<>();

        for(Vozac vozac1 : vozaci) {
            if(vozac.getIme() == null || vozac.getIme().equals("")){
                returnIme = vozaci;
                break;
            }
            if (vozac1.getIme().toLowerCase(Locale.ROOT).contains(vozac.getIme().toLowerCase(Locale.ROOT))){
                returnIme.add(vozac1);
                System.out.println(returnIme);
            }
        }

        for(Vozac vozac1 : vozaci) {
            if(vozac.getPrezime() == null || vozac.getPrezime().equals("")){
                returnPrezime = vozaci;
                break;
            }
            if (vozac1.getPrezime().toLowerCase(Locale.ROOT).contains(vozac.getPrezime().toLowerCase(Locale.ROOT))){
                returnPrezime.add(vozac1);
                System.out.println("Usao sam u prezime");
            }
        }

        for(Vozac vozac1 : vozaci){
            if(vozac.getPlata() == 0){
                returnPlata = vozaci;
                break;
            }
            if(vozac1.getPlata() == vozac.getPlata()){
                returnPlata.add(vozac1);
                System.out.println("Usao sam u plate");
            }
        }

//        for(Automobil automobil: automobili) {
  //          if(vozac.getIdVozila() == -1) {
    //            continue;
      //      }
      //  }
        System.out.println("Imena: "+ returnIme);
        System.out.println("Prezimena "+ returnPrezime);
        System.out.println("Plate " + returnPlata);
       returnIme.retainAll(returnPrezime);
       returnIme.retainAll(returnPlata);

       return returnIme;
    }

    public String returnVozacIdAukcija(String idVoznje){
        try {
            System.out.println(idVoznje);
            ArrayList<Ponuda> odgovarajucePonude = new ArrayList<Ponuda>();
            for(Ponuda ponuda : ponude) {
                if(ponuda.getIdVoznje().equals(idVoznje)){
                    odgovarajucePonude.add(ponuda);
                }
            }
            System.out.println(odgovarajucePonude);
            Collections.sort(odgovarajucePonude);
            System.out.println(odgovarajucePonude);
            Ponuda glavnaPonuda = odgovarajucePonude.get(0);
            String idVozaca = glavnaPonuda.getIdVozaca();
            return idVozaca;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    }

