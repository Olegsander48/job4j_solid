package ru.job4j.dip.example1;

import ru.job4j.srp.example2.model.User;

import java.util.List;

/**
 * Нарушение принципа DIP
 * Правильным решением будет использовать интерфейс а не реализацию UserRepository
 */
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    boolean save(User user) {
        return userRepository.save(user);
    }

    void remove(int userId) {
        userRepository.remove(userId);
    }

    List<User> findAll() {
        return userRepository.findAll();
    }
}
