package ru.job4j.set;

import java.util.Arrays;

/**
 * Класс реализует коллекцию типа Set на базе хэш-таблицы
 *
 * @param <E> - тип данных в коллекции
 */
public class SimpleHashSet<E> {

    /**
     * массив для хранения элементов коллекции
     */
    private Object[] arr;

    /**
     * конструктор.
     * массив arr заполнеятся null
     */
    public SimpleHashSet(int n) {
        this.arr = new Object[n];
    }

    /**
     * метод определяет, принадлежит ли элемент множеству
     *
     * @param e - элемент
     * @return true, если принадлежит
     */

    public boolean contains(E e) {
        return (this.arr[hC(e)] == null) ? false : true;

    }

    /**
     * метод добавляет элемент el в множество.
     *
     * @param e - элемент
     * @return false - если такой элемент в множестве уже есть
     */
    public boolean add(E e) {
        boolean result = true;
        if (this.contains(e)) {
            result = false;
        } else {

            this.arr[hC(e)] = e;
        }
        return result;
    }

    /**
     * метод удаляет элемент el из множества.
     *
     * @param e - el
     * @return false, если такого элемента в множестве не было
     */
    public boolean remove(E e) {
        boolean result = false;
        if (this.contains(e)) {
            this.arr[this.hC((e))] = null;
            result = true;
        }
        return result;
    }

    /**
     * метод вычисляет код элемента для хэш-таблицы.
     *
     * @param e - элемент
     * @return код
     */
    private int hC(Object e) {
        return Math.abs(e.hashCode() % this.arr.length);
    }

}
