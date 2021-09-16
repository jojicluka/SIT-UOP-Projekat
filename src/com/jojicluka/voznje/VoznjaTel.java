package com.jojicluka.voznje;

import com.jojicluka.korisnici.Musterija;
import com.jojicluka.korisnici.Vozac;


public class VoznjaTel extends Voznja {
    private final NacinPorucivanja nacinPorucivanja = NacinPorucivanja.TELEFON;

    public VoznjaTel(String id, String vremePorudzbine, String adresaPolaska, String adresaDestinacije,
                     Musterija musterija, Vozac vozac, int brojKmPredjenih, int trajanjeVoznje, StatusVoznje statusVoznje, boolean postoji, String idMusterije, String idVozaca){
        super(id, vremePorudzbine, adresaPolaska, adresaDestinacije, musterija, vozac, brojKmPredjenih, trajanjeVoznje, statusVoznje, postoji, idMusterije, idVozaca);

    }
}