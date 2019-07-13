import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main
{
    public static SessionFactory sessionFactory;

    public static void main(String[] args)
    {
        System.out.println("Rennwagen v6b");

        sessionFactory = new Configuration().configure().buildSessionFactory();

        Fahrer f = new Fahrer();
        f.setFahrerVorname("Heinrich");
        f.setFahrerNachname("Hertz");
        f.setFahrerAlter(33);
        f.setGehalt(3500);

        Rennwagen r = new Rennwagen(6, "911 Turbo", "VW", 550, 5, 100,50);
        //public Rennwagen(int id, String modell, String hersteller, int leistung, int hubraum, float  maxTankinhalt, float istTankinh

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(r);
        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
        System.out.println("Ende");

    }
}
