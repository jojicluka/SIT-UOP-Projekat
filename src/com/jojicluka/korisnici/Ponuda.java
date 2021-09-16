package com.jojicluka.korisnici;

public class Ponuda implements Comparable<Ponuda>{
    private String idVozaca;
    private String vreme;
    private String usernameVozaca;
    private String idVoznje;

    public Ponuda(String idVozaca, String vreme, String usernameVozaca, String idVoznje) {
        this.idVozaca = idVozaca;
        this.vreme = vreme;
        this.usernameVozaca = usernameVozaca;
        this.idVoznje = idVoznje;
    }

    public String getIdVozaca() {
        return idVozaca;
    }

    public void setIdVozaca(String idVozaca) {
        this.idVozaca = idVozaca;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public String getUsernameVozaca() {
        return usernameVozaca;
    }

    public void setUsernameVozaca(String usernameVozaca) {
        this.usernameVozaca = usernameVozaca;
    }

    public String getIdVoznje() {
        return idVoznje;
    }

    public void setIdVoznje(String idVoznje) {
        this.idVoznje = idVoznje;
    }

    public int compareTo(Ponuda drugaPonuda) {
        return Integer.compare(Integer.parseInt(getVreme()), Integer.parseInt(drugaPonuda.getVreme()));
    }
}
