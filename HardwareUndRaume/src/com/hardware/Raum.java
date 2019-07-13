package com.hardware;

public class Raum {
    private int raumid;
    private String bezeichung;
    private String typ;
    private int anzahlArbeitsplaetze;


    public String toString(){
        return "["+raumid+ ","+bezeichung+","+typ+", "+anzahlArbeitsplaetze+"]";
    }
}
