package com.jojicluka.classes;

public class TaxiSluzba {
    public TaxiSluzba(){

    }

    public TaxiSluzba(long pib, String naziv, String adress, int cenaStartaVoznje, int cenaPoKilometru) {
        this.pib = pib;
        this.naziv = naziv;
        this.adress = adress;
        this.cenaStartaVoznje = cenaStartaVoznje;
        this.cenaPoKilometru = cenaPoKilometru;
    }

    public long getPib() {
        return pib;
    }

    public void setPib(long pib) {
        this.pib = pib;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getCenaStartaVoznje() {
        return cenaStartaVoznje;
    }

    public void setCenaStartaVoznje(int cenaStartaVoznje) {
        this.cenaStartaVoznje = cenaStartaVoznje;
    }

    public int getCenaPoKilometru() {
        return cenaPoKilometru;
    }

    public void setCenaPoKilometru(int cenaPoKilometru) {
        this.cenaPoKilometru = cenaPoKilometru;
    }

    private long pib;
    private String naziv;
    private String adress;
    private int cenaStartaVoznje;
    private int cenaPoKilometru;

}
