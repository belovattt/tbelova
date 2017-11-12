package ru.job4j.set;

import java.util.Arrays;
import java.util.Iterator;

/**
 * класс реализует коллекцию Set на основе массива
 *
 * @param <E>
 */

public class SimpleSet<E> implements Iterable<E> {
    /**
     * массив для хранения элементов множества.
     */
    private Object[] arr;
    /**
     * номер первого свободного элемента массива.
     */
    private int position;

    /**
     * конструктор.
     *
     * @param size - начальное количество элементов множества
     */
    public SimpleSet(int size) {
        this.position = 0;
        this.arr = new Object[size];
    }

    /**
     * метод возвращает заполненную часть массива.
     *
     * @return массив
     */
    public E[] getArr() {
        return (E[]) Arrays.copyOf(this.arr, position);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new SimpleSetIterator(this);
    }

    /**
     * метод вставляет элемент value в множество.
     * если такой элемент уже есть, выбрасывается исключение
     *
     * @param value - value
     * @throws ValueAlreadyExistException
     */
    void add(E value) throws ValueAlreadyExistException {
        int index = 0;

        while (index < this.position) {
            E el = (E) this.arr[index];
            if (el.equals(value)) {
                throw new ValueAlreadyExistException("This value already exist");
            }
            index++;
        }

        if (this.position == this.arr.length) {
            this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);
        }
        this.arr[position++] = value;
    }
}
