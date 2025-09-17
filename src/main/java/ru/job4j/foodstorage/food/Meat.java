package ru.job4j.foodstorage.food;

import java.time.LocalDateTime;

public class Meat extends Food {
    private MeatType meatType;
    private double weight;

    public Meat(String name, LocalDateTime expiryDate, LocalDateTime createDate, int price, double discount, MeatType meatType, double weight) {
        super(name, expiryDate, createDate, price, discount);
        this.meatType = meatType;
        this.weight = weight;
    }

    public MeatType getMeatType() {
        return meatType;
    }

    public void setMeatType(MeatType meatType) {
        this.meatType = meatType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
