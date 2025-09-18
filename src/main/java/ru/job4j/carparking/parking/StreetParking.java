package ru.job4j.carparking.parking;

import ru.job4j.carparking.cars.Car;

public class StreetParking extends AbstractParking {
    public StreetParking(int cargoParkingSpaces, int passengerParkingSpaces) {
        super(cargoParkingSpaces, passengerParkingSpaces);
    }

    /**
     * We are considering 3 situations:
     * 1. We park passenger car on passenger parking space
     * 2. We park cargo car on cargo parking space
     * 3. We park cargo car on passenger parking space only in case no cargo parking spaces, and we have space for truck
     * in all other cases - we return false
     *
     * @param car Car that we want to park
     * @return true if succeeded, false if non-supported scenario or not enough space
     */
    @Override
    public boolean add(Car car) {
        if (car.getSize() == Car.PASSENGER_CAR_SIZE && getPassengerParkingSpaces() > 0) {
            setPassengerParkingSpaces(getPassengerParkingSpaces() - 1);
            return super.add(car);
        }
        if (car.getSize() > Car.PASSENGER_CAR_SIZE && getCargoParkingSpaces() > 0) {
            setCargoParkingSpaces(getCargoParkingSpaces() - 1);
            return super.add(car);
        }
        if (car.getSize() > Car.PASSENGER_CAR_SIZE && getCargoParkingSpaces() == 0 && getPassengerParkingSpaces() >= car.getSize()) {
            setPassengerParkingSpaces(getPassengerParkingSpaces() - car.getSize());
            return super.add(car);
        }
        return false;
    }
}
