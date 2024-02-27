package com.example.donichat.model.Conections;

import com.example.donichat.Controller.LogIn;
import com.example.donichat.model.Message;
import com.example.donichat.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.*;


import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Client {
    String host="127.0.0.1";
    int puerto=5000;
    DataInputStream in;
    DataOutputStream out;
    public void sendMessage(Message message) {

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

    public ArrayList<Message> receiveMessage(){

        String message = "";
        ArrayList<Message> listMessage=new ArrayList<>();
        try {
            Socket sc=new Socket(host,puerto);
            in=new DataInputStream(sc.getInputStream());
            out=new DataOutputStream(sc.getOutputStream());
            out.writeInt(2); // Código de operación para recibir un mensaje
            message=in.readUTF();
            Gson gson = new Gson();
            listMessage = gson.fromJson(message, new TypeToken<ArrayList<Message>>() {}.getType());
            System.out.println("Mensaje recibido del servidor: " + message);
            sc.close();
            for (int i = 0; i < listMessage.size(); i++) {
                System.out.println(listMessage.get(i).getMessage());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listMessage;
    }

    public User login(){
        User user= LogIn.userLog;
        User user1=null;
        try {
            Socket sc=new Socket(host,puerto);
            in=new DataInputStream(sc.getInputStream());
            out=new DataOutputStream(sc.getOutputStream());
            Gson gson = new Gson();
            out.writeInt(3); // Código de operación para enviar un mensaje
            String name = user.getName();
            String password = user.getPassword();
            out.writeUTF(name);
            out.writeUTF(password);
            String response = in.readUTF();
            user1 = gson.fromJson(response, User.class);
            System.out.println("Respuesta del servidor: " + response);
            sc.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return user1;

    }
}
