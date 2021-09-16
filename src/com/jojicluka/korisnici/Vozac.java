package com.jojicluka.korisnici;


public class Vozac extends Korisnik {
    public Vozac(){
    }

    public Vozac(String id,String username, String password, String ime, String prezime, long jmbg, String adress, Pol pol, long brTel, int plata, int brClanskeKarte, boolean postoji) {
        super(id, username, password, ime, prezime, jmbg, adress, pol, brTel);
        this.plata = plata;
        this.brClanskeKarte = brClanskeKarte;
        this.postoji = postoji;

    }
   public Vozac(String ime, String prezime, int plata, int idVozila){
        super(ime,prezime);
        this.plata = plata;
        this.idVozila = idVozila;
   }

    private int plata;
    private int brClanskeKarte;
    private int idVozila;
    private boolean postoji;


    public boolean isPostoji() {
        return postoji;
    }

    public void setPostoji(boolean postoji) {
        this.postoji = postoji;
    }

    public int getIdVozila(){
        return idVozila;
    }

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
