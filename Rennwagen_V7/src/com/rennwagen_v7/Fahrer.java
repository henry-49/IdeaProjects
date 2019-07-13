package com.rennwagen_v7;


public class Fahrer 
{
    private int    fahrerid;
    private String vorname;
    private String name;
    private int    alter;
    private double gehalt;
    
    /**
     * @param id
     * @param vn
     * @param na
     * @param alter
     * @param gehalt
     */
    public Fahrer(int    id, 
                  String vn, 
                  String na, 
                  int    alter, 
                  double gehalt)
    {
        this.fahrerid = id;
        this.vorname  = vn;
        this.name     = na;
        this.alter    = alter;
        this.gehalt   = gehalt;
    }
    
    /**
     * @param id
     * @param vn
     * @param na
     */
    public Fahrer(int    id, 
                  String vn, 
                  String na)
    {
        this.fahrerid = id;
        this.vorname  = vn;
        this.name     = na;
    }

    /**
     * @return
     */
    public int getId()
    {
        return this.fahrerid;
    }

    /**
     * @return
     */
    public String getVorname()
    {
        return this.vorname;
    }

    /**
     * @return
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @return
     */
    public int getAlter()
    {
        return this.alter;
    }

    /**
     * @return
     */
    public double getGehalt()
    {
        return this.gehalt;
    }

    /**
     * @param vorname
     */
    public void setVorname(String vorname)
    {
        this.vorname = vorname;
    }

    /**
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @param alter
     */
    public void setAlter(int alter)
    {
        this.alter = alter;
    }
    
    /**
     * @param gehalt
     */
    public void setGehalt(int gehalt)
    {
        this.gehalt = gehalt;
    }

    /**
     *
     */
    public void getInfo()
    {
        /**
         * Die Methode getInfo() protokolliert 
         * alle wichtigen Merkmale eines Fahrerobjekts. 
         */
        System.out.println("Fahrerid: " + 
                           this.getId());
        
        System.out.println("Vorname: " + 
                           this.getVorname());
        
        System.out.println("Name: " + 
                           this.getName());
        
        System.out.println("Alter: " +
                           this.getAlter());
        
        System.out.println("Gehalt: " +
                           this.getGehalt());  
    }
}
