package ru.job4j.lsp.example2;

/**
 * Нарушение LSP
 * Наследуемый класс не реализует поведение родительского класса
 */
public class Giraffe extends Animal {
    public Giraffe(String name, int age) {
        super(name, age);
    }

    @Override
    public String makeSound() {
        throw new UnsupportedOperationException("Giraffe can't make sound");
    }
}
