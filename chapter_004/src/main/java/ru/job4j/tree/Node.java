package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует один элемент дерева.
 * @param <E> - тип данных
 */
public class Node<E> {
    /**
     * список элементов.
     */
    private List<Node<E>> children;

    /**
     * метод возвращает данные элемента.
     * @return value
     */
    public E getValue() {
        return value;
    }

    /**
     * Данные элемента.
     */
    private final E value;

    /**
     * конструктор.
     * @param value - данные
     */
    public Node(final E value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    /**
     * метод добавляет элемент к списку элементов.
     * @param child - добавляемый элемент
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * метод возвращает список элементов.
     * @return список
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * метод сравнивает значение value элемента с that.
     * @param that
     * @return true, если равны
     */
    public boolean eqValue(Comparable<E> that) {
        return this.value.equals(that);
    }
}
