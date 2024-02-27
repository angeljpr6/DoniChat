package com.example.donichat.model.Conections;

import com.example.donichat.model.Message;
import com.google.gson.Gson;
import java.io.*;
import java.net.*;


import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public void sendMessage(Message message) {
        String host="127.0.0.1";
        int puerto=5000;
        DataInputStream in;
        DataOutputStream out;
        try {
            Socket sc=new Socket(host,puerto);
            in=new DataInputStream(sc.getInputStream());
            out=new DataOutputStream(sc.getOutputStream());
            Gson gson = new Gson();
            out.writeInt(1); // Código de operación para enviar un mensaje
            String jsonMessage = gson.toJson(message);
            out.writeUTF(jsonMessage);
            String response = in.readUTF();
            System.out.println("Respuesta del servidor: " + response);
            sc.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String receiveMessage(){
        String host="127.0.0.1";
        int puerto=5000;
        DataInputStream in;
        DataOutputStream out;
        String message = "";
        try {
            Socket sc=new Socket(host,puerto);
            in=new DataInputStream(sc.getInputStream());
            out=new DataOutputStream(sc.getOutputStream());
            out.writeInt(2); // Código de operación para recibir un mensaje
            message=in.readUTF();
            System.out.println("Mensaje recibido del servidor: " + message);
            sc.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return message;
    }
}
