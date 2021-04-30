package com.jojicluka.classes;

public class Korisnik {
    private String username;
    private String password;
    private String ime;
    private String prezime;
    private long jmbg;
    private String adress;
    private String pol;
    private long brTel;

    public Korisnik(){

    }

    public Korisnik(String username, String password, String ime, String prezime, long jmbg, String adress, String pol, long brTel) {
        super();
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.adress = adress;
        this.pol = pol;
        this.brTel = brTel;
    }

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

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public long getBrTel() {
        return brTel;
    }

    public void setBrTel(long brTel) {
        this.brTel = brTel;
    }

    public static void verifyLogin(){
        //
    }


}


