package com.jojicluka.korisnici;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public abstract class Korisnik {
    protected String id;
    protected String username;
    protected String password;
    protected String ime;
    protected String prezime;
    protected long jmbg;
    protected String adress;
    protected Pol pol;
    protected long brTel;

    public Korisnik(){

    }

    public Korisnik(String id,String username, String password, String ime, String prezime, long jmbg, String adress, Pol pol, long brTel) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.adress = adress;
        this.pol = null;
        this.brTel = brTel;
    }

    public Korisnik(String ime, String prezime){
        this.ime = ime;
        this.prezime = prezime;
    }

    public Korisnik(String id){
        this.id=id;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public long getJmbg() {
        return jmbg;
    }

    public void setJmbg(long jmbg) {
        this.jmbg = jmbg;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public long getBrTel() {
        return brTel;
    }

    public void setBrTel(long brTel) {
        this.brTel = brTel;
    }

    public static boolean verifyLogin(String userCheck, String passCheck){
        try{
            File file = new File("src/com/jojicluka/text/musterije.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\\|");
                if((userCheck.equals(split[0])) && (passCheck.equals(split[1]))){
                    return true;
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Greska u verifikovanju logina!");
            return false;
        }
        return false;
    }


}


