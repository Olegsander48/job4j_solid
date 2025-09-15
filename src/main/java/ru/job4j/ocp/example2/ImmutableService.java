package ru.job4j.ocp.example2;

/**
 *  Пример нарушения OCP
 *  Когда нам понадобится добавить функциональность в данный класс - единственный вариант только его изменять,
 *  т.к. он immutable
 */
public final class ImmutableService {
    private final String state;

    private ImmutableService(String state) {
        this.state = state;
    }

    public ImmutableService getImmutableService() {
        return new ImmutableService("test");
    }
}
