package com.example.donichat.model;

public class User {
    private int id;
    private  String name;
    private String password;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void verifyUser(){

    }
}
