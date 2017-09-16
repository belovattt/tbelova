package ru.job4j.Sorting;
/**
 * Class User.
 *
 * @author Tatyana Belova
 * @since 14.09.2017
 */

public class User implements Comparable<User> {
    /**
     * имя.
     */
    private String name;
    /**
     * возраст
     */
    private int age;

    /**
     * конструктор.
     * @param name
     * @param age
     */
    User(String name, int age) {
        this.age = age;
        this.name = name;
    }

    /**
     * метод сравнивает два объекта и возвращает 0, если они равны, положительное число, если первый больше, иначе отрицат. число.
     *
     * @return число
     */
    @Override
    public int compareTo(User u) {

        return (this.age == u.age) ? this.name.compareTo(u.name) : Integer.compare(this.age, u.age);
    }
    /**
     * метод выводит в одну строку все поля объекта
     *
     * @return строка
     */
    @Override
    public String toString() {
        return this.name + this.age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
