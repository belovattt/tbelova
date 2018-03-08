package ru.job4j.exchange;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * итератор для OrderList.
 */
public class OrderedListIterator implements Iterator<Order> {
    /**
     * список.
     */
    private OrderedList orderedList;
    /**
     * указатель на текущий элемент.
     */
    private Order runner;

    /**
     * конструктор.
     * @param orderedList - список
     */
    public OrderedListIterator(OrderedList orderedList){
this.orderedList = orderedList;
this.runner = this.orderedList.getHead();
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
        return this.runner != null;
    }


    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Order next() throws NoSuchElementException {
        Order result = runner;
        if (! this.hasNext()) {
            throw new NoSuchElementException();
        }
        runner = runner.getNext();
        return result;
    }
}
