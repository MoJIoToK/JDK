package org.example.client;

import org.example.server.Server;

public class Client  {

    private ClientView clientView;
    private static final String FILENAME = "Log.txt";
    private static boolean isLogin = false;
    Server server;
    private String name;

    Client(ClientView clientView, Server server){
        this.clientView = clientView;
        this.server = server;
    }

    public boolean connectToServer(String name){
        this.name = name;
        if (server.connectUser(this)){
            isLogin = true;
            String log = server.getLog();
            if (log != null){
                printText(log);
                printText("You are successfully connected!");
            } else {
                printText("You are successfully connected!");
            }
            return true;
        } else {
            System.out.println("Херня");
            printText("Подключение не удалось");
        }
        return false;
    }

    public void disconnect(){
        if (isLogin){
            isLogin = false;
            //clientView.disconnectFromServer();
            server.disconnectUser(this);
            printText("Вы были отключены от сервера!");
        }
    }

    public void sendMessage(String message){
        if (isLogin){
            if (!message.isEmpty()){
                server.message(name + ": " + message);
            }
        } else {
            printText("Нет подключения к серверу");
        }
    }

    public void serverAnswer(String text){
        printText(text);
    }

    private void printText(String text){
        clientView.showMessage(text);
    }

}
