package com.example.donichat.model.Conections;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] args) {
        ServerSocket servidor=null;
        Socket sc=null;
        int puerto=5000;
        DataInputStream in;
        DataOutputStream out;
        try {
            servidor=new ServerSocket(puerto);
            System.out.println("servidor iniciado");
            while (true){
                sc=servidor.accept();
                in=new DataInputStream(sc.getInputStream());
                out=new DataOutputStream(sc.getOutputStream());
                String mensaje=in.readUTF();
                System.out.println(mensaje);
                out.writeUTF("que taal");
                sc.close();
                System.out.println("cliente desconectado");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
