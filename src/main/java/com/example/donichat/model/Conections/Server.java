package com.example.donichat.model.Conections;

import com.example.donichat.model.ControllerDB;
import com.example.donichat.model.Message;
import com.example.donichat.model.User;
import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.donichat.model.ControllerDB.verifyUser;

public class Server {


    public static void main(String[] args) {
        ArrayList<Message> listMessage=new ArrayList<>();
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

                int operationCode = in.readInt();
                switch (operationCode) {
                    case 1:
                        String jsonMessage = in.readUTF();
                        Message message = gson.fromJson(jsonMessage, Message.class);
                        System.out.println("ID Sender: " + message.getIdSender());
                        System.out.println("ID Receptor: " + message.getIdReceptor());
                        System.out.println("Mensaje: " + message.getMessage());
                        out.writeUTF("Mensaje recibido");
                        listMessage.add(new Message(message.getIdSender(), message.getIdReceptor(), message.getMessage()));
                        break;
                    case 2:
                        int id;
                        int id2;
                        id=in.readInt();
                        id2=in.readInt();
                        Server.sendMessage(out,listMessage,id,id2);
                        break;
                    case 3:
                        String userName = in.readUTF();
                        String userPassword = in.readUTF();
                        User user=verifyUser(userName,userPassword);
                        String userJson= gson.toJson(user);
                        out.writeUTF(userJson);
                        break;
                    case 4:
                        ArrayList<User> users=ControllerDB.getAllUsers();
                        String allUsers= gson.toJson(users);
                        out.writeUTF(allUsers);

                        break;
                    default:
                        System.out.println("Operación no válida");
                        break;
                }

                sc.close();
                System.out.println("Cliente desconectado");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendMessage(DataOutputStream out, ArrayList<Message> listMessage, int id, int id2){
        try {
            listMessage.clear();
            listMessage= ControllerDB.getConversation(id,id2);
            Gson gson = new Gson();
            String jsonListMessage = gson.toJson(listMessage);
            out.writeUTF(jsonListMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}