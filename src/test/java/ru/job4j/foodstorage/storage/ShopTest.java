package ru.job4j.foodstorage.storage;

import org.junit.jupiter.api.Test;
import ru.job4j.foodstorage.food.Bread;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class ShopTest {
    @Test
    void whenAddBreadThenGetItInShop() {
        Shop shop = new Shop();
        Bread bread = new Bread("Borodinskiy",
                LocalDateTime.of(2025, 12, 30, 17, 25),
                LocalDateTime.of(2025, 6, 8, 11, 34),
                25,
                0,
                230.50);
        boolean result = shop.add(bread);
        assertThat(result).isTrue();
    }

    @Test
    void whenAddNewBreadThenDontGetItInShop() {
        Shop shop = new Shop();
        Bread bread = new Bread("Borodinskiy",
                LocalDateTime.of(2025, 12, 30, 17, 25),
                LocalDateTime.of(2025, 9, 17, 11, 34),
                25,
                0,
                230.50);
        boolean result = shop.add(bread);
        assertThat(result).isFalse();
    }

    @Test
    void whenAddOldBreadThenGetCheaperPrice() {
        Shop shop = new Shop();
        Bread bread = new Bread("Borodinskiy",
                LocalDateTime.of(2025, 10, 1, 17, 25),
                LocalDateTime.of(2025, 7, 1, 11, 34),
                25,
                0,
                230.50);
        boolean result = shop.add(bread);
        assertThat(result).isTrue();
        assertThat(bread.getPrice()).isEqualTo(20);
    }

}