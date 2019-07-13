package loesungen.rennwagen_v5.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import loesungen.rennwagen_v5.logik.Rennwagen;


public class RennwagenDAO {
    PreparedStatement  stmt = null;
    private static int lastid     = 0;
    private static DBController dbController = new DBController();
    private static RennwagenDAO daorennwagen = null;

    public RennwagenDAO(){
    }

    public static RennwagenDAO getInstance() {
        if (RennwagenDAO.daorennwagen == null)
        {
            RennwagenDAO.daorennwagen = new RennwagenDAO();
        }
        return RennwagenDAO.daorennwagen;
    }


    private void open() throws Exception {
       DBController dbController = new DBController();
       dbController.openDBConnection();
    }

    public void insert(Rennwagen rennwagen) throws Exception{
        String sql = "INSERT INTO t_rennwagen(modell," +
                "hersteller," +
                "leistung," +
                "hubraum," +
                "istTankinhalt," +
                "maxTankinhalt)" +
                " VALUES(?,?,?,?,?,?)";

            try {
                dbController.openDBConnection();
                stmt = dbController.getConnection().prepareStatement(sql);
                stmt.setString(1, rennwagen.getModell());
                stmt.setString(2, rennwagen.getHersteller());
                stmt.setInt(3, rennwagen.getLeistung());
                stmt.setInt(4, rennwagen.getHubraum());
                stmt.setDouble(5, rennwagen.getIsttankinhalt());
                stmt.setDouble(6, rennwagen.getMaxtankinhalt());
                int result = stmt.executeUpdate();
                RennwagenDAO.lastid++;
                System.out.println(result);
                rennwagen.setId(RennwagenDAO.lastid);

            } catch (ClassNotFoundException var10) {
                var10.printStackTrace();
            } catch (SQLException var11) {
              var11.printStackTrace();
            } catch (Exception var12) {
                var12.printStackTrace();
            } finally {
                dbController.closeDBConnection();
            }

    }


    public void update(Rennwagen rennwagen) throws Exception
    {
        String sql = "UPDATE t_rennwagen SET modell = ?, " +
                "hersteller = ?, " +
                "leistung = ?, " +
                "hubraum = ?, " +
                "istTankinhalt = ?, " +
                "maxTankinhalt = ? WHERE id = ?";
        try {

            dbController.openDBConnection();
            stmt = dbController.getConnection().prepareStatement(sql);
            stmt.setString(1,rennwagen.getModell());
            stmt.setString(2,rennwagen.getHersteller());
            stmt.setInt(3,rennwagen.getLeistung());
            stmt.setInt(4,rennwagen.getHubraum());
            stmt.setDouble(5,rennwagen.getIsttankinhalt());
            stmt.setDouble(6,rennwagen.getMaxtankinhalt());
            stmt.setDouble(7,rennwagen.getId());

            int result = stmt.executeUpdate();
        }
        catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        catch (SQLException e2) {
            e2.printStackTrace();
        }
        catch (Exception e3) {
            e3.printStackTrace();
        }
        finally {
            dbController.closeDBConnection();
        }
    }

    public void delete(Rennwagen rennwagen) throws Exception
    {
        String sql = "DELETE FROM t_rennwagen modell = ?, " +
                "hersteller = ?, " +
                "leistung = ?, " +
                "hubraum = ?, " +
                "istTankinhalt = ?, " +
                "maxTankinhalt = ? WHERE id = ?";
        try {

            dbController.openDBConnection();
            stmt = dbController.getConnection().prepareStatement(sql);
            stmt.setString(1,rennwagen.getModell());
            stmt.setString(2,rennwagen.getHersteller());
            stmt.setInt(3,rennwagen.getLeistung());
            stmt.setInt(4,rennwagen.getHubraum());
            stmt.setDouble(5,rennwagen.getIsttankinhalt());
            stmt.setDouble(6,rennwagen.getMaxtankinhalt());
            stmt.setDouble(7,rennwagen.getId());


            int result = stmt.executeUpdate();
        }
        catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        catch (SQLException e2) {
            e2.printStackTrace();
        }
        catch (Exception e3) {
            e3.printStackTrace();
        }
        finally {
            dbController.closeDBConnection();
        }
    }

    public ObservableList<Rennwagen> getAll() throws Exception{

        String sql = "Select * FROM t_rennwage";

        try {

            dbController.openDBConnection();
            stmt = dbController.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ObservableList<Rennwagen> rennwagenliste = FXCollections.observableArrayList();

            while(rs.next())
            {
                Rennwagen rennwagen = new Rennwagen(rs.getInt("id"),
                        rs.getString("modell"),
                        rs.getString("hersteller"),
                        rs.getFloat("maxTankinhalt"),
                        rs.getInt("leistung"),
                        rs.getInt("hubraum"),
                        rs.getFloat("istTankinhalt"));
                rennwagenliste.add(rennwagen);
                RennwagenDAO.lastid = rennwagen.getId();
            }
            return rennwagenliste;

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
