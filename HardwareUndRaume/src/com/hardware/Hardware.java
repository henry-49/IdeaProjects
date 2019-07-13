package com.hardware;

public class Hardware {
    private int id;
    private String typ;
    private String seriennummer;
    private String hersteller;
    private String modell;
    private int status;

    public Hardware(int id, String typ, String seriennummer, String hersteller, String modell, int status) {
        this.id = id;
        this.typ = typ;
        this.seriennummer = seriennummer;
        this.hersteller = hersteller;
        this.modell = modell;
        this.status = status;
    }

    public String toString(){
        return "Hardware[" +
                "ID: "+id+ "\n," +
                "Type: "+typ+"\n, Seriennummer: "
                +seriennummer+"\n, Hersteller: "+hersteller+"\n, Modell: "
                +modell+"\n,Status: "+status+"]";
    }

    public void wechsleRaum(int raum){

    }


}
