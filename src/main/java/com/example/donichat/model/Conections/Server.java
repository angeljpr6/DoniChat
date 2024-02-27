package com.example.donichat.model.Conections;

import com.example.donichat.model.Message;
import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] args) {
        ServerSocket servidor = null;
        Socket sc = null;
        int puerto = 5000;
        DataInputStream in;
        DataOutputStream out;
        Gson gson = new Gson();

        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");
            while (true) {
                sc = servidor.accept();
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                String jsonMessage = in.readUTF();
                Message message = gson.fromJson(jsonMessage, Message.class);

                System.out.println("ID Sender: " + message.getIdSender());
                System.out.println("ID Receptor: " + message.getIdReceptor());
                System.out.println("Mensaje: " + message.getMessage());

                out.writeUTF("Mensaje recibido");

                sc.close();
                System.out.println("Cliente desconectado");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}