package org.example;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Directory directory = new Directory();
        directory.addNewWorker(new Worker(1, "1", "first", "CEO"));
        directory.addNewWorker(new Worker(2, "2", "second", "janitor"));
        directory.addNewWorker(new Worker(3, "3", "third", "CEO"));
        directory.addNewWorker(new Worker(4, "4", "second", "Cook"));

        System.out.println("Исходный справочник:");
        directory.printDirectory();
        System.out.println("\nРезультат поиска работника по стажу:");
        directory.experienceFind("CEO");

        System.out.println("\nРезультат поиска работника по имени:");
        directory.getPhone("second");

        System.out.println("\nРезультат поиска работника по табельному номеру:");
        directory.getByNumber(4);

    }

}