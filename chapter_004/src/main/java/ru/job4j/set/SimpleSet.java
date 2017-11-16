package ru.job4j.set;

import ru.job4j.list.DinArray;

import java.util.Arrays;
import java.util.Iterator;

/**
 * класс реализует коллекцию Set на основе массива
 *
 * @param <E>
 */

public class SimpleSet<E> extends DinArray<E> {

    /**
     * конструктор.
     *
     * @param size - начальное количество элементов множества
     */
    public SimpleSet(int size) {
        super(size);
    }



    /**
     * метод вставляет элемент value в множество.
     *  если такой элемент уже есть, выбрасывается исключение
     *
     * @param value - value
     * @throws ValueAlreadyExistException
     */
    public E add(E value) throws ValueAlreadyExistException {
        Iterator<E> it = this.iterator();
        for (E el : this) {
            if (el.equals(value)) {
                throw new ValueAlreadyExistException("This value already exist");
            }
        }
        super.add(value);
        return value;
    }
}
