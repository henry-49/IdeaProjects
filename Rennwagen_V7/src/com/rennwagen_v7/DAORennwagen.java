package com.rennwagen_v7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.*;

/**
 *
 */
public class DAORennwagen {

    Connection         connection = null;
    PreparedStatement  stmt       = null;
    private static int lastid     = 0;

    private static DAORennwagen daorennwagen = null;

    private DAORennwagen(){
    }

    /**
     * @return
     */
    public static DAORennwagen getInstance() {
        if (DAORennwagen.daorennwagen == null)
        {
            DAORennwagen.daorennwagen = new DAORennwagen();
        }
        return DAORennwagen.daorennwagen;
    }

    /**
     * @throws Exception
     */
    private void open() throws Exception {

        // JDBC-ODBC-Treiber laden
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        // IP-Adresse des Db-Servers: 3306/Datenbankname“;
        String url = "jdbc:mysql://localhost:3306/db_rennwagen";
        connection = DriverManager.getConnection(url,"root","");
    }

    /**
     *
     */
    private void close() {

        try {

            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }

        }
        catch (SQLException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, stmt.toString());
            alert.show();
        }
    }

    /**
     * @param rennwagen
     */
    public void insert(Rennwagen rennwagen) {

        String sql = "INSERT INTO t_wagen(modell," +
                                         "hersteller," +
                                         "leistung," +
                                         "hubraum," +
                                         "istTankinhalt," +
                                         "maxTankinhalt)" +
                                         " VALUES(?,?,?,?,?,?)";
        try {

            this.open();

            stmt = connection.prepareStatement(sql);
            stmt.setString(1,rennwagen.getModell());
            stmt.setString(2,rennwagen.getHersteller());
            stmt.setInt(3,rennwagen.getLeistung());
            stmt.setInt(4,rennwagen.getHubraum());
            stmt.setDouble(5,rennwagen.getIsttankinhalt());
            stmt.setDouble(6,rennwagen.getMaxtankinhalt());
            int result = stmt.executeUpdate();
            DAORennwagen.lastid++;
            rennwagen.setId(DAORennwagen.lastid);

        }
        catch (ClassNotFoundException e1) {
            Alert alert = new Alert(Alert.AlertType.ERROR, stmt.toString());
            alert.show();
        }
        catch (SQLException e2) {
            Alert alert = new Alert(Alert.AlertType.ERROR, stmt.toString());
            alert.show();
        }
        catch (Exception e3) {
            Alert alert = new Alert(Alert.AlertType.ERROR, stmt.toString());
            alert.show();
        }
        finally {
            this.close();
        }
    }

    /**
     * @param rennwagen
     */
    public void update(Rennwagen rennwagen)
    {
        String sql = "UPDATE t_wagen SET modell = ?, " +
                                        "hersteller = ?, " +
                                        "leistung = ?, " +
                                        "hubraum = ?, " +
                                        "istTankinhalt = ?, " +
                                        "maxTankinhalt = ? WHERE id = ?";
        try {

            this.open();
            stmt = connection.prepareStatement(sql);
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
            Alert alert = new Alert(Alert.AlertType.ERROR, stmt.toString());
            alert.show();
        }
        catch (SQLException e2) {
            Alert alert = new Alert(Alert.AlertType.ERROR, stmt.toString());
            alert.show();
        }
        catch (Exception e3) {
            Alert alert = new Alert(Alert.AlertType.ERROR, stmt.toString());
            alert.show();
        }
        finally {
            this.close();
        }
    }

    /**
     * @return
     */
    public ObservableList<Rennwagen> getAll() {

        String sql = "Select * FROM t_wagen";

        try {

            this.open();
            stmt = connection.prepareStatement(sql);
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
                DAORennwagen.lastid = rennwagen.getId();
            }
            return rennwagenliste;

        } catch (ClassNotFoundException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, stmt.toString());
            alert.show();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, stmt.toString());
            alert.show();
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, stmt.toString());
            alert.show();
        } finally {
            this.close();
        }

        return null;
    }
}


