package person;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    private StringProperty name;

    public final String getName() {

        if (name != null) {
            return name.get();
        }
        return null;
    }

    public final void setName(String name) {

        this.nameProperty().set(name);
    }

    public final StringProperty nameProperty() {

        if (name == null) {

            name = new SimpleStringProperty();
        }
        return name;
    }

}