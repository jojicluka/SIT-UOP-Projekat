package com.jojicluka.classes;

public class Vozac extends Korisnik{
    public Vozac(){
    }

    public Vozac(String username, String password, String ime, String prezime, long jmbg, String adress, String pol, long brTel, int plata, int brClanskeKarte) {
        super(username, password, ime, prezime, jmbg, adress, pol, brTel);
        this.plata = plata;
        this.brClanskeKarte = brClanskeKarte;
    }

    private int plata;
    private int brClanskeKarte;

    public int getPlata() {
        return plata;
    }

    public void setPlata(int plata) {
        this.plata = plata;
    }

    public int getBrClanskeKarte() {
        return brClanskeKarte;
    }

    public void setBrClanskeKarte(int brClanskeKarte) {
        this.brClanskeKarte = brClanskeKarte;
    }
}
