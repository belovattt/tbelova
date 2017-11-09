package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * класс-контейнер реализует стек, расширяет контейнер на базе связанного списка
 * @param <E> тип данных
 */

public class SimpleStack<E> extends SimpleStructure<E> {
    /**
     * конструктор.
     */
    public SimpleStack() {
        super();
    }

    /**
     * метод добавляет данные в стек
     * @param value - данные
     */
    public void push(E value) {
        ListElement<E> el = new ListElement(value);
        if (this.getHead() == null) {
            this.setHead(el);
        } else {
            el.setNext(this.getHead());
            this.getHead().setPrev(el);
            this.setHead(el);
        }
    }
}
