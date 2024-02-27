module com.example.donichat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;
    requires java.sql;
    requires com.google.gson;


    opens com.example.donichat to javafx.fxml,com.google.gson;
    exports com.example.donichat;
    exports com.example.donichat.Controller;
    opens com.example.donichat.Controller to javafx.fxml, com.google.gson;
    opens com.example.donichat.model to com.google.gson;
    opens com.example.donichat.model.Conections to com.google.gson;
}