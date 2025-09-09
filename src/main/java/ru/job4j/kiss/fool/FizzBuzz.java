package ru.job4j.kiss.fool;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(checkNumber(startAt));
            startAt++;
            var answer = input.nextLine();
            if (!checkNumber(startAt).equals(answer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }

    public static String checkNumber(int startAt) {
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
