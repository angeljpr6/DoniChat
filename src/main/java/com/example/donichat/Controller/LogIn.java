package com.example.donichat.Controller;

import com.example.donichat.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogIn {
    public TextField userName;
    public TextField userPassword;
    public Label dataError;

    public void logInUser(ActionEvent actionEvent) {
        User user = new User(userName.getText(),userPassword.getText());

        if (verifyData(user)){
            ChatScreen.user = user;
            changeWindow();
        }
    }

    public boolean verifyData(User user){
        boolean correctData = true;

        // TODO: 27/02/2024 Conectar con la base de datos y comprobar que el usuario y contraseña coinciden

        return correctData;
    }

    public void changeWindow(){

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/donichat/ChatScreen.fxml"));
        Parent root = null;
        try {
            root = loader.load();
            Scene scene = new Scene(root);
            Stage chatScreenStage = new Stage();
            chatScreenStage.setTitle("Chat Screen");
            chatScreenStage.setResizable(false);
            chatScreenStage.setScene(scene);
            chatScreenStage.show();
            Stage myStage = (Stage) this.userName.getScene().getWindow();
            myStage.close();
        } catch (IOException e) {
            System.out.println("Error al cambiar de ventana");
        }
    }
}
