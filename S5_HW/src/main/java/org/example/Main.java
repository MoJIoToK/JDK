package org.example;

import java.util.concurrent.Semaphore;

public class Main {
//    Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
//Вилки лежат на столе между каждой парой ближайших философов.
//Каждый философ может либо есть, либо размышлять.
//Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
//Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
//Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны

    private final static int COUNT_PHILOSOPHER = 5;

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < COUNT_PHILOSOPHER; i++) {
            new Thread(new Philosopher(semaphore, i)).start();
        }
    }
}