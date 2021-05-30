package com.jojicluka.classes;

public class Voznja {

    public Voznja(String vremePorudzbine, String adresaPolaska, String adresaDestinacije, String musterija, String vozac, int brojKmPredjenih, int trajanjeVoznje, byte statusVoznje) {
        this.vremePorudzbine = vremePorudzbine;
        this.adresaPolaska = adresaPolaska;
        this.adresaDestinacije = adresaDestinacije;
        this.musterija = musterija;
        this.vozac = vozac;
        this.brojKmPredjenih = brojKmPredjenih;
        this.trajanjeVoznje = trajanjeVoznje;
        this.statusVoznje = statusVoznje;
    }

    public Voznja(){

    }

    private String vremePorudzbine;
    private String adresaPolaska;
    private String adresaDestinacije;
    private String musterija;
    private String vozac;
    private int brojKmPredjenih;
    private int trajanjeVoznje;
    private byte statusVoznje;

    public String getVremePorudzbine() {
        return vremePorudzbine;
    }

    public void setVremePorudzbine(String vremePorudzbine) {
        this.vremePorudzbine = vremePorudzbine;
    }

    public String getAdresaPolaska() {
        return adresaPolaska;
    }

    public void setAdresaPolaska(String adresaPolaska) {
        this.adresaPolaska = adresaPolaska;
    }

    public String getAdresaDestinacije() {
        return adresaDestinacije;
    }

    public void setAdresaDestinacije(String adresaDestinacije) {
        this.adresaDestinacije = adresaDestinacije;
    }

    public String getMusterija() {
        return musterija;
    }

    public void setMusterija(String musterija) {
        this.musterija = musterija;
    }

    public String getVozac() {
        return vozac;
    }

    public void setVozac(String vozac) {
        this.vozac = vozac;
    }

    public int getBrojKmPredjenih() {
        return brojKmPredjenih;
    }

    public void setBrojKmPredjenih(int brojKmPredjenih) {
        this.brojKmPredjenih = brojKmPredjenih;
    }

    public int getTrajanjeVoznje() {
        return trajanjeVoznje;
    }

    public void setTrajanjeVoznje(int trajanjeVoznje) {
        this.trajanjeVoznje = trajanjeVoznje;
    }

    public byte getStatusVoznje() {
        return statusVoznje;
    }

    public void setStatusVoznje(byte statusVoznje) {
        this.statusVoznje = statusVoznje;
    }
}
