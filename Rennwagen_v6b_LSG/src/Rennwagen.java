import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rennwagen
{
  //-------------------------------------------------------------------------
  //  Vars
  //-------------------------------------------------------------------------
  @Id
    private int    id;
    private String    modell;
    private String    hersteller;
    private int       leistung;
    private int       hubraum;
    private float     isttankinhalt;
    private float     maxtankinhalt;
    // private ArrayList meinefahrer = new ArrayList();


  //-------------------------------------------------------------------------
  //  Constructor(s)
  //-------------------------------------------------------------------------
    public Rennwagen()
    {
        this.maxtankinhalt = 5;
        this.isttankinhalt = 5;
    }

    public Rennwagen(int id, String modell, String hersteller)
    {
        this();
        this.id         = id;
        this.modell     = modell;
        this.hersteller = hersteller;
    }

    public Rennwagen(int id, String modell, String hersteller, float  maxtankinhalt)
    {
        this(id,modell,hersteller);
        this.maxtankinhalt = maxtankinhalt;
    }

    public Rennwagen(int id, String modell, String hersteller, int leistung, int hubraum, float  maxTankinhalt, float istTankinhalt)
    {
        this(id,modell,hersteller,maxTankinhalt);
        this.leistung = leistung;
        this.hubraum = hubraum;
        this.setIsttankinhalt(istTankinhalt);
    }


  //-------------------------------------------------------------------------
  //  Get / Set
  //-------------------------------------------------------------------------
    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    public String getModell() { return this.modell; }

    public void setModell(String modell) { this.modell = modell; }

    public String getHersteller() { return this.hersteller; }

    public void setHersteller(String hersteller) { this.hersteller = hersteller; }

    public int getLeistung() { return this.leistung; }

    public void setLeistung(int leistung) { this.leistung = leistung; }

    public int getHubraum() { return this.hubraum; } // Kubikzentimeter

    public void setHubraum(int hubraum) { this.hubraum = hubraum; } // Kubikzentimeter

    public float getIsttankinhalt() { return this.isttankinhalt; }

    public void setIsttankinhalt(float isttankinhalt)
    {
        if (isttankinhalt <= this.getMaxtankinhalt())
        {
            this.isttankinhalt = isttankinhalt;
        }
        else
        {
            this.isttankinhalt = this.getMaxtankinhalt();
            System.out.println("Tank läuft über!");
        }
    }

    public float getMaxtankinhalt() { return this.maxtankinhalt; }

    public void setMaxtankinhalt(float maxtankinhalt) { this.maxtankinhalt = maxtankinhalt; }

    public void fahren(float gefahrenekilometer,float durchschnittsverbrauch)
    {
        // Durchschnittsverbrauch = liter pro 100 km
        float verbrauch = gefahrenekilometer * durchschnittsverbrauch / 100;

        if (verbrauch >= this.getIsttankinhalt())
        {
            this.setIsttankinhalt(0);
            System.out.println("Tank leer. Sie sind leider liegen geblieben!");
        }
        else
        {
            this.setIsttankinhalt(this.getIsttankinhalt() - verbrauch);
        }
    }

    public void tanken(float liter) { this.setIsttankinhalt(this.getIsttankinhalt() + liter); }

    /*
    public void einfuegenFahrer(Fahrer einfahrer) { meinefahrer.add(einfahrer); }

    public void einfuegenFahrer(Fahrer einfahrer, int index) { meinefahrer.add(index, einfahrer); }

    public void loescheFahrer(int index) { meinefahrer.remove(index); }

    public void druckeFahrerliste()
    {
        System.out.println("Fahrer des Wagens " + this.id + ":\n\n");

        for(int i = 0; i < this.meinefahrer.size(); i++)
        {
            ((Fahrer)this.meinefahrer.get(i)).getInfo();
            System.out.println();
        }
    }
    */

  //-------------------------------------------------------------------------
  //  toString()
  //-------------------------------------------------------------------------
    public String toString() {

        return this.getId()             + "," +
                this.getModell()         + "," +
                this.getHersteller()     + "," +
                this.getLeistung()       + "," +
                this.getHubraum()        + "," +
                this.getMaxtankinhalt()  + "," +
                this.getIsttankinhalt()  + ",";
    }



}
