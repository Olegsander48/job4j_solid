package ru.job4j.ocp.example1;

/**
 * Пример нарушения OCP
 * Когда нам понадобилось добавить функциональность по рисованию квадрата - пришлоось изменять уже написанный код
 */
public class Painter {
    void drawCircle(Circle circle) {
        System.out.println("Draw circle");
    }

    void drawSquare(Square square) {
        System.out.println("Draw square");
    }
}
