package ru.job4j.carparking.cars;

import java.util.Objects;

public abstract class Car {
    public static final int PASSENGER_CAR_SIZE = 1;
    private final int size;
    private final String brand;
    private final String model;

    public Car(int size, String brand, String model) {
        this.size = size;
        this.brand = brand;
        this.model = model;
    }

    public int getSize() {
        return size;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return size == car.size && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, brand, model);
    }
}
