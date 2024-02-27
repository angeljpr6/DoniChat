package com.example.donichat.model;

import com.google.gson.annotations.Expose;

public class Message {
    @Expose
    public int idSender;
    @Expose
    public int idReceptor;
    @Expose
    public String message;


    public Message( int idSender, int idReceptor, String message) {

        this.idSender = idSender;
        this.idReceptor = idReceptor;
        this.message = message;

    }

    public int getIdSender() {
        return idSender;
    }

    public int getIdReceptor() {
        return idReceptor;
    }

    public String getMessage() {
        return message;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public void setIdReceptor(int idReceptor) {
        this.idReceptor = idReceptor;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
