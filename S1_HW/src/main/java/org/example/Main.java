package org.example;

import org.example.client.ClientGUI;
import org.example.server.Server;
import org.example.server.ServerGUI;
import org.example.server.ServerView;

public class Main {

    public static void main(String[] args) {
        Server server = new Server();
//        //ServerView serverView = new ServerGUI();
//        ServerGUI serverGUI = new ServerGUI();
//        Server server = new Server(serverGUI);
        new ClientGUI(server);
        System.out.println("Method main() is over");
    }
}