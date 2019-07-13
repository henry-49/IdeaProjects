package com.hardware;

public class Rechner extends Hardware{
    private String imagepfad;

    public Rechner(int id, String typ, String seriennummer, String hersteller, String modell, int status, String imagepfad) {
        super(id, typ, seriennummer, hersteller, modell, status);
        this.imagepfad = imagepfad;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void  neuesImage(String pfad){

    }
}
