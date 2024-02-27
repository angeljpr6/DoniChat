package com.example.donichat.model;

import com.example.donichat.model.Conections.Conection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ControllerDB {
    private static Connection c = Conection.con;

    public static ArrayList<Message> getConversation(int id, int id2){
        PreparedStatement stm;
        try {
            ArrayList<Message> listMessage=new ArrayList<>();
            stm = c.prepareStatement("SELECT idremitente, iddestinatario, mensaje FROM mensajes WHERE (idremitente = ? AND iddestinatario = ?) OR (idremitente = ? AND iddestinatario = ?);");
            stm.setInt(1, id);
            stm.setInt(2, id2);
            stm.setInt(3, id2);
            stm.setInt(4, id);
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                int idSender = result.getInt( 1);
                int idReceptor = result.getInt( 2);
                String message = result.getString( 3);
                Message m=new Message(idSender,idReceptor,message);
                listMessage.add(m);
            }
            return listMessage;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<User> getAllUsers(){
        PreparedStatement stm;
        ArrayList<User> user = new ArrayList<>();

        try {
            stm = c.prepareStatement("SELECT * from usuarios;");

            ResultSet result = stm.executeQuery();
            while (result.next()) {
                int id=result.getInt(1);
                String name=result.getString(2);
                user.add(new User(id,name));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    public static User verifyUser(String userName,String userPassword){
        PreparedStatement stm;
        User user=null;
        try {
            stm = c.prepareStatement("SELECT * from usuarios where nombre=? and clave=?;");
            stm.setString(1, userName);
            stm.setString(2, userPassword);
            ResultSet result = stm.executeQuery();
            if (result.next()) {
                int id=result.getInt(1);
                String name=result.getString(2);
                user=new User(id,name);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }


}
