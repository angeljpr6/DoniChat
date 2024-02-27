package com.example.donichat.Controller;
import com.example.donichat.model.User;
import com.example.donichat.model.Conections.Client;
import com.example.donichat.model.Message;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChatScreen implements Initializable {
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

    public void getMessages() {
        ArrayList<Message> listMessage=new ArrayList<>();
        listMessage=c.receiveMessage();
        fillField(listMessage);

    }

    public void fillField(ArrayList<Message>listMessage){
        conversation.setText("");
        for (int i = 0; i < listMessage.size(); i++) {
            conversation.setText(conversation.getText()+listMessage.get(i).idSender+": "+listMessage.get(i).getMessage()+"\n");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Thread thread = new Thread(this::periodicTask);

        // Iniciar el hilo
        thread.start();

    }

    private void periodicTask() {
        while (true) {
            try {
                getMessages();

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
