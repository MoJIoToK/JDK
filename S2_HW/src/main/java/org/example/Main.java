package org.example;

import org.example.client.ClientGUI;
import org.example.server.Server;

public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        new ClientGUI(server);

        System.out.println("Method main() is over");
    }
}