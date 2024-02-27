package com.example.donichat.Controller;
import com.example.donichat.model.User;
import com.google.gson.Gson;
import com.example.donichat.model.Conections.Client;
import com.example.donichat.model.Message;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatScreen {
    public TextField areaMessage;
    public TextArea conversation;
    public Label userName;
    public static User user;
    public Client c=new Client();

    public void sendMessage(ActionEvent actionEvent) {
        Message m=new Message(1,2, areaMessage.getText());

        c.sendMessage(m);
    }

    public void provisional(ActionEvent actionEvent) {

        c.receiveMessage();
    }
}
