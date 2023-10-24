package org.example;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class Directory {
    private ArrayList<Worker> directory = new ArrayList<>();

    public void experienceFind(String experience) {
        ArrayList<Worker> list = findByExp(directory, experience);
        printList(list);
    }

    public void getPhone(String name) {
        ArrayList<Worker> list1 = getPhoneByName(directory, name);
        printList(list1);
    }

    public void getByNumber(Integer num) {
        System.out.println(getWorkerByNumber(directory, num));
    }

    //Добавить метод, который ищет сотрудника по стажу (может быть список)
    private static ArrayList<Worker> findByExp(ArrayList<Worker> workers, String experience) {
        //Решение через foreach
//        ArrayList<Worker> result = new ArrayList<>();
//        for (Worker worker : workers) {
//            if (worker.getExperience().equals(experience)) {
//                result.add(worker);
//            }
//        }
//        return result;

        //Решение через stream:
        return (ArrayList<Worker>) workers.stream().filter(worker -> worker.getExperience().equals(experience)).collect(Collectors.toList());
    }

    //Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
    private static ArrayList<Worker> getPhoneByName(ArrayList<Worker> workers, String name) {
        //Решение через Iterator
        ArrayList result = new ArrayList<>();
        ListIterator<Worker> iterator = workers.listIterator();
        while (iterator.hasNext()){
            Worker worker = iterator.next();
            if (worker.getName().equals(name)){
                result.add(worker);
            }
        }
        return result;

        //Решение через stream:
//        return (ArrayList<Worker>) workers.stream().filter(worker -> worker.getName().equals(name)).collect(Collectors.toList());
    }

    //Добавить метод, который ищет сотрудника по табельному номеру
    private static Worker getWorkerByNumber(ArrayList<Worker> workers, Integer number) {
        return workers.stream().filter(worker -> worker.getNumber().equals(number)).findFirst().get();
    }

    //Добавить метод добавление нового сотрудника в справочник
    public void addNewWorker(Worker worker) {
        this.directory.add(worker);
    }

    //Печать коллекции
    private void printList(ArrayList<Worker> workers) {
        for (Worker worker : workers) {
            System.out.println(worker);
        }
    }

    public void printDirectory() {
        printList(directory);
    }
}
