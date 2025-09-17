package ru.job4j.foodstorage.food;

import java.time.LocalDateTime;

public class Bread extends Food {
    private double weight;

    public Bread(String name, LocalDateTime expiryDate, LocalDateTime createDate, int price, double discount, double weight) {
        super(name, expiryDate, createDate, price, discount);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
