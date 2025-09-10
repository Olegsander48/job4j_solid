package ru.job4j.kiss.fool;

public class NumberChecker {
    public String checkNumber(int startAt) {
        StringBuilder answer = new StringBuilder();
        if (startAt % 3 == 0) {
            answer.append("Fizz");
        }
        if (startAt % 5 == 0) {
            answer.append("Buzz");
        }
        return answer.isEmpty() ? String.valueOf(startAt) : answer.toString();
    }
}
