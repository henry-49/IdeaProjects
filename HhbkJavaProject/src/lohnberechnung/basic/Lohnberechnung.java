package lohnberechnung.basic;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.control.*;

public class Lohnberechnung extends Application {
   private Label lblanrede = new Label("Anrede wählen:");
   final ToggleGroup anrede = new ToggleGroup();
    private  RadioButton rbfrauen = new RadioButton("Frau");
    private RadioButton rbherren = new RadioButton("Herr");
    private Label     ueberschrift = new Label("Arbeitszeiterfassung");
    private Label     lblVorname   = new Label("Vorname");
    private TextField txtVorname   = new TextField();
    private Label     lblNachname  = new Label("Nachname");
    private TextField txtNachname  = new TextField();
    private Label     lblArbeitsstunden = new Label("Arbeitsstunden");
    private TextField txtArbeitsstunden= new TextField();
    private Label     lblStundensatz = new Label("Stundensatz");
    private TextField txtStundensatz= new TextField();
   private  CheckBox   chZuschlag = new CheckBox("Feiertagzuschlag");
    private TextArea   txtbeschriebung = new TextArea("Beschriebung");
    private Button    btnAbsenden     = new Button("Absenden");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    boolean inputError = false;
    String errortText = "";

        // mithilfe der hBox kann der Biutton rechtsbündig gesetzt werden.
        HBox hbpane = new HBox(rbfrauen, rbherren);
        hbpane.setPadding(new Insets(10));
        hbpane.setSpacing(5);

        VBox vbox = new VBox(txtbeschriebung);
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(10);
        rbfrauen.setToggleGroup(anrede);
        rbfrauen.setSelected(true);

        rbherren.setToggleGroup(anrede);
        rbherren.setSelected(false);
        // Abstand oben, rechts, unten, links innerhalb des zentrierten
        // Bereichs des Gridpane
//        grid.setPadding(new Insets(15, 15, 15, 15));
//
//        ueberschrift.setFont(new Font("Arial",24));

        ueberschrift.setId("lohnberechnung-text");

        ueberschrift.setId("actiontarget");

        //GUI-Elemente dem Gridpane hinzufügen
        grid.add(ueberschrift,0,0,2,1);//child,colIndex,rowIndex,colspan,rowspan)
        grid.add(lblanrede,0,2);
        grid.add(hbpane,1,2);
        grid.add(lblVorname,0,3);
        grid.add(txtVorname,1,3);
        grid.add(lblNachname,0,4);
        grid.add(txtNachname,1,4);
        grid.add(lblArbeitsstunden,0,5);
        grid.add(txtArbeitsstunden,1,5);
        grid.add(lblStundensatz,0,6);
        grid.add(txtStundensatz,1,6);
        grid.add(chZuschlag, 1, 7);
        grid.add(vbox,1,8);
        grid.add(btnAbsenden,1,9);

        this.handleEvents();

        Scene scene = new Scene(grid, 400,300);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(
                Lohnberechnung.class.getResource("style.css").toExternalForm());
        primaryStage.setTitle("Lohnberechnung");

        primaryStage.show();
    }

    private void handleEvents() {

        this.btnAbsenden.setOnAction(event -> this.rechnug(event));
    }



    private void rechnug(ActionEvent e) {
        if (anrede.getSelectedToggle() != null) {
            RadioButton button = (RadioButton) anrede.getSelectedToggle();
            System.out.println("Button: " + button.getText());
            lblanrede.setText("You are " + button.getText());
        }

    try {
        double satz= Double.parseDouble(txtStundensatz.getText());
        double stunden = Double.parseDouble(txtArbeitsstunden.getText());
        double lohn =  satz * stunden;
        String vname = txtVorname.getText();
        String nname = txtNachname.getText();
        String ausgabetext = "Hallo " + vname + " " + nname + ",\n";
        ausgabetext += "schön dich zu sehen.\n";
        ausgabetext += "Du hast heute "+lohn+ " Euro verdient.\n";
        this.addMessageDialog(ausgabetext);
    }catch (Exception x){
        x.printStackTrace();
    }





    }

    private void addMessageDialog(String text) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Abrechnung");
        alert.setContentText(text);
        alert.showAndWait();
    }
    private void addErrorDialog(String text) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Abrechnung");
        alert.setContentText(text);
        alert.showAndWait();
    }

}
