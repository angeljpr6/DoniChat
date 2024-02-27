package com.example.donichat.Controller;

import com.example.donichat.model.Conections.Client;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatScreen {
    public TextField areaMessage;
    public TextArea conversation;
    public Label userName;
    public Client c=new Client();

    public void sendMessage(ActionEvent actionEvent) {
        c.sendMessage(areaMessage.getText());
    }
}
