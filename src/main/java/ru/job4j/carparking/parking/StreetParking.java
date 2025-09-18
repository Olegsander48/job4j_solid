package ru.job4j.carparking.parking;

import ru.job4j.carparking.cars.Car;

public class StreetParking extends AbstractParking {
    public StreetParking(int cargoParkingSpaces, int passengerParkingSpaces) {
        super(cargoParkingSpaces, passengerParkingSpaces);
    }

    @Override
    public boolean add(Car car) {
        return super.add(car);
    }
}
