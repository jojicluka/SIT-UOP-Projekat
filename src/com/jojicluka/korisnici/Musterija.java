package com.jojicluka.korisnici;


public class Musterija extends Korisnik {


    private boolean postoji;

    public Musterija(String id, String username, String password, String ime, String prezime, long jmbg, String adress, Pol pol, long brTel, boolean postoji) {
        super(id, username, password, ime, prezime, jmbg, adress, pol, brTel);
        this.postoji = postoji;
    }
    public Musterija(){

    }

    public boolean isPostoji() {
        return postoji;
    }

    public void setPostoji(boolean postoji) {this.postoji = postoji;}
}
