module com.example.donichat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.donichat to javafx.fxml;
    exports com.example.donichat;
}