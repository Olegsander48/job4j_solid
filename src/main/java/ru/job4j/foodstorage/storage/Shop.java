package ru.job4j.foodstorage.storage;

import ru.job4j.foodstorage.calculator.ExpirationCalculator;
import ru.job4j.foodstorage.food.Food;

import java.time.Duration;
import java.time.LocalDateTime;

public class Shop extends AbstractStore {
    /**
     * First of all we check that food is not expired
     * using calculateExpirationProgress() we get the ratio between the number of days that have passed
     * to the total number of expiration days.
     * if food almost expired (less than 75% of validDays) - decrease price to 20%
     *
     * @param food food
     * @return true if pass requirements, false if not
     */
    @Override
    public boolean add(Food food) {
        LocalDateTime now = LocalDateTime.now();
        if (Duration.between(food.getExpiryDate(), now).isNegative()) {
            long ratio = ExpirationCalculator.calculateExpirationProgress(food);
            if (ratio > ALMOST_NEW && ratio < TIME_TO_SELL) {
                return super.add(food);
            }
            if (ratio > TIME_TO_SELL && ratio <= EXPIRED) {
                food.setPrice((int) (food.getPrice() * 0.8));
                food.setDiscount(20);
                return super.add(food);
            }
        }
        return false;
    }
}
