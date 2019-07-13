package kontov1;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Konto {

    private DoubleProperty guthaben;
    private boolean kontotype;

    public boolean isKontotype() {
        return kontotype;
    }

    public void setKontotype(boolean kontotype) {

        this.kontotype = kontotype;
    }

    public void selectAccount(Boolean kontotype){
        if (this.kontotype){
            this.guthabenProperty().set(1000);
        }else {
            this.guthabenProperty().set(10000);
        }
    }

    public final DoubleProperty guthabenProperty() {

        if (guthaben == null){
            guthaben = new SimpleDoubleProperty();
        }
        return guthaben;
    }



//    public  final DoubleProperty balanceProperty(){
//
//        if (balance == null) {
//
//            balance = new SimpleDoubleProperty();
//        }
//        return balance;
//    }

}
