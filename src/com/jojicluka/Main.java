package com.jojicluka;

import com.jojicluka.classes.TaxiSluzba;

public class Main {

    public static void main(String[] args) {
        TaxiSluzba.loadAutomobile();
        TaxiSluzba.loadMusterije();
        TaxiSluzba.loadDispecere();
        TaxiSluzba.loadVozace();
        TaxiSluzba.login();
    }
}


