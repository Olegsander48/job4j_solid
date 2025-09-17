package ru.job4j.foodstorage.storage;

import org.junit.jupiter.api.Test;
import ru.job4j.foodstorage.food.Bread;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class TrashTest {
    @Test
    void whenAddExpiredBreadThenGetItInTrash() {
        Trash trash = new Trash();
        Bread bread = new Bread("Borodinskiy",
                LocalDateTime.of(2025, 5, 30, 17, 25),
                LocalDateTime.of(2025, 1, 8, 11, 34),
                25,
                0,
                230.50);
        boolean result = trash.add(bread);
        assertThat(result).isTrue();
    }

    @Test
    void whenAddNonExpiredBreadThenDontGetItInTrash() {
        Trash trash = new Trash();
        Bread bread = new Bread("Borodinskiy",
                LocalDateTime.of(2025, 12, 30, 17, 25),
                LocalDateTime.of(2025, 9, 8, 11, 34),
                25,
                0,
                230.50);
        boolean result = trash.add(bread);
        assertThat(result).isFalse();
    }
}