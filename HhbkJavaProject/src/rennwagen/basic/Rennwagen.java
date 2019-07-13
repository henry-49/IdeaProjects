package rennwagen.basic;

public class Rennwagen {
    private int    id;
    private String modell;
    private String hersteller;
    private int    leistung;
    private int    hubraum;
    private float  isttankinhalt;
    private float  maxtankinhalt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public int getLeistung() {
        return leistung;
    }

    public void setLeistung(int leistung) {
        this.leistung = leistung;
    }

    public int getHubraum() {
        return hubraum;
    }

    public void setHubraum(int hubraum) {
        this.hubraum = hubraum;
    }

    public float getIsttankinhalt() {
        return isttankinhalt;
    }

    public void setIsttankinhalt(float isttankinhalt) {
        this.isttankinhalt = isttankinhalt;
    }

    public float getMaxtankinhalt() {
        return maxtankinhalt;
    }

    public void setMaxtankinhalt(float maxtankinhalt) {
        this.maxtankinhalt = maxtankinhalt;
    }

    @Override
    public String toString() {
        return   id +
                "," + modell + '\'' +
                "," + hersteller + '\'' +
                "," + leistung +
                "," + hubraum +
                "," + isttankinhalt +
                "," + maxtankinhalt;
    }
}
