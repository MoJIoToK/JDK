package org.example;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread {
    private final String name;
    private final int leftFork;
    private final int rightFork;
    private int countEat;
    private final Random random;
    private final CountDownLatch cdl;
    private final Table table;

    public Philosopher(String name, Table table, int leftFork, int rightFork, CountDownLatch cdl) {
        this.name = name;
        this.table = table;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.cdl = cdl;
        countEat = 0;
        random = new Random();
    }

    @Override
    public synchronized void run() {
        while (countEat < 3) {
            try {
                thinking();
                eating();
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        }

        System.out.println(name + " наелся до отвала");
        cdl.countDown();
    }

    public void thinking() throws InterruptedException {
        sleep(random.nextLong(100, 2000));
    }

    public void eating() throws InterruptedException {
        if (table.tryGetForks(leftFork, rightFork)) {
            System.out.println(name + " уплетает вермишель, используя вилки: " + leftFork
                    + " и " + rightFork);
            sleep(random.nextLong(3000, 6000));
            table.putForks(leftFork, rightFork);
            System.out.println(name + " покушал, можно и помыслить. " +
                    "Не забыв при этом вернуть вилки " + leftFork + " и " + rightFork);
            countEat++;
        }
    }
}
