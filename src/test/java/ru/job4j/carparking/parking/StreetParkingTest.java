package ru.job4j.carparking.parking;

import org.junit.jupiter.api.Test;
import ru.job4j.carparking.cars.Car;
import ru.job4j.carparking.cars.CargoCar;
import ru.job4j.carparking.cars.PassengerCar;

import static org.assertj.core.api.Assertions.*;

class StreetParkingTest {
    @Test
    void whenParkPassengerCarOnParkingThenOk() {
        StreetParking parking = new StreetParking(0, 1);
        Car passengerCar = new PassengerCar("Mercedes", "c200");
        parking.add(passengerCar);
        assertThat(parking.findAll())
                .hasSize(1)
                .contains(passengerCar);
        assertThat(parking.getPassengerParkingSpaces()).isZero();
    }

    @Test
    void whenPark3PassengerCarOnParkingThenOk() {
        StreetParking parking = new StreetParking(0, 3);
        Car passengerCar1 = new PassengerCar("Mercedes", "c200");
        Car passengerCar2 = new PassengerCar("BMW", "320d");
        Car passengerCar3 = new PassengerCar("Audi", "a4");
        parking.add(passengerCar1);
        parking.add(passengerCar2);
        parking.add(passengerCar3);
        assertThat(parking.findAll())
                .hasSize(3)
                .contains(passengerCar1, passengerCar2, passengerCar3);
        assertThat(parking.getPassengerParkingSpaces()).isZero();
    }

    @Test
    void whenParkCargoCarOnParkingThenOk() {
        StreetParking parking = new StreetParking(1, 0);
        Car cargoCar = new CargoCar(8, "Mercedes", "unimog");
        parking.add(cargoCar);
        assertThat(parking.findAll())
                .hasSize(1)
                .contains(cargoCar);
        assertThat(parking.getCargoParkingSpaces()).isZero();
    }

    @Test
    void whenPark3CargoCarOnParkingThenOk() {
        StreetParking parking = new StreetParking(3, 0);
        Car cargoCar1 = new CargoCar(8, "Mercedes", "unimog");
        Car cargoCar2 = new CargoCar(6, "Scania", "r450");
        Car cargoCar3 = new CargoCar(3, "DAF", "xf480");
        parking.add(cargoCar1);
        parking.add(cargoCar2);
        parking.add(cargoCar3);
        assertThat(parking.findAll())
                .hasSize(3)
                .contains(cargoCar1, cargoCar2, cargoCar3);
        assertThat(parking.getCargoParkingSpaces()).isZero();
    }

    @Test
    void whenParkPassengerCarOnParkingOnlyForCargoCarsThenReturnFalse() {
        StreetParking parking = new StreetParking(5, 0);
        Car passengerCar = new PassengerCar("Mercedes", "c200");
        boolean result = parking.add(passengerCar);
        assertThat(result).isFalse();
        assertThat(parking.findAll()).isEmpty();
    }

    @Test
    void whenParkCargoCarOnParkingOnlyForPassengerCarsWithEnoughSpaceThenOk() {
        StreetParking parking = new StreetParking(0, 8);
        Car cargoCar = new CargoCar(8, "Mercedes", "unimog");
        parking.add(cargoCar);
        assertThat(parking.findAll())
                .hasSize(1)
                .contains(cargoCar);
        assertThat(parking.getPassengerParkingSpaces()).isZero();
    }

    @Test
    void whenParkCargoCarOnParkingOnlyForPassengerCarsWithoutEnoughSpaceThenReturnFalse() {
        StreetParking parking = new StreetParking(0, 1);
        Car cargoCar = new CargoCar(8, "Mercedes", "unimog");
        boolean result = parking.add(cargoCar);
        assertThat(result).isFalse();
        assertThat(parking.findAll()).isEmpty();
    }

    @Test
    void whenParkPassengerAndCargoCarOnParkingThenOk() {
        StreetParking parking = new StreetParking(1, 1);
        Car passengerCar = new PassengerCar("Mercedes", "c200");
        parking.add(passengerCar);
        Car cargoCar = new CargoCar(8, "Mercedes", "unimog");
        parking.add(cargoCar);
        assertThat(parking.findAll())
                .hasSize(2)
                .contains(passengerCar, cargoCar);
        assertThat(parking.getCargoParkingSpaces()).isZero();
        assertThat(parking.getPassengerParkingSpaces()).isZero();
    }

    @Test
    void whenParkPassengerAndCargoCarOnParkingOnlyForPassengerCarWithEnoughSpaceThenOk() {
        StreetParking parking = new StreetParking(0, 9);
        Car passengerCar = new PassengerCar("Mercedes", "c200");
        parking.add(passengerCar);
        Car cargoCar = new CargoCar(8, "Mercedes", "unimog");
        parking.add(cargoCar);
        assertThat(parking.findAll())
                .hasSize(2)
                .contains(passengerCar, cargoCar);
        assertThat(parking.getPassengerParkingSpaces()).isZero();
    }

    @Test
    void whenPark3PassengerAnd3CargoCarOnParkingWith1CargoAnd15PassengerSpacesThenOk() {
        StreetParking parking = new StreetParking(1, 15);
        Car cargoCar1 = new CargoCar(8, "Mercedes", "unimog");
        Car cargoCar2 = new CargoCar(6, "Scania", "r450");
        Car cargoCar3 = new CargoCar(3, "DAF", "xf480");
        parking.add(cargoCar1);
        parking.add(cargoCar2);
        parking.add(cargoCar3);
        Car passengerCar1 = new PassengerCar("Mercedes", "c200");
        Car passengerCar2 = new PassengerCar("BMW", "320d");
        Car passengerCar3 = new PassengerCar("Audi", "a4");
        parking.add(passengerCar1);
        parking.add(passengerCar2);
        parking.add(passengerCar3);
        assertThat(parking.findAll())
                .hasSize(6)
                .contains(cargoCar1, cargoCar2, cargoCar3, passengerCar1, passengerCar2, passengerCar3);
        assertThat(parking.getCargoParkingSpaces()).isZero();
        assertThat(parking.getPassengerParkingSpaces()).isEqualTo(3);
    }

    @Test
    void whenPark3PassengerAnd3CargoCarOnParkingWith15CargoAnd15PassengerSpacesThenOkAndLeft12CargoAnd12PassengerSpaces() {
        StreetParking parking = new StreetParking(15, 15);
        Car cargoCar1 = new CargoCar(8, "Mercedes", "unimog");
        Car cargoCar2 = new CargoCar(6, "Scania", "r450");
        Car cargoCar3 = new CargoCar(3, "DAF", "xf480");
        parking.add(cargoCar1);
        parking.add(cargoCar2);
        parking.add(cargoCar3);
        Car passengerCar1 = new PassengerCar("Mercedes", "c200");
        Car passengerCar2 = new PassengerCar("BMW", "320d");
        Car passengerCar3 = new PassengerCar("Audi", "a4");
        parking.add(passengerCar1);
        parking.add(passengerCar2);
        parking.add(passengerCar3);
        assertThat(parking.findAll())
                .hasSize(6)
                .contains(cargoCar1, cargoCar2, cargoCar3, passengerCar1, passengerCar2, passengerCar3);
        assertThat(parking.getPassengerParkingSpaces()).isEqualTo(12);
        assertThat(parking.getCargoParkingSpaces()).isEqualTo(12);
    }
}