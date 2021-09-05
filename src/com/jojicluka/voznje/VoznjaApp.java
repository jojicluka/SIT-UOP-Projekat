package com.jojicluka.voznje;

import com.jojicluka.korisnici.Musterija;
import com.jojicluka.korisnici.Vozac;
import java.util.GregorianCalendar;

public class VoznjaApp extends Voznja{

    private final NacinPorucivanja nacinPorucivanja = NacinPorucivanja.APLIKACIJA;
    private String napomena;

    public VoznjaApp(String id, String vremePorudzbine, String adresaPolaska, String adresaDestinacije, Musterija musterija, Vozac vozac, int brojKmPredjenih, int trajanjeVoznje, StatusVoznje statusVoznje, boolean postoji, String idMusterije, String idVozaca, NacinPorucivanja nacinPorucivanja, String napomena){
        super(id, vremePorudzbine, adresaPolaska, adresaDestinacije, musterija, vozac, brojKmPredjenih, trajanjeVoznje, statusVoznje, postoji, idMusterije, idVozaca);
        this.napomena = napomena;
    }

    public String getNapomena() {return napomena;}

    public void setNapomena(String napomena) {this.napomena = napomena;}

    public NacinPorucivanja getNacinPorucivanja() {return nacinPorucivanja;}
}
