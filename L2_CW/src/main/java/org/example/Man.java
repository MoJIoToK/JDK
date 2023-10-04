package org.example;

public class Man implements Human{

    @Override
    public void walk() {
        System.out.println("Walks on two feet");
    }

    @Override
    public void talk() {
        System.out.println("Talk meaningfull words");
    }
}
