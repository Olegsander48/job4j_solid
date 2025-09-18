package ru.job4j.carparking.parking;

import ru.job4j.carparking.cars.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractParking implements Parking {
    private int cargoParkingSpaces;
    private int passengerParkingSpaces;
    private final List<Car> parkingSpaces;

    public AbstractParking(int cargoParkingSpaces, int passengerParkingSpaces) {
        this.cargoParkingSpaces = cargoParkingSpaces;
        this.passengerParkingSpaces = passengerParkingSpaces;
        this.parkingSpaces = new ArrayList<>(cargoParkingSpaces + passengerParkingSpaces);
    }

    @Override
    public boolean add(Car car) {
        return parkingSpaces.add(car);
    }

    @Override
    public void remove(Car car) {
        parkingSpaces.remove(car);
    }

    @Override
    public Car findByCarId(int carId) {
        return parkingSpaces.get(carId);
    }

    @Override
    public List<Car> findAll() {
        return List.copyOf(parkingSpaces);
    }

    public int getCargoParkingSpaces() {
        return cargoParkingSpaces;
    }

    public int getPassengerParkingSpaces() {
        return passengerParkingSpaces;
    }

    public void setCargoParkingSpaces(int cargoParkingSpaces) {
        this.cargoParkingSpaces = cargoParkingSpaces;
    }

    public void setPassengerParkingSpaces(int passengerParkingSpaces) {
        this.passengerParkingSpaces = passengerParkingSpaces;
    }
}
