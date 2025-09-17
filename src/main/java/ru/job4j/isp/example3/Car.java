package ru.job4j.isp.example3;

/**
 * Нарушение принципа ISP
 * Не у всех автомобилей имеется возможность открыть крышу
 */
public interface Car {
    void startEngine();

    void move();

    void openWindow();

    void openRoof();
}
