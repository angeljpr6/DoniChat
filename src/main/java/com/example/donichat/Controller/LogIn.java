package com.example.donichat.Controller;

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

    public void logInUser(ActionEvent actionEvent) {
        User user1=verifyData();
        if (user1!=null){
            ChatScreen.user = user1;
            changeWindow();
        }
    }

    public User verifyData(){
        User user1=ControllerDB.verifyUser(userName.getText(),userPassword.getText());
        return user1;
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
