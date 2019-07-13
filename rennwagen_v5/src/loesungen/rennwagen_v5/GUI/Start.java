package loesungen.rennwagen_v5.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import loesungen.rennwagen_v5.logik.Rennwagen;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Start extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("rennwagen.fxml"));
        primaryStage.setTitle("Renwagen V7");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();

       // SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();

        //Rennwagen Fahrer = new Rennwagen();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
