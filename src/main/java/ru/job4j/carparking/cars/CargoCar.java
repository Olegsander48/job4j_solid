package ru.job4j.carparking.cars;

public class CargoCar extends Car {
    public CargoCar(int size, String brand, String model) {
        super(size, brand, model);
        if (size <= Car.PASSENGER_CAR_SIZE) {
            throw new IllegalArgumentException("Cargo car size must be greater than passenger car size");
        }
    }
}
