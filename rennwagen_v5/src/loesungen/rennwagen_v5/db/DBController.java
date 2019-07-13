package loesungen.rennwagen_v5.db;


import java.sql.*;

public class DBController {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    PreparedStatement  stmt = null;
    private static Connection connection = null;


    private static final String url = "jdbc:mysql://localhost:3306/rennwagen_db";


    public  void openDBConnection() throws Exception {
        try {
            if (connection == null) {
                // JDBC-ODBC-Treiber laden
                Class.forName(JDBC_DRIVER);
                // IP-Adresse des Db-Servers: 3306/Datenbankname“;


            }
        } catch (Exception err) {
            System.out.println("Wo liegt deine MySQL JDBC Treiber " + err);
            throw err;
        }

        try {
            connection = DriverManager.getConnection(url, "root", "");
        } catch (SQLException sq) {
            System.out.println("Verbindung Fehler " + sq);
        }
    }

    // methode um verbindung zu schliessen
    public  void closeDBConnection() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    public static Connection getConnection() {
        return connection;
    }
}


