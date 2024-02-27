package com.example.donichat.Controller;

import com.example.donichat.model.Conections.Client;
import com.example.donichat.model.ControllerDB;
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
    public static User userLog;

    public void logInUser(ActionEvent actionEvent) {
        User user=new User(userName.getText(),userPassword.getText());
        userLog=user;

        User user1=ChatScreen.c.login();
        if (user1!=null){
            ChatScreen.user = user1;
            changeWindow();
        }else{
            dataError.setVisible(true);
        }
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
