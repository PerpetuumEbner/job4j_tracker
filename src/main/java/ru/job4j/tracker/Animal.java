package ru.job4j.tracker;

public class Animal {
    public Animal() {
        super();
        System.out.println("Animal");
    }

    public Animal(String name) {
        super();
        System.out.println(name);
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Tiger tiger1 = new Tiger("Tigra");
    }
}