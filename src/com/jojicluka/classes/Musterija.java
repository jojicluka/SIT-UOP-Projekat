package com.jojicluka.classes;

public class Musterija extends Korisnik{
    public Musterija(){

    }

    public Musterija(String username, String password, String ime, String prezime, long jmbg, String adress, String pol, long brTel) {
        super(username, password, ime, prezime, jmbg, adress, pol, brTel);
    }
}
