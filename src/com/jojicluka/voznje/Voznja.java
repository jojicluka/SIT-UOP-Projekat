package com.jojicluka.voznje;

import java.util.GregorianCalendar;
import com.jojicluka.korisnici.Musterija;
import com.jojicluka.korisnici.Vozac;

public abstract class Voznja {

    protected String id;
    protected String vremePorudzbine;
    protected String adresaPolaska;
    protected String adresaDestinacije;
    protected Musterija musterija;
    protected Vozac vozac;
    protected int brojKmPredjenih;
    protected int trajanjeVoznje;
    protected StatusVoznje statusVoznje;
    protected boolean postoji;
    protected String idMusterije;
    protected String idVozaca;



    public Voznja(String id, String vremePorudzbine, String adresaPolaska, String adresaDestinacije, Musterija musterija, Vozac vozac, int brojKmPredjenih, int trajanjeVoznje, StatusVoznje statusVoznje, boolean postoji, String idMusterije, String idVozaca) {
        this.id = id;
        this.vremePorudzbine = vremePorudzbine;
        this.adresaPolaska = adresaPolaska;
        this.adresaDestinacije = adresaDestinacije;
        this.musterija = new Musterija();
        this.vozac = new Vozac();
        this.brojKmPredjenih = brojKmPredjenih;
        this.trajanjeVoznje = trajanjeVoznje;
        this.statusVoznje = statusVoznje;
        this.postoji = postoji;
        this.idMusterije = idMusterije;
        this.idVozaca = idVozaca;
    }

    public Voznja(String id, String vremePorudzbine, String adresaPolaska, String adresaDestinacije, int brojKmPredjenih, int trajanjeVoznje, StatusVoznje statusVoznje, boolean postoji, String idMusterije, String idVozaca){
        this.id = "";
        this.vremePorudzbine = "";
        this.adresaPolaska = "";
        this.adresaDestinacije = "";
        this.brojKmPredjenih = 0;
        this.trajanjeVoznje = 0;
        this.statusVoznje = StatusVoznje.KREIRANA;
        this.postoji = true;
        this.idMusterije = "";
        this.idVozaca = "";
    }

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

    public Musterija getMusterija() {
        return musterija;
    }

    public void setMusterija(Musterija musterija) {
        this.musterija = musterija;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
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

    public StatusVoznje getStatusVoznje() {
        return statusVoznje;
    }

    public void setStatusVoznje(StatusVoznje statusVoznje) {
        this.statusVoznje = statusVoznje;
    }

    public boolean isPostoji() {return postoji;}

    public void setPostoji(boolean postoji) {this.postoji = postoji;}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getIdMusterije() {
        return idMusterije;
    }

    public void setIdMusterije(String idMusterije) {
        this.idMusterije = idMusterije;
    }

    public String getIdVozaca() {
        return idVozaca;
    }

    public void setIdVozaca(String idVozaca) {
        this.idVozaca = idVozaca;
    }

}
