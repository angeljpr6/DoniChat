package com.example.donichat;


import com.example.donichat.model.Conections.Conection;
import com.example.donichat.model.ControllerDB;
import com.example.donichat.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher2 extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher2.class.getResource("ChatScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Conection con=new Conection();
        con.conectar();
        User user1=new User(1,"jdjd");
        User user2=new User(2,"jdjd");

        ControllerDB.getConversation(user1,user2);
        launch();


    }
}