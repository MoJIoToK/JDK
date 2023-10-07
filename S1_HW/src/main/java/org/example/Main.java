package org.example;

import org.example.client.Client;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        new Client(server);
        System.out.println("Method main() is over");
    }
}