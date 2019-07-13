import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fahrer
{
  //-------------------------------------------------------------------------
  //  Vars
  //-------------------------------------------------------------------------
    @Id @GeneratedValue
    private int fahrerId;
    private String fahrerVorname;
    private String fahrerNachname;
    private int fahrerAlter;
    private double fahrerGehalt;


  //-------------------------------------------------------------------------
  //  Constructor(s)
  //-------------------------------------------------------------------------
    public Fahrer() { }

    public Fahrer(int id, String vn, String na, int alter, double fahrerGehalt )
    {
        this.fahrerId = id;
        this.fahrerVorname = vn;
        this.fahrerNachname = na;
        this.fahrerAlter = alter;
        this.fahrerGehalt   = fahrerGehalt;
    }


    public Fahrer(int id, String vn, String na)
    {
        this.fahrerId = id;
        this.fahrerVorname = vn;
        this.fahrerNachname = na;
    }


  //-------------------------------------------------------------------------
  //  Get / Set
  //-------------------------------------------------------------------------
    public int getFahrerId() { return this.fahrerId; }

    public void setFahrerId(int id) { this.fahrerId = id; }

    public String getFahrerVorname() { return this.fahrerVorname; }

    public String getFahrerNachname() { return this.fahrerNachname; }

    public int getFahrerAlter() { return this.fahrerAlter; }

    public double getGehalt() { return this.fahrerGehalt; }

    public void setFahrerVorname(String fahrerVorname) { this.fahrerVorname = fahrerVorname; }

    public void setFahrerNachname(String fahrerNachname) { this.fahrerNachname = fahrerNachname; }

    public void setFahrerAlter(int fahrerAlter) { this.fahrerAlter = fahrerAlter; }

    public void setGehalt(int fahrerGehalt) { this.fahrerGehalt = fahrerGehalt; }


  //-------------------------------------------------------------------------
  //  toString()
  //-------------------------------------------------------------------------
    @Override
    public String toString()
    {
        return "Fahrer{" + "fahrerId=" + fahrerId + ", fahrerVorname='" + fahrerVorname + '\'' + ", fahrerNachname='" + fahrerNachname + '\'' + ", fahrerAlter=" + fahrerAlter + ", fahrerGehalt=" + fahrerGehalt  + '}';
    }



}
