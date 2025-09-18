package ru.job4j.dip.example2;

import java.util.List;

/**
 * Нарушение принципа DIP
 * Дрессировщик умеет обучать не только собак, но и других животных.
 * Правильным решением будет принимать в аргументы метода train() список Animal
 */
public class AnimalTrainer {
    public void train(List<Dog> animals) {
        for (Dog dog : animals) {
            dog.runByCircle();
            dog.makeSound();
        }
    }
}
