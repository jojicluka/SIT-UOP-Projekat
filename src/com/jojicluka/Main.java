package com.jojicluka;

import com.jojicluka.automobili.Automobil;
import com.jojicluka.taxisluzba.TaxiSluzba;
import com.jojicluka.gui.Login;
import com.jojicluka.voznje.Voznja;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TaxiSluzba taxisluzba = new TaxiSluzba();


        for (Automobil automobil : taxisluzba.sviAutomobili()) {
            System.out.println(automobil);
        }
        Login login = new Login(taxisluzba);
        login.setVisible(true);
        // TaxiSluzba.login();
    }
}


