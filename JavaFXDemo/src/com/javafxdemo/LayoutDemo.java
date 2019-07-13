package com.javafxdemo;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LayoutDemo extends Application {


    @Override
    public void start(Stage primaryStage)throws Exception{
        // Creating a name label
        Label lblVorname= new Label("Vorname");
        Label lblNachname = new Label("Nachname");

        // Creating a text field
        TextField txtVorname = new TextField();
        TextField txtNachname = new TextField();

        // Creating the play button
        Button btnAbsende = new Button("Absende");

        // Creating Grid pane
        GridPane pane = new GridPane();

        //pane.setPadding(new Insets(10,10,10,10));
        //Setting the vertical and horizontal gaps between the columns


        pane.setVgap(5);
        pane.setHgap(5);
        pane.setAlignment(Pos.CENTER);
        pane.add(lblVorname, 0,0);
        pane.add(txtVorname, 1,0);
        pane.add(lblNachname, 0,1);
        pane.add(txtNachname, 1,1);
        pane.add(btnAbsende, 1,2);

        Scene scene = new Scene(pane, 300,400);
        scene.getStylesheets().add("");

        primaryStage.setTitle("Layout Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String args[]){
        launch(args);
    }
}
