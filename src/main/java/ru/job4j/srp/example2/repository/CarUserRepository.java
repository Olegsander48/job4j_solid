package ru.job4j.srp.example2.repository;

import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.job4j.srp.example2.model.Car;
import ru.job4j.srp.example2.model.User;

/**
 * Пример нарушения SRP - репозиторий сохраняет несколько сущностей
 */
@Repository
public class CarUserRepository {
    @PersistenceContext
    private Session session;

    User save(User user) {
        session.persist(user);
        return user;
    }

    Car save(Car car) {
        session.persist(car);
        return car;
    }

    void update(User user) {
        session.merge(user);
    }

    void update(Car car) {
        session.merge(car);
    }
}
