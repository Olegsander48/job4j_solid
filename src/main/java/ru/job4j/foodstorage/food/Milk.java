package ru.job4j.foodstorage.food;

import java.time.LocalDateTime;

public class Milk extends Food {
    private double fatPercentage;
    private double volume;

    public Milk(String name, LocalDateTime expiryDate, LocalDateTime createDate, int price, double discount, double fatPercentage, double volume) {
        super(name, expiryDate, createDate, price, discount);
        this.fatPercentage = fatPercentage;
        this.volume = volume;
    }

    public double getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(double fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
