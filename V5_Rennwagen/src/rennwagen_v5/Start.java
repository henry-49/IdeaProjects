package loesungen.rennwagen_v5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("rennwagen.fxml"));
        primaryStage.setTitle("Renwagen V5");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
