package ru.job4j.map;

import java.util.Calendar;

/**
 * класс реализует контейнер для хранения данных об одном пользователе.
 */
public class User {
    /**
     * имя.
     */
    private String name;
    /**
     * дети.
     */
    int children;
    /**
     * дата рождения.
     */
    Calendar birthday;

    /**
     * конструктор.
     *
     * @param name
     * @param children
     * @param birthday
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
