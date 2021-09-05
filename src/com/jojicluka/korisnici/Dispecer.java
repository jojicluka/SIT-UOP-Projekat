package com.jojicluka.korisnici;


public class Dispecer extends Korisnik {
    public Dispecer(String id, String username, String password, String ime, String prezime, long jmbg, String adress, Pol pol, long brTel, int plata, int brTelLinije, int telOdeljenje, boolean postoji) {
        super(id, username, password, ime, prezime, jmbg, adress, pol, brTel);
        this.plata = plata;
        this.brTelLinije = brTelLinije;
        this.telOdeljenje = telOdeljenje;
        this.postoji = postoji;
    }
    public Dispecer(){

    }



    private int plata;
    private int brTelLinije;
    private int telOdeljenje;
    private boolean postoji;

    public Dispecer(String ime, String username, String prezime, String username1, Pol pol, String adress, int telOdeljenje, int brTelLinije, long brTel, long brTel1, String password) {
    }

    public boolean isPostoji() {
        return postoji;
    }

    public void setPostoji(boolean postoji) {
        this.postoji = postoji;
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
