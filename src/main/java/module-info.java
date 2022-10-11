module br.tiposgenericosrodolfo {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens br.tiposgenericosrodolfo to javafx.fxml;
    exports br.tiposgenericosrodolfo;
}