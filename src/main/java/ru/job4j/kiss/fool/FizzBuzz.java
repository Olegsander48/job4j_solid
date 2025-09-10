package ru.job4j.kiss.fool;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        NumberChecker checker = new NumberChecker();
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(checker.checkNumber(startAt));
            startAt++;
            var answer = input.nextLine();
            if (!checker.checkNumber(startAt).equals(answer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }
}
