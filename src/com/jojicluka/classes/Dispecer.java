package com.jojicluka.classes;

public class Dispecer extends Korisnik{
    public Dispecer(){

    }

    public Dispecer(String username, String password, String ime, String prezime, long jmbg, String adress, String pol, long brTel, int plata, int brTelLinije, int telOdeljenje) {
        super(username, password, ime, prezime, jmbg, adress, pol, brTel);
        this.plata = plata;
        this.brTelLinije = brTelLinije;
        this.telOdeljenje = telOdeljenje;
    }

    private int plata;
    private int brTelLinije;
    private int telOdeljenje;

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
