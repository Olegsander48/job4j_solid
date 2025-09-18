package ru.job4j.foodstorage.calculator;

import ru.job4j.foodstorage.food.Food;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExpirationCalculator {
    public static long calculateExpirationProgress(Food food) {
        long validDays = Duration.between(food.getCreateDate(), food.getExpiryDate()).toDays();
        long passedDays = Duration.between(food.getCreateDate(), LocalDateTime.now()).toDays();
        return passedDays * 100 / validDays;
    }
}
