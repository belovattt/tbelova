package ru.job4j.set;

import ru.job4j.list.ListElement;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class SimpleListSetIterator<E> implements Iterator<E> {
    /**
     * объект для добавления итератора
     */
    private SimpleListSet<E> simpleListSet;
    /**
     * указатель на следующий элемент
     * помнит предыдущий элемент
     *
     */
    private ListElement<E> position = new ListElement<E>(null);
    /**
     * конструктор.
     *
     * @param simpleListSet - объект для итератора
     */

    public SimpleListSetIterator(SimpleListSet<E> simpleListSet) {
        this.simpleListSet = simpleListSet;
        this.position.setNext(this.simpleListSet.getHead());
        this.position.setPrev(null);
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
        boolean result = true;
        // если перед этим next() возвратил последний элемент
        if (this.position.getNext() == null) {

            if (this.position.getPrev() == this.simpleListSet.getTail())  {
                // если не было добавления новых элементов
                result = false;
            } else {
                // если были добавлены элементы
                this.position.setNext(this.position.getPrev().getNext());
            }
        }

        return result;
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
            result = position.getNext().getData();
            position.setPrev(position.getNext());
            position.setNext(position.getNext().getNext());

        } else {
            throw new NoSuchElementException();
        }
        return result;
    }
}
