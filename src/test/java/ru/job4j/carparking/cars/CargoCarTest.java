package ru.job4j.carparking.cars;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Disabled
class CargoCarTest {
    @Test
    void whenCreateCargoCarWithPassengerCarSizeThenGetException() {
        assertThatThrownBy(() -> new CargoCar(Car.PASSENGER_CAR_SIZE, "Mercedes", "unimog"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Cargo car size must be greater than passenger car size");
    }
}