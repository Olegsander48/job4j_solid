package ru.job4j.dip.example1;

import ru.job4j.srp.example2.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Нарушение принципа DIP
 * Правильным решением будет выделить репозиторий в интерфейс и определить реализацию InMemoryUserRepository
 */
public class UserRepository {
    private List<User> userList = new ArrayList<>();

    boolean save(User user) {
        return userList.add(user);
    }

    void remove(int userId) {
        userList.remove(userId);
    }

    List<User> findAll() {
        return List.copyOf(userList);
    }
}
