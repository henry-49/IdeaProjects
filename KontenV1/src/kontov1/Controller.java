package kontov1;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private TextField txtprivatekonto;

    @FXML
    private TextField txtgeschaftskonto;

    @FXML
    private Button btnauszahlen;

    @FXML
    private Button btneinzahlen;

    @FXML
    private Label lblgesamtsaldo;

    @FXML
    Konto kontoP  = new Konto();
    Konto kontoG =  new Konto();

    @FXML
    void initialize(){
         kontoP.selectAccount(true);
         kontoG.selectAccount(false);

        lblgesamtsaldo.textProperty()
                .bind(Bindings
                        .concat("",kontoP.guthabenProperty()
                                .add(kontoG.guthabenProperty())));
    }

    // method to payout
    @FXML
    public void addAuszahlen() {
        kontoP.guthabenProperty().set(kontoP.guthabenProperty().getValue()- Double.valueOf(txtprivatekonto.getText()));
        kontoG.guthabenProperty().set(kontoG.guthabenProperty().getValue()- Double.valueOf(txtgeschaftskonto.getText()));
    }

    // method to payin
    @FXML
    public void addEinzahlen() {

        kontoP.guthabenProperty().set(kontoP.guthabenProperty().getValue()+ Double.valueOf(txtprivatekonto.getText()));
        kontoG.guthabenProperty().set(kontoG.guthabenProperty().getValue()+ Double.valueOf(txtgeschaftskonto.getText()));
    }

}