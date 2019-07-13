

public class Fahrer
{
  //-------------------------------------------------------------------------
  //  Vars
  //-------------------------------------------------------------------------
    private int fahrerId;
    private String vorname;
    private String nachname;
    private int fahrerAlter;
    private double gehalt;


  //-------------------------------------------------------------------------
  //  Constructor(s)
  //-------------------------------------------------------------------------
    public Fahrer(int id, String vn, String na, int alter, double fahrerGehalt )
    {
        this.fahrerId = id;
        this.vorname = vn;
        this.nachname = na;
        this.fahrerAlter = alter;
        this.gehalt = fahrerGehalt;
    }


    public Fahrer(int id, String vn, String na)
    {
        this.fahrerId = id;
        this.vorname = vn;
        this.nachname = na;
    }


  //-------------------------------------------------------------------------
  //  Get / Set
  //-------------------------------------------------------------------------
    public int getFahrerId() { return this.fahrerId; }

    public void setFahrerId(int id) { this.fahrerId = id; }

    public String getVorname() { return this.vorname; }

    public String getNachname() { return this.nachname; }

    public int getFahrerAlter() { return this.fahrerAlter; }

    public double getGehalt() { return this.gehalt; }

    public void setVorname(String vorname) { this.vorname = vorname; }

    public void setNachname(String nachname) { this.nachname = nachname; }

    public void setFahrerAlter(int fahrerAlter) { this.fahrerAlter = fahrerAlter; }

    public void setGehalt(int fahrerGehalt) { this.gehalt = fahrerGehalt; }


  //-------------------------------------------------------------------------
  //  toString()
  //-------------------------------------------------------------------------
    @Override
    public String toString()
    {
        return "Fahrer{" + "fahrerId=" + fahrerId + ", vorname='" + vorname + '\'' + ", nachname='" + nachname + '\'' + ", fahrerAlter=" + fahrerAlter + ", gehalt=" + gehalt + '}';
    }



}
