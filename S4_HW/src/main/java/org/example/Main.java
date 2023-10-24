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
        directory.printDirectory();

//        directory.add(new Worker(1, "1", "first", "CEO"));
//        directory.add(new Worker(2, "2", "second", "janitor"));
//        directory.add(new Worker(3, "3", "third", "CEO"));
//        directory.add(new Worker(4, "4", "second", "Cook"));
//
//        for (Worker worker: directory) {
//            System.out.println(worker);
//        }
//        ArrayList<Worker> list = findByExp(directory, "CEO");
//        System.out.println(list);
//
//        System.out.println();
//        ArrayList<Worker> list1 = getPhoneByName(directory, "second");
//        System.out.println(list1);
//
//        System.out.println();
//        addNewWorker();

    }

    //Добавить метод, который ищет сотрудника по стажу (может быть список)
//    private static ArrayList<Worker> findByExp(ArrayList<Worker> workers,String experience){
//        ArrayList<Worker> result = new ArrayList<>();
//        for (Worker worker: workers) {
//            if(worker.getExperience().equals(experience)){
//                result.add(worker);
//            }
//        }
//        return result;
//        //result.stream().filter(n -> n.equals(experience)).collect(Collectors.toList());
//        //return workers.stream().filter(n -> n.equals(experience)).collect(Collectors.toList());
//    }

//    //Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
//    private static ArrayList<Worker> getPhoneByName(ArrayList<Worker> workers, String name){
//        //ArrayList result = new ArrayList<>();
////        ListIterator<Worker> iterator = workers.listIterator();
////        if (iterator.hasNext()){
////            Worker worker = iterator.next();
////            if (worker.getName().equals(name)){
////                result.add(worker);
////            }
////        }
//        //result.add(workers.stream().filter(worker -> worker.getName().equals(name)).collect(Collectors.toList()));
//        //result.add(workers.stream().allMatch(worker -> worker.getName().equals(name)));
//        //result.add(workers.stream().findAny(worker -> worker.getName().equals(name).get()));
//        //return workers.stream().filter(worker -> worker.getName().equals(name)).findAny().get();
//        return (ArrayList<Worker>) workers.stream().filter(worker -> worker.getName().equals(name)).collect(Collectors.toList());
//    }
//
//    //Добавить метод добавление нового сотрудника в справочник
//    private void addNewWorker(Worker worker){
//        this.directory.add(worker);
//    }

}