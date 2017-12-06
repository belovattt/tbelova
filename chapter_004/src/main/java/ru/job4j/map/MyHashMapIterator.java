package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * класс реализует итератор для класса MyHashMap<K, V>.
 * @param <K> - ключ
 * @param <V> - значение
 */

public class MyHashMapIterator<K, V> implements Iterator<V> {
    /**
     * объект MyHashMap , для которого создается итератор.
     */
    private MyHashMap myHashMap;
    /**
     * указатель на элемент.
     */
    private int number = 0;

    /**
     * конструктор.
     * @param myHashMap
     */
    MyHashMapIterator(MyHashMap<K, V> myHashMap) {
        this.myHashMap = myHashMap;
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

        boolean result = false;
        for (int i = this.number; i < myHashMap.getSize(); i++) {
            if (myHashMap.getTable()[i] != null) {
                this.number = i;
                result = true;
                break;
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
    public V next() throws NoSuchElementException {
        Object result;
        if (this.hasNext()) {
            result = myHashMap.getTable()[this.number];
            this.number++;
        } else {
            throw new NoSuchElementException("");
        }
        return (V) result;
    }
}
