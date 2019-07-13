public class Getrinke {
    private int id;
    private String GName;
    private Double GPrise;

    public Getrinke(){}



    public Getrinke(int id, String GName, Double GPrise) {
        this.GName = GName;
        this.GPrise = GPrise;
        this.id = id;
    }


    public String getGName() {
        return GName;
    }

    public void setGName(String GName) {
        this.GName = GName;
    }

    public Double getGPrise() {
        return GPrise;
    }

    public void setGPrise(Double GPrise) {
        this.GPrise = GPrise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Getrinke{" +
                "id=" + id +
                ", GName='" + GName + '\'' +
                ", GPrise=" + GPrise +
                '}';
    }



}
