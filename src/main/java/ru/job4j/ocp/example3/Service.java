package ru.job4j.ocp.example3;

/**
 *  Пример нарушения OCP (+ DIP)
 *  Когда нам понадобится сменить реализацию репозитория - мы полезем в код
 */
public class Service {
    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }
}
