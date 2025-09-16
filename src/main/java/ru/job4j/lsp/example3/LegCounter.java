package ru.job4j.lsp.example3;

import java.util.List;

/**
 * Метод данного класса нарушает LSP
 * результат работы зависит от класса сущности
 */
public class LegCounter {
    public void count(List<Animal> animals) {
        for (Animal animal : animals) {
            if (animal instanceof Spider) {
                System.out.println("Spider has 8 legs");
            } else if (animal instanceof Snake) {
                System.out.println("Snake doesn't have legs");
            }
        }
    }
}
