
package aufgaben.mysql.verwaltung_v1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.*;

public class Controller {

    @FXML
    TextField txtName;

    @FXML
    TextField txtOrt;

    @FXML
    Button btnSpeichern;

    @FXML
    ListView<String> listviewAbt;

    @FXML
    void handleBtnSpeichernAction(ActionEvent e)
    {
        Statement  stmt       = null;
        Statement  readstmt   = null;
        Connection connection = null;
        ResultSet  resultset  = null;

        try
        {
            // JDBC-ODBC-Treiber laden
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // IP-Adresse des Db-Servers: 3306/Datenbankname“;
            String url = "jdbc:mysql://localhost:3306/db_verwaltung";
            connection = DriverManager.getConnection(url,"root","");

            // Statementobjekt erzeugen
            stmt = connection.createStatement();

            // SQL-Statement erstellen
            String sql = "INSERT INTO t_abt (name,ort)"
                            + "Values(' "
                            + txtName.getText() + "','"
                            + txtOrt.getText() + "')" ;

            // Testausgabe
            System.out.println(sql);

            // SQL-Statement abschicken
            int result = stmt.executeUpdate(sql);


            /*************** Alle Datensätze aus der Tabelle anzeigen **************/

            readstmt = connection.createStatement();

            sql = "SELECT * FROM t_abt;";

            // SQL-Statement abschicken
            readstmt.execute(sql);
            System.out.println("Statement ausgeführt");
            System.out.println(sql);

            // Ergebnismenge holen
            resultset = readstmt.getResultSet();

            // Datensätze aus der Ergebnismenge verarbeiten
            String out;
            while (resultset.next() == true)
            {
                out = "id:";
                out = out + resultset.getString("id");
                out = out + " / Name:";
                out = out + resultset.getString("name");
                out = out + " / Ort:";
                out = out + resultset.getString("ort");
                out = out + "";
                listviewAbt.getItems().add(out);
            }

            readstmt.close();
            stmt.close();
        }
        catch (ClassNotFoundException e1)
        {
            e1.printStackTrace();
        }
        catch (SQLException e2)
        {
            e2.printStackTrace();
        }
        catch (Exception e3) {
            e3.printStackTrace();
        }
        finally
        {
            if (connection != null)
            {
                try {
                    connection.close();
                }
                catch (SQLException ex) {

                    ex.printStackTrace();
                }
            }
        }
    }
}
