package listview.basic;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ListView_V2 extends Application {
    private GridPane pane = new GridPane();

    private ListView<String> listview = new ListView<String>();
    private ObservableList<String> items;

    public void start(Stage primaryStage) throws Exception {
        this.pane.setAlignment(Pos.CENTER);
        pane.add(listview,0,0);
        Scene scene = new Scene(this.pane, 400, 500);
        items = FXCollections.observableArrayList (
                "Single", "Double", "Suite", "Family App");
        this.listview.setItems(this.items);
        this.handleEvents(primaryStage);
        primaryStage.setTitle("Beispiel Listview");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main ( String[] args ) {
        launch ( args );
    }
    private void handleEvents(Stage stage) {
        this.listview.getSelectionModel()
                .setSelectionMode(SelectionMode.SINGLE);
        this.listview
                .setOnKeyReleased(event ->System.out.println("Event: "+
                        event.getEventType() +
                        " Selected: " +
                        listview.getSelectionModel()
                                .getSelectedItem()));
        this.listview
                .setOnMouseReleased(event ->System.out.println("Event: " +
                        event.getEventType() +
                        " Selected: " +
                        listview.getSelectionModel()
                                .getSelectedItem()));
    };

}