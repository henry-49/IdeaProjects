package rennwagen.basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Rennwagen_V3 extends Application {

    static private int anzahlrennwagen = 1;



    private Label     ueberschrift = new Label("Rennwagen V3");
    private Label     lblModell   = new Label("Modell");
    private Label     lblID   = new Label("ID");
    private Label     lblidInfo   = new Label();
    private TextField txtModell   = new TextField();
    private Label     lblHersteller  = new Label("Hersteller");
    private TextField txtHersteller = new TextField();
    private Label     lblLeistung = new Label("Leistung");
    private TextField txtLeistung= new TextField();
    private Label     lblHubraum = new Label("Hubraum");
    private TextField txtHubraum = new TextField();
    private Label     lblMaxTankinhalt = new Label("maximaler Tankinhalt");
    private TextField txtMaxTankinhalt= new TextField();
    private Label     lblAkuTankinhalt = new Label("aktueller Tankinhalt");
    private TextField txtAkuTankinhalt= new TextField();
    private Button    btnSpeichen     = new Button("Speichen");
    private Button    btnEnde     = new Button("Ende");
    private Button    btnAbsenden     = new Button("Absenden");
    private TextArea   txtbeschriebung = new TextArea("Beschriebung");
    VBox vbox = new VBox(txtbeschriebung);
    ObservableList<Rennwagen> wagen;
    ListView<Rennwagen> rennwagenListView;

    @Override
    public void start(Stage primaryStage) throws Exception{

        GridPane gpane = new GridPane();


        //list View for rennwagen
       wagen = FXCollections.observableArrayList();
        rennwagenListView = new ListView<Rennwagen>(wagen);

        this.rennwagenListView.setItems(this.wagen);
        //Setting size for the pane
        gpane.setMinSize(500, 400);

        //Setting the padding
        gpane.setPadding(new Insets(10, 10, 10, 10));

        gpane.setAlignment(Pos.CENTER);
        //Setting the vertical and horizontal gaps between the columns
        gpane.setHgap(20);
        gpane.setVgap(10);

        // Abstand oben, rechts, unten, links innerhalb des zentrierten
        // Bereichs des Gridpane
//        gpane.setPadding(new Insets(15, 15, 15, 15));
//
//        ueberschrift.setFont(new Font("Arial",24));

        ueberschrift.setId("lohnberechnung-text");

        ueberschrift.setId("actiontarget");

        //GUI-Elemente dem Gridpane hinzufügen
        gpane.add(ueberschrift,0,0,2,1);//child,colIndex,rowIndex,colspan,rowspan)
        gpane.add(lblID,0,1);
        gpane.add(lblidInfo,1,1);
        gpane.add(lblModell,0,2);
        gpane.add(txtModell,1,2);
        gpane.add(lblHersteller,0,3);
        gpane.add(txtHersteller,1,3);
        gpane.add(lblLeistung,0,4);
        gpane.add(txtLeistung,1,4);
        gpane.add(lblHubraum,0,5);
        gpane.add(txtHubraum,1,5);
        gpane.add(lblAkuTankinhalt, 0, 6);
        gpane.add(txtAkuTankinhalt, 1, 6);
        gpane.add(lblMaxTankinhalt, 0, 7);
        gpane.add(txtMaxTankinhalt, 1, 7);
        gpane.add(btnSpeichen,0,8);
        gpane.add(btnEnde,1,8);
        gpane.add(rennwagenListView,0,9, 2,1);

        this.handleEvents(primaryStage);

        Scene scene = new Scene(gpane, 400,500);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Rennwagen_V3.class.getResource("style.css").toExternalForm());
        primaryStage.setTitle("Rennwagen V3");

        //Displaying the contents of the stage
        primaryStage.show();
    }
    private void handleEvents(Stage sage){
        btnSpeichen.setOnAction(event -> this.addItem());
        resetInput();
        btnEnde.setOnAction(event -> Platform.exit());
        this.rennwagenListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> getItem());
   }

   private void getItem() {
        Rennwagen selectedItem = rennwagenListView.getSelectionModel().getSelectedItem();
        lblidInfo.setText(Integer.toString(selectedItem.getId()));
       txtModell.setText(selectedItem.getModell());
        txtHersteller.setText(selectedItem.getHersteller());
        txtLeistung.setText(Integer.toString(selectedItem.getLeistung()));
        txtHubraum.setText(Integer.toString(selectedItem.getHubraum()));
        txtAkuTankinhalt.setText(Float.toString(selectedItem.getIsttankinhalt()));
        txtMaxTankinhalt.setText(Float.toString(selectedItem.getMaxtankinhalt()));
   }

   private void addItem(){
        try{
            if(lblidInfo.getText().equals("")) {
                Rennwagen newCar = new Rennwagen();
                newCar.setId(anzahlrennwagen);
                newCar.setModell(txtModell.getText());
                newCar.setHersteller(txtHersteller.getText());
                newCar.setLeistung(Integer.parseInt(txtLeistung.getText()));
                newCar.setHubraum(Integer.parseInt(txtHubraum.getText()));
                newCar.setIsttankinhalt(Float.parseFloat(txtAkuTankinhalt.getText()));
                newCar.setMaxtankinhalt(Float.parseFloat(txtMaxTankinhalt.getText()));
                anzahlrennwagen++;
                rennwagenListView.getItems().add(newCar);
            } else {
                Rennwagen currentItem = rennwagenListView.getSelectionModel().getSelectedItem();
                currentItem.setModell(txtModell.getText());
                currentItem.setHersteller(txtModell.getText());
                currentItem.setLeistung(Integer.parseInt(txtLeistung.getText()));
                currentItem.setHubraum(Integer.parseInt(txtHubraum.getText()));
                currentItem.setIsttankinhalt(Float.parseFloat(txtAkuTankinhalt.getText()));
                currentItem.setIsttankinhalt(Float.parseFloat(txtMaxTankinhalt.getText()));
                rennwagenListView.refresh();
            }

            resetInput();
        }catch (Exception e){
            e.printStackTrace();
        }

   }

   public void resetInput(){
       lblidInfo.setText("");
       txtModell.setText("");
       txtHersteller.setText("BMW");
       txtAkuTankinhalt.setText("0.0");
       txtLeistung.setText("0");
       txtMaxTankinhalt.setText("0.0");


   }
    public static void main(String args[]){
        launch(args);
    }
}
