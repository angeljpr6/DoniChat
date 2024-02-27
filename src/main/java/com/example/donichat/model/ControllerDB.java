package com.example.donichat.model;

import com.example.donichat.model.Conections.Conection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ControllerDB {
    private static Connection c = Conection.con;

    public static ArrayList<Message> getConversation(User sender, User receptor){
        PreparedStatement stm;
        try {
            ArrayList<Message> listMessage=new ArrayList<>();
            stm = c.prepareStatement("SELECT idremitente, iddestinatario, mensaje FROM mensajes WHERE (idremitente = ? AND iddestinatario = ?) OR (idremitente = ? AND iddestinatario = ?);");
            stm.setInt(1, sender.getId());
            stm.setInt(2, receptor.getId());
            stm.setInt(3, receptor.getId());
            stm.setInt(4, sender.getId());
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
}
