package com.example.donichat.model;

public class Message {
    private int id;
    private int idSender;
    private int idReceptor;
    private String message;
    private String fecha;

    public Message(int id, int idSender, int idReceptor, String message, String fecha) {
        this.id = id;
        this.idSender = idSender;
        this.idReceptor = idReceptor;
        this.message = message;
        this.fecha = fecha;
    }
}
