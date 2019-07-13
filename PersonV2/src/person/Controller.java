package person;

import javafx.beans.value.ChangeListener;
        import javafx.beans.value.ObservableValue;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;

public class Controller {

    @FXML
    Label lblOut;

    @FXML
    Button btnAnton;

    @FXML
    Button btnWilli;

    @FXML
    Person person1;

    @FXML
    void initialize()
    {
        person1 = new Person();
        person1.setName("Anton");

        person1.nameProperty().addListener(new ChangeListener<Object>() {

            @Override
            public void changed(ObservableValue<?> o, Object oldVal,
                                Object newVal) {
                lblOut.setText("Hallo " +
                        person1.getName() +
                        " oldVal: " +
                        oldVal.toString() +
                        " newVal: " +
                        newVal.toString());
            }
        });
    }

    @FXML
    public void handleEventBtn(ActionEvent event)
    {
        if (event.getSource() == btnWilli )
        {
            person1.setName("Willi");
        }
        else
        {
            person1.setName("Anton");
        }
    }
}
