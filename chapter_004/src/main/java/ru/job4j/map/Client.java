package ru.job4j.map;

import java.util.HashMap;

/**
 * Класс Client для демонстрации переопределения методов equals и hashcode.
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

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link HashMap}.
     * <p>
     * The general contract of {@code hashCode} is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     * an execution of a Java application, the {@code hashCode} method
     * must consistently return the same integer, provided no information
     * used in {@code equals} comparisons on the object is modified.
     * This integer need not remain consistent from one execution of an
     * application to another execution of the same application.
     * <li>If two objects are equal according to the {@code equals(Object)}
     * method, then calling the {@code hashCode} method on each of
     * the two objects must produce the same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     * according to the {@link Object#equals(Object)}
     * method, then calling the {@code hashCode} method on each of the
     * two objects must produce distinct integer results.  However, the
     * programmer should be aware that producing distinct integer results
     * for unequal objects may improve the performance of hash tables.
     * </ul>
     * <p>
     * As much as is reasonably practical, the hashCode method defined by
     * class {@code Object} does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java&trade; programming language.)
     *
     * @return a hash code value for this object.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.age;
        long d = Double.doubleToLongBits(this.weight);
        result = 31 * result + (int) (d ^ d >>> 32);
        return result;
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
