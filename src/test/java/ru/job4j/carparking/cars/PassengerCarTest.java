package ru.job4j.carparking.cars;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PassengerCarTest {
    @Test
    void whenCreatePassengerCarThenSizeEqualsDefaultPassengerCarSize() {
        PassengerCar passengerCar = new PassengerCar("Mercedes", "c200");
        assertThat(passengerCar.getSize()).isEqualTo(Car.PASSENGER_CAR_SIZE);
    }

}