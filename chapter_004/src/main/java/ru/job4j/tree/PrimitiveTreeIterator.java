package ru.job4j.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * метод реализует итератор для объектов класса PrimitiveTree.
 * @param <E>- тип элементов
 */
public class PrimitiveTreeIterator<E extends Comparable<E>> implements Iterator<E> {
    /**
     * дерево.
     */
    PrimitiveTree<E> mySimpleTree;
    /**
     * очередь для хранения непросмотренных элементов.
     */
    Queue<Node<E>> queue = new LinkedList<>();

    /**
     * конструктор.
     * @param simpleTree - дерево
     */

    public PrimitiveTreeIterator(PrimitiveTree<E> simpleTree) {

        this.mySimpleTree = simpleTree;
        this.queue.offer(mySimpleTree.getRoot());
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
        return ! this.queue.isEmpty();
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
            Node<E> el = queue.poll();
            for (Node<E> child : el.leaves()) {
                queue.offer(child);
            }
            result = el.getValue();
        } else {
            throw new NoSuchElementException("No next element");
        }
        return result;

    }
}
