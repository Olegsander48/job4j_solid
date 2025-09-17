package ru.job4j.isp.example1;

import java.util.List;
import java.util.Optional;

/**
 * Нарушение ISP
 * Методы findAllOrderedByIdDesc и findFirst3Elements могут не пригодится во всех репозиториях,
 * лучше вынести в отдельный интерфейс
 *
 * @param <T> тип данных, который хотим хранить
 */
public interface Repository<T> {
    T save(T t);

    void delete(T t);

    Optional<T> findById(int id);

    List<T> findAll();

    List<T> findAllOrderedByIdDesc();

    List<T> findFirst3Elements();
}
