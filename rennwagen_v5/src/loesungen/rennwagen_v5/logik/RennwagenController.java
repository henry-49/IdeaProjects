package loesungen.rennwagen_v5.logik;

import loesungen.rennwagen_v5.db.RennwagenDAO;

public class RennwagenController {

    public void insert(Rennwagen rennwagen){
        RennwagenDAO rennwagenDAO = new RennwagenDAO();
        try {
            rennwagenDAO.insert(rennwagen);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void update(Rennwagen rennwagen){

        RennwagenDAO rennwagenDAO = new RennwagenDAO();
        try {
            rennwagenDAO.update(rennwagen);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Rennwagen rennwagen){

        RennwagenDAO rennwagenDAO = new RennwagenDAO();
        try {
            rennwagenDAO.delete(rennwagen);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
