package com.example.donichat.model.Conections;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public void sendMessage(String message) {
        String host="127.0.0.1";
        int puerto=5000;
        DataInputStream in;
        DataOutputStream out;
        try {
            Socket sc=new Socket(host,puerto);
            in=new DataInputStream(sc.getInputStream());
            out=new DataOutputStream(sc.getOutputStream());
            out.writeUTF(message);
            message=in.readUTF();
            System.out.println(message);
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
            out.writeUTF(message);
            message=in.readUTF();
            System.out.println(message);
            sc.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return message;
    }
}
