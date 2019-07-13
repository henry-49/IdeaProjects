package listview.basic;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ListView_V1 extends Application {
    private GridPane gpane = new GridPane();
    private Button btnAdd = new Button("ADD");
    private ListView<String> listview = new ListView<String>();
    private ObservableList<String> items;

    @Override
    public void start(Stage primaryStage) throws Exception{

        this.gpane.setAlignment(Pos.CENTER);
        gpane.add(listview,0,0);
        gpane.add(btnAdd,0,1);

        Scene scene = new Scene(this.gpane, 400,500);

        items = FXCollections.observableArrayList(
                "Single", "Double", "Suite", "Family App"
        );

        this.listview.setItems(this.items);

        this.handelEvents(primaryStage);

        primaryStage.setTitle("Beispiel ListView");

        primaryStage.setScene(scene);

        primaryStage.show();




    }
    private  void handelEvents(Stage stage){
        btnAdd.setOnAction(event -> this.addItem());
    }

    private void addItem(){
        items.add("Common Room");
    }
    public static void main(String args[]){
        launch(args);
    }
}
