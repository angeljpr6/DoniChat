package com.example.donichat.Controller;
import com.example.donichat.model.User;
import com.example.donichat.model.Conections.Client;
import com.example.donichat.model.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChatScreen implements Initializable {
    public TextField areaMessage;
    public TextArea conversation;
    public Label userName;
    public static User user;
    public static User user2;
    public static Client c=new Client();
    public TableView usersTable;
    public TableColumn<User, String> usersNamesColumn;
    public Label chatSelected;

    public void sendMessage(ActionEvent actionEvent) {
        Message m=new Message(user.getId(), user2.getId(), areaMessage.getText());
        c.sendMessage(m);
        areaMessage.setText("");
    }

    public void getMessages() {
        ArrayList<Message> listMessage=new ArrayList<>();
        listMessage=c.receiveMessage();
        fillField(listMessage);

    }

    public void fillUsersTable(){
        ArrayList<User> users = c.getUsers();
        ObservableList<User> userList = FXCollections.observableArrayList();

        userList.addAll(users);

        usersNamesColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        usersTable.setItems(userList);

    }

    public void fillField(ArrayList<Message>listMessage){
        String nameUser=user.getName();
        String nameUser2="";
        if(user2!=null){
            nameUser2=user2.getName();
        }
        conversation.setText("");
        for (int i = 0; i < listMessage.size(); i++) {
            if(listMessage.get(i).getIdSender()==user.getId()){
                conversation.setText(conversation.getText()+nameUser+": "+listMessage.get(i).getMessage()+"\n"+"\n");
            }else {
                conversation.setText(conversation.getText()+nameUser2+": "+listMessage.get(i).getMessage()+"\n"+"\n");

            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userName.setText(user.getName());
        Thread thread = new Thread(this::periodicTask);
        thread.start();
        fillUsersTable();
    }

    private void periodicTask() {
        while (true) {
            try {
                getMessages();
                if (user2!=null){
                    System.out.println(user2.getId());
                }

                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeUser(MouseEvent mouseEvent) {
        user2= (User) usersTable.getSelectionModel().getSelectedItem();
        chatSelected.setText(user2.getName());
    }
}
