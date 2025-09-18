package ru.job4j.dip.example3;

import ru.job4j.dip.example2.Dog;

import java.util.LinkedList;

/**
 * Пример нарушения DIP
 * Правильным решением будет использовать интерфейс и вернуть List<Dog>
 */
public interface SimpleRepository {
    LinkedList<Dog> findAll();
}
