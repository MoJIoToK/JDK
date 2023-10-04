package org.example;

public class Main {
    private static class Minotaurus implements Human, Bull{
        @Override
        public void walk() {
            System.out.println("Walks on two legs");
        }

        @Override
        public void talk() {
            System.out.println("Asks you a riddle");
        }
    }

    public static void main(String[] args) {
        Man man0 = new Man();
        Ox ox0 = new Ox();
        Man man1 = new Man();
        Ox ox1 = new Ox();
    }
}