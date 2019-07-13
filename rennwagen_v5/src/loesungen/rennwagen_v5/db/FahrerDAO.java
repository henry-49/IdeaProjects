package loesungen.rennwagen_v5.db;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import loesungen.rennwagen_v5.logik.Fahrer;
import loesungen.rennwagen_v5.logik.Rennwagen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FahrerDAO {
    PreparedStatement stmt = null;
    private static int lastid     = 0;
    private static DBController dbController = new DBController();
    private static FahrerDAO daofahrer = null;

    public FahrerDAO(){
    }

    public static FahrerDAO getInstance() {
        if (FahrerDAO.daofahrer == null)
        {
            FahrerDAO.daofahrer = new FahrerDAO();
        }
        return FahrerDAO.daofahrer;
    }


    private void open() throws Exception {
        DBController dbController = new DBController();
        dbController.openDBConnection();
    }


    public ObservableList<Fahrer> getAll() throws Exception{

        String sql = "Select * FROM t_fahrer";

        try {

            dbController.openDBConnection();
            stmt = dbController.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ObservableList<Fahrer> fahrerliste = FXCollections.observableArrayList();

            while(rs.next())
            {
                Fahrer fahrer = new Fahrer(rs.getInt("id"),
                        rs.getString("vorname"),
                        rs.getString("name"),
                        rs.getInt("alter"),
                        rs.getDouble("gehalt"));
                fahrerliste.add(fahrer);
                FahrerDAO.lastid = fahrer.getId();
            }
            return fahrerliste;

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbController.closeDBConnection();
        }

        return null;
    }

}
