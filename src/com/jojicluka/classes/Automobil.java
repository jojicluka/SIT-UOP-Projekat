package com.jojicluka.classes;

public class Automobil {
    public Automobil(){

    }

    public Automobil(String model, String proizvodjac, String godProizvodnje, String brTablica, String idVozila, byte vrsta) {
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

    public String getGodProizvodnje() {
        return godProizvodnje;
    }

    public void setGodProizvodnje(String godProizvodnje) {
        this.godProizvodnje = godProizvodnje;
    }

    public String getBrTablica() {
        return brTablica;
    }

    public void setBrTablica(String brTablica) {
        this.brTablica = brTablica;
    }

    public String getIdVozila() {
        return idVozila;
    }

    public void setIdVozila(String idVozila) {
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
    private String godProizvodnje;
    private String brTablica;
    private String idVozila;
    private byte vrsta;
}
