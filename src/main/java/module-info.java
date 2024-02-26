module com.example.donichat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;
    requires java.sql;


    opens com.example.donichat to javafx.fxml;
    exports com.example.donichat;
    exports com.example.donichat.Controller;
    opens com.example.donichat.Controller to javafx.fxml;
}