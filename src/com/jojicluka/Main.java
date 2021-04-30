package com.jojicluka;

import com.jojicluka.classes.TaxiSluzba;

public class Main {

    public static void main(String[] args) {
        TaxiSluzba.loadAutomobile();
        TaxiSluzba.loadKorisnike();
        TaxiSluzba.loadDispecere();
        TaxiSluzba.login();
    }
}


