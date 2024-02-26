package com.example.donichat.model.Conections;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream is;
    private OutputStream os;

    public Server (int puerto) throws IOException{
        serverSocket = new ServerSocket(puerto);
    }

    public void start() throws IOException {
        System.out.println("(Servidor) ... esperando conexiones entrantes ....");
        socket = serverSocket.accept();
        is = socket.getInputStream();
        os = socket.getOutputStream();
        System.out.println("(Servidor) ... Conexión establecida ...");
    }

    public static void main(String[] args) {
        try {
            Server server = new Server(49191);

            while (true) {
                server.start();

                System.out.println("Mensaje del cliente: " + server.is.read());
            }

            //server.os.write(200);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
