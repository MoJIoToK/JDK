package org.example;

public class Worker {

    private int number;
    private String phone;
    private String name;
    private String experience;

    public Worker(int number, String phone, String name, String experience) {
        this.number = number;
        this.phone = phone;
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return String.format("Worker - %d, phone - %s, name - %s, experience - %s", number,
                phone, name, experience);
    }
}
