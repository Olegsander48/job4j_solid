package ru.job4j.carparking.parking;

import ru.job4j.carparking.cars.Car;

import java.util.List;

public interface Parking {
    boolean add(Car car);

    void remove(Car car);

    Car findByCarId(int carId);

    List<Car> findAll();
}
