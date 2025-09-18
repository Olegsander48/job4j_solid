package ru.job4j.foodstorage.calculator;

import org.junit.jupiter.api.Test;
import ru.job4j.foodstorage.food.Bread;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class ExpirationCalculatorTest {
    @Test
    void whenCalculatingExpirationProgressOfNewFoodThenGetLessThan20Percents() {
        Bread bread = new Bread("Borodinskiy",
                LocalDateTime.of(2025, 12, 30, 17, 25),
                LocalDateTime.of(2025, 9, 17, 11, 34),
                25,
                0,
                230.50);
        long result = ExpirationCalculator.calculateExpirationProgress(bread);
        assertThat(result).isLessThan(20);
    }

    @Test
    void whenCalculatingExpirationProgressOfExpiredFoodThenGetMoreThan100Percents() {
        Bread bread = new Bread("Borodinskiy",
                LocalDateTime.of(2022, 12, 30, 17, 25),
                LocalDateTime.of(2022, 9, 17, 11, 34),
                25,
                0,
                230.50);
        long result = ExpirationCalculator.calculateExpirationProgress(bread);
        assertThat(result).isGreaterThan(100);
    }

}