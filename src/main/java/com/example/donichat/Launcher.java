package com.example.donichat;



import com.example.donichat.model.Conections.Conection;
import com.example.donichat.model.ControllerDB;
import com.example.donichat.model.Message;
import com.example.donichat.model.User;
import com.google.gson.Gson;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("ChatScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //Conection con = new Conection();
        //con.conectar();
        launch();
    }
}