package ru.job4j.foodstorage.storage;

import ru.job4j.foodstorage.food.Food;

import java.time.Duration;
import java.time.LocalDateTime;

public class Warehouse extends AbstractStore {
    /**
     * First of all we check that food is not expired
     * validDays - the food valid in days
     * passedDays - how many days passed after food was produced
     * @param food food
     * @return true if pass requirements, false if not
     */
    @Override
    public boolean add(Food food) {
        LocalDateTime now = LocalDateTime.now();
        if (Duration.between(food.getExpiryDate(), now).isNegative()) {
            long validDays = Duration.between(food.getCreateDate(), food.getExpiryDate()).toDays();
            long passedDays = Duration.between(food.getCreateDate(), now).toDays();
            if (passedDays * 100 / validDays <= 25) {
                return super.add(food);
            }
        }
        return false;
    }
}
