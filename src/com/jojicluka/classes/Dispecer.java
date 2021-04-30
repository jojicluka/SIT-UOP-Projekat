package com.jojicluka.classes;

public class Dispecer extends Korisnik{
    public Dispecer(String username, String password, String ime, String prezime, long jmbg, String adress, String pol, long brTel, int plata, int brTelLinije, int telOdeljenje) {
        super(username, password, ime, prezime, jmbg, adress, pol, brTel);
        this.plata = plata;
        this.brTelLinije = brTelLinije;
        this.telOdeljenje = telOdeljenje;
    }
    public Dispecer(){

    }



    private int plata;
    private int brTelLinije;
    private int telOdeljenje;

    public Dispecer(String ime, String username, String prezime, String username1, String pol, String adress, int telOdeljenje, int brTelLinije, long brTel, long brTel1, String password) {
    }

    public int getPlata() {
        return plata;
    }

    public void setPlata(int plata) {
        this.plata = plata;
    }

    public int getBrTelLinije() {
        return brTelLinije;
    }

    public void setBrTelLinije(int brTelLinije) {
        this.brTelLinije = brTelLinije;
    }

    public int getTelOdeljenje() {
        return telOdeljenje;
    }

    public void setTelOdeljenje(int telOdeljenje) {
        this.telOdeljenje = telOdeljenje;
    }
}
