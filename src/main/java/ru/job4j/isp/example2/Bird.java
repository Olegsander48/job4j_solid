package ru.job4j.isp.example2;

import ru.job4j.foodstorage.food.Food;

/**
 * Нарушение принципа ISP
 * не все птицы умеют летать, и для некоторых данный интерфейс не подойдет
 */
public interface Bird {
    void eat(Food food);

    void sleep(int hours);

    void fly(int distance);
}
