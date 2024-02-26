package com.example.donichat.model.Conections;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{

    private String serverIp;
    private int serverPort;
    private Socket socket;
    private InputStream is;
    private OutputStream os;

    public Client(String serverIp, int serverPort){
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public Client() {
    }

    public void start() throws UnknownHostException, IOException {
        System.out.println("(Cliente)... estableciendo conexión....");
        socket = new Socket(serverIp, serverPort);
        os = socket.getOutputStream();
        is = socket.getInputStream();

        System.out.println("(Cliente)... conexión establecida.");
    }

    public void stop() throws IOException {
        System.out.println("(Cliente) ... cliente cerrando conexiones...");
        is.close();
        os.close();
        socket.close();
        System.out.println("(Cliente) ... Conexiones del cliente cerradas ...");
    }
    public void sendMessage(String message) {
        Client client = new Client("192.168.1.64", 49191);
        try {
            client.start();
            client.os.write(message.getBytes());
            client.stop();
        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

    }


}
