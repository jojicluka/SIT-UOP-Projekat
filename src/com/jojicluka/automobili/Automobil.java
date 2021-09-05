package com.jojicluka.automobili;

import java.util.ArrayList;

public class Automobil {
    public Automobil(){

    }

    public Automobil(String model, String proizvodjac, int godProizvodnje, String brTablica, byte idVozila, byte vrsta, boolean postoji, int idVozaca) {
        this.model = model;
        this.proizvodjac = proizvodjac;
        this.godProizvodnje = godProizvodnje;
        this.brTablica = brTablica;
        this.idVozila = idVozila;
        this.vrsta = vrsta;
        this.postoji = postoji;
        this.idVozaca = idVozaca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public int getGodProizvodnje() {
        return godProizvodnje;
    }

    public void setGodProizvodnje(int godProizvodnje) {
        this.godProizvodnje = godProizvodnje;
    }

    public String getBrTablica() {
        return brTablica;
    }

    public void setBrTablica(String brTablica) {
        this.brTablica = brTablica;
    }

    public byte getIdVozila() {
        return idVozila;
    }

    public void setIdVozila(byte idVozila) {
        this.idVozila = idVozila;
    }

    public byte getVrsta() {
        return vrsta;
    }

    public void setVrsta(byte vrsta) {
        this.vrsta = vrsta;
    }

    public boolean isPostoji() {
        return postoji;
    }

    public void setPostoji(boolean postoji) {
        this.postoji = postoji;
    }

    public int getIdVozaca() {
        return idVozaca;
    }

    public void setIdVozaca(int idVozaca) {
        this.idVozaca = idVozaca;
    }

    private String model;
    private String proizvodjac;
    private int godProizvodnje;
    private String brTablica;
    private byte idVozila;
    private byte vrsta;
    private boolean postoji;
    private int idVozaca;


/*    @Override
    public String toString(){
        return "Automobil =" + " id: " + idVozila + ", model: " + model + ", proizvodjac: " + proizvodjac + ", godina proizvodnje: " +
                godProizvodnje + ", broj tablica: " + brTablica + ", vrsta vozila: " + vrsta + ", postoji: " + postoji +
                ", id vozaca: " + idVozaca;
     }*/

}
