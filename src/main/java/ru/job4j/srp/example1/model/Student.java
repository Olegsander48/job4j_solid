package ru.job4j.srp.example1.model;

import jakarta.persistence.*;
import org.hibernate.Session;

/**
 * Пример нарушения SRP - сущность содержит методы для работы с БД
 */
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private int age;

    @PersistenceContext
    private Session session;

    public Student() {
    }

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void save() {
        session.persist(this);
    }

    public Student findById(int id) {
        return session.get(Student.class, id);
    }
}
