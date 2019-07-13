package com.rennwagen3;

import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    static private int anzahlrennwagen = 1;

    @FXML
    ListView<Rennwagen> rennwagenListView;

    @FXML
    private GridPane lbl;

    @FXML
    private Label lblId;

    @FXML
    private TextField txtModell;

    @FXML
    private TextField txtHersteller;

    @FXML
    private TextField txtLeistung;

    @FXML
    private TextField txtHubraum;

    @FXML
    private TextField txtMaxTankinhalt;

    @FXML
    private Button btnSpeichen;

    @FXML
    private Button btnEnde;

    @FXML
    private TextField txtAkuTankinhalt;

    @FXML
    private Label lbloutput;

    @FXML
    private TextField txtoutput;

    @FXML
    private Button btnAndern;

    @FXML
    private Label lblErrorMsg;

    @FXML
    private void handleEvents(){
        btnSpeichen.setOnAction(event -> this.addItem());
        resetInput();
        btnEnde.setOnAction(event -> Platform.exit());
        if (this.rennwagenListView.getSelectionModel().getSelectedItem() == null) {
            this.rennwagenListView.getSelectionModel().selectedItemProperty()
                    .addListener((observable, oldValue, newValue) -> getItem());
        } else {
            editItem();
        }
    }
    // method to edit item in the listview
    @FXML
    private void editItem(){
        try {
            Rennwagen currentItem;
            currentItem = this.rennwagenListView.getSelectionModel().getSelectedItem();
            currentItem.setModell(txtModell.getText());
            currentItem.setHersteller(txtHersteller.getText());
            currentItem.setLeistung(Integer.parseInt(txtLeistung.getText()));
            currentItem.setHubraum(Integer.parseInt(txtHubraum.getText()));
            currentItem.setMaxtankinhalt(Float.parseFloat(txtMaxTankinhalt.getText()));
            currentItem.setIsttankinhalt(Float.parseFloat(txtAkuTankinhalt.getText()));
            this.rennwagenListView.refresh();
            rennwagenListView.getSelectionModel().clearSelection();
            lblErrorMsg.setTextFill(Paint.valueOf("Green"));
            lblErrorMsg.setText("Erfolgreich hinzugefügt");
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            lblErrorMsg.setTextFill(Paint.valueOf("Red"));
            lblErrorMsg.setText("Bitte geben Sie die richtigen Daten ein");
        }
    }
    // method to get item to listview
    @FXML
    private void getItem() {
        Rennwagen selectedItem = rennwagenListView.getSelectionModel().getSelectedItem();
        txtoutput.setText(Integer.toString(selectedItem.getId()));
        txtModell.setText(selectedItem.getModell());
        txtHersteller.setText(selectedItem.getHersteller());
        txtLeistung.setText(Integer.toString(selectedItem.getLeistung()));
        txtHubraum.setText(Integer.toString(selectedItem.getHubraum()));
        txtMaxTankinhalt.setText(Float.toString(selectedItem.getMaxtankinhalt()));
        txtAkuTankinhalt.setText(Float.toString(selectedItem.getIsttankinhalt()));
    }
    // method to add item to listview
    @FXML
    private void addItem(){
        try{
            Rennwagen newCar = new Rennwagen();
            newCar.setId(anzahlrennwagen);
            newCar.setModell(txtModell.getText());
            newCar.setHersteller(txtHersteller.getText());
            newCar.setLeistung(Integer.parseInt(txtLeistung.getText()));
            newCar.setHubraum(Integer.parseInt(txtHubraum.getText()));
            newCar.setMaxtankinhalt(Float.parseFloat(txtMaxTankinhalt.getText()));
            newCar.setIsttankinhalt(Float.parseFloat(txtAkuTankinhalt.getText()));
            anzahlrennwagen++;
            rennwagenListView.getItems().add(newCar);
            resetInput();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //  clear and reset input values to default
    @FXML
    public void resetInput(){
        txtoutput.setText("");
        txtModell.setText("");
        txtHersteller.setText("");
        txtLeistung.setText("0");
        txtMaxTankinhalt.setText("0.0");
        txtAkuTankinhalt.setText("0.0");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblErrorMsg.setText("");
        txtoutput.setDisable(true);
        BooleanBinding filled = txtModell.textProperty().isNotEmpty().and(txtHersteller.textProperty().isNotEmpty())
                .and(txtLeistung.textProperty().isNotEmpty()).and(txtMaxTankinhalt.textProperty().isNotEmpty())
                .and(txtAkuTankinhalt.textProperty().isNotEmpty()).and(txtHubraum.textProperty().isNotEmpty());
        btnSpeichen.disableProperty().bind((rennwagenListView.getSelectionModel().selectedItemProperty().isNotNull()).or(filled.not()));
        btnAndern.disableProperty().bind(rennwagenListView.getSelectionModel().selectedItemProperty().isNull());
    }

    // method to terminate the program
    @FXML
    public void Ende() {
        Platform.exit();
    }
}


