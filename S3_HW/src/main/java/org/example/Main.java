package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.sum(54, 46));
        System.out.println(Calculator.sum(5f, (long)46));
        System.out.println(Calculator.multiply((byte) 8, 7.0f));
    }
}