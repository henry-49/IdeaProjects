package com.hardware;

public class Drucker extends Hardware {
    private String betrebsmi
    public Drucker(int id, String typ, String seriennummer, String hersteller, String modell, int status) {
        super(id, typ, seriennummer, hersteller, modell, status);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
