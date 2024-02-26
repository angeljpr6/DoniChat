package com.example.donichat.Controller;

import com.example.donichat.model.Conections.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Home {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        Client client =new Client();

        client.sendMessage("Hola");
    }
}