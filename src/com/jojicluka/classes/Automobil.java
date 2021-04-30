package com.jojicluka.classes;

import java.util.ArrayList;

public class Automobil {
    public Automobil(){

    }

    public Automobil(String model, String proizvodjac, int godProizvodnje, String brTablica, byte idVozila, byte vrsta) {
        this.model = model;
        this.proizvodjac = proizvodjac;
        this.godProizvodnje = godProizvodnje;
        this.brTablica = brTablica;
        this.idVozila = idVozila;
        this.vrsta = vrsta;
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

    private String model;
    private String proizvodjac;
    private int godProizvodnje;
    private String brTablica;
    private byte idVozila;
    private byte vrsta;


}
