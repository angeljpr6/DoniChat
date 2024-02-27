package com.example.donichat.Controller;
import com.example.donichat.model.User;
import com.google.gson.Gson;
import com.example.donichat.model.Conections.Client;
import com.example.donichat.model.Message;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ChatScreen {
    public TextField areaMessage;
    public TextArea conversation;
    public Label userName;
    public static User user;
    public Client c=new Client();

    public void sendMessage(ActionEvent actionEvent) {
        Message m=new Message(1,2, areaMessage.getText());
        c.sendMessage(m);
        areaMessage.setText("");
    }

    public void provisional(ActionEvent actionEvent) {
        ArrayList<Message> listMessage=new ArrayList<>();
        listMessage=c.receiveMessage();
        fillField(listMessage);

    }

    public void fillField(ArrayList<Message>listMessage){
        for (int i = 0; i < listMessage.size(); i++) {
            conversation.setText(conversation.getText()+listMessage.get(i).idSender+": "+listMessage.get(i).getMessage()+"\n");
        }
    }
}
