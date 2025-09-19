package ru.job4j.foodstorage.storage;

import ru.job4j.foodstorage.food.Food;

import java.util.List;
import java.util.function.Predicate;

public interface Store {
    boolean add(Food food);

    void remove(Food food);

    List<Food> getAll();

    List<Food> findBy(Predicate<Food> predicate);

    boolean contains(Food food);

    void removeAll();
}
