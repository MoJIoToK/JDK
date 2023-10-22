package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        System.out.println(Thread.currentThread().getName());

        //запуск потока различными способами:
        for (int i = 0; i < 3; i++) {
            MyThread thread = new MyThread();
            thread.start();
            thread.join();
        }
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
            thread.join();// позволяет вызвать следующий поток, после выполнения команд предыдущего
        }
//        for (int i = 0; i < 3; i++) {
//            new Thread(()->{
//                System.out.println("3. Hello from: " + Thread.currentThread());
//            }).start();
//        }
        Thread tic = new Thread(new TicTak("["));
        Thread tak = new Thread(new TicTak("]"));
        tic.setDaemon(true); // делаем сервисные поток
        tak.setDaemon(true);
        tic.start();
        tak.start();
    }
}