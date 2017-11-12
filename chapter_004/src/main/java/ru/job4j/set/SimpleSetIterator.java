package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * итератор для объекта SimpleSet.
 *
 * @param <E> - тип данных
 */
public class SimpleSetIterator<E> implements Iterator<E> {
    /**
     * указатель на следующий элемент.
     */
    private int index;
    /**
     * указатель на объект SimpleSet.
     */
    private SimpleSet<E> simpleSet;

    /**
     * конструктор.
     *
     * @param simpleSet - объект для итератора.
     */
    SimpleSetIterator(SimpleSet<E> simpleSet) {
        this.simpleSet = simpleSet;
        this.index = 0;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return (this.simpleSet.getArr().length == index) ? false : true;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public E next() throws NoSuchElementException {
        E result = null;
        if (this.hasNext()) {
            result = this.simpleSet.getArr()[index++];
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }
}
