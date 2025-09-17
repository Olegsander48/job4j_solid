package ru.job4j.foodstorage.storage;

import ru.job4j.foodstorage.food.Food;

import java.time.Duration;
import java.time.LocalDateTime;

public class Shop extends AbstractStore {
    /**
     * First of all we check that food is not expired
     * validDays - the food valid in days
     * passedDays - how many days passed after food was produced
     * if food almost expired (less than 75% of validDays) - decrease price to 20%
     * @param food food
     * @return true if pass requirements, false if not
     */
    @Override
    public boolean add(Food food) {
        LocalDateTime now = LocalDateTime.now();
        if (Duration.between(food.getExpiryDate(), now).isNegative()) {
            long validDays = Duration.between(food.getCreateDate(), food.getExpiryDate()).toDays();
            long passedDays = Duration.between(food.getCreateDate(), now).toDays();
            long ratio = passedDays * 100 / validDays;
            if (ratio > 25 && ratio < 75) {
                return super.add(food);
            }
            if (ratio > 75 && ratio <= 100) {
                food.setPrice((int) (food.getPrice() * 0.8));
                food.setDiscount(20);
                return super.add(food);
            }
        }
        return false;
    }
}
