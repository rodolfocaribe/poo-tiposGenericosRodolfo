module br.tiposgenericosrodolfo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens br.tiposgenericosrodolfo to javafx.fxml;
    exports br.tiposgenericosrodolfo;
}