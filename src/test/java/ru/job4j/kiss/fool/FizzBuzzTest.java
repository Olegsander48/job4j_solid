package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class FizzBuzzTest {
    @Test
    void checkNumber() {
        assertThat(FizzBuzz.checkNumber(1)).isEqualTo("1");
        assertThat(FizzBuzz.checkNumber(2)).isEqualTo("2");
        assertThat(FizzBuzz.checkNumber(3)).isEqualTo("Fizz");
        assertThat(FizzBuzz.checkNumber(4)).isEqualTo("4");
        assertThat(FizzBuzz.checkNumber(5)).isEqualTo("Buzz");
        assertThat(FizzBuzz.checkNumber(7)).isEqualTo("7");
        assertThat(FizzBuzz.checkNumber(10)).isEqualTo("Buzz");
        assertThat(FizzBuzz.checkNumber(15)).isEqualTo("FizzBuzz");
        assertThat(FizzBuzz.checkNumber(30)).isEqualTo("FizzBuzz");
    }
  
}