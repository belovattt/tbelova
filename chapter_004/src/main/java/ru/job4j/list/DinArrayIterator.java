package ru.job4j.list;



import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * класс реализует итератор для класса DinArray
 * @param <E>
 */

public class DinArrayIterator<E> implements Iterator {
    /**
     * ссылка на объект класса, для которого создается итератор
     */
    private final DinArray<E> dinArray;
    /**
     * текущая позиция
     */

    private int position;

    /**
     * Конструктор.
     * текущая позиция 0
     * @param dinArray - объект класса
     */
    DinArrayIterator(DinArray<E> dinArray) {
        this.dinArray = dinArray;
        this.position = 0;
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
        return (position != dinArray.getArr().length);
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public E next() throws NoSuchElementException {
        E result;
        if (this.hasNext()) {
            result = this.dinArray.get(position++);
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }

}
