package org.example;

public class Task implements Runnable{

    private final int value;

    public Task(int left) {
        this.value = left;
    }

    @Override
    public void run() {
        System.out.println(value);
    }

    @Override
    public String toString() {
        return String.format("(%s + %s)", value);
    }
}
