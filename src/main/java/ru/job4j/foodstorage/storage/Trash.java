package ru.job4j.foodstorage.storage;

import ru.job4j.foodstorage.food.Food;

import java.time.Duration;
import java.time.LocalDateTime;

public class Trash extends AbstractStore {
    @Override
    public boolean add(Food food) {
        LocalDateTime now = LocalDateTime.now();
        if (Duration.between(food.getExpiryDate(), now).isPositive()) {
            return super.add(food);
        }
        return false;
    }
}
