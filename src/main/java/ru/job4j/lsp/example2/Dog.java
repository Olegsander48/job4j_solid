package ru.job4j.lsp.example2;

public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String makeSound() {
        return "Bark-bark";
    }
}
