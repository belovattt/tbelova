package ru.job4j.map;

/**
 * Класс Client для демонстрации переопределения метода equals.
 */

public class Client {
    /**
     * имя.
     */
    private String name;
    /**
     * возраст.
     */
    private int age;
    /**
     * вес.
     */
    private double weight;

    /**
     * констуктор.
      * @param name - name
     * @param age - age
     * @param weight - weight
     */
    public Client(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object ob) {

        // при сравнении с null сразу возвращаем false
        if (ob == null) {
            return false;
        }

        // если переменные ссылаются на одну и ту же область памяти, не тратим время на сравнение полей и сразу возвращаем true
        if (this == ob) {
            return true;
        }

        //проверяем, имеет ли ob правильный тип
        if (!(ob instanceof Client)) {
            return false;
        }
        // если тип правильный, приводим ob к этому типу
        Client that = (Client) ob;
        // сравниваем поля
        if (age != that.age) return false;
        if (!name.equals(that.name)) return false;

        return Double.compare(weight, that.weight) == 0;
    }


}
