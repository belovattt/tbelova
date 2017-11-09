package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * класс-контейнер реализует очередь, расширяет контейнер на базе связанного списка
 * @param <E> тип данных
 */

public class SimpleQueue<E> extends SimpleStructure<E>  {
    /**
     * конструктор.
     */
    public SimpleQueue(){
        super();
    }

    public void push(E value) {
        super.add(value);
    }
}
