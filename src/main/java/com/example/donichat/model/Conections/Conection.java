package com.example.donichat.model.Conections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conection {
    public static Connection con = new Conection().conectar();
    private static final String user = "root";
    private static final String pass = "1234";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/donichat?characterEncoding=utf8";
    public Connection conectar(){
        con = null;

        try {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("conectado");
            if(con!= null){

            }
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
