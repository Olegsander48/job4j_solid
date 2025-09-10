package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberCheckerTest {
    @Test
    void checkNumber() {
        NumberChecker checker = new NumberChecker();
        assertThat(checker.checkNumber(1)).isEqualTo("1");
        assertThat(checker.checkNumber(2)).isEqualTo("2");
        assertThat(checker.checkNumber(3)).isEqualTo("Fizz");
        assertThat(checker.checkNumber(4)).isEqualTo("4");
        assertThat(checker.checkNumber(5)).isEqualTo("Buzz");
        assertThat(checker.checkNumber(7)).isEqualTo("7");
        assertThat(checker.checkNumber(10)).isEqualTo("Buzz");
        assertThat(checker.checkNumber(15)).isEqualTo("FizzBuzz");
        assertThat(checker.checkNumber(30)).isEqualTo("FizzBuzz");
    }

}