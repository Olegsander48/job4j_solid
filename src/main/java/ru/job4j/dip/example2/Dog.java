package ru.job4j.dip.example2;

public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark-bark");
    }

    @Override
    public void runByCircle() {
        System.out.println("Dog run by circle");
    }
}
