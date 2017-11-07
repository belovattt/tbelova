package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * класс-контейнер для динамического массива с элементами типа E
 * @param <E> - тип элементов
 */

public class DinArray<E> implements Iterable<E> {
    /**
     * массив элементов типа Object[]
     */
    private Object[] arr;
    /**
     * номер первого свободного элемента
     */
    private int position;

    /**
     * Конструктор.
     * создает массив объектов
     * @param size - начальное количпество элементов в массиве
     */
    public DinArray(int size) {
        this.arr = new Object[size];
        this.position = 0;
    }

    /**
     * метод возвращает заполненную часть массива, приводя Object[] к E[].
     * @return заполненная часть массива, элементы типа E
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
        return new DinArrayIterator<E>(this);
    }

    /**
     * Метод добавляет элемент в массив.
     * Если массив заполнен до конца, его размерность перед добавлением удваивается
     * @param element - добавляемый элемент
     * @return
     */
    public E add(E element) {
        if (this.position == this.arr.length) {
            this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);
        }
        this.arr[position++] = element;
        return element;
    }

    /**
     * метод возвращает элемент по индексу
     * @param index - индекс элемента
     * @return элемент
     * @throws NoSuchElementException - если элемента с таким номером не существует
     */
    public E get(int index) throws NoSuchElementException {
        E result = null;
        if ((index > position - 1) || (index < 0)) {
            throw new NoSuchElementException();
        } else {
            result = (E) this.arr[index];
        }
        return result;
    }

}
