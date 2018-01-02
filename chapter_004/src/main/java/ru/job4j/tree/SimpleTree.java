package ru.job4j.tree;

/**
 * интерфейс для создания деревьев.
 */

import java.util.Optional;

public interface SimpleTree <E extends Comparable<E>> extends Iterable<E> {
    /**
     * метод добавляет элемент со значением child в список элемента со значением value.
     * @param parent - родитель
     * @param child - дочерний элемент
     * @return true, если добавление прошло успешно
     */
    boolean add(E parent, E child);

    /**
     * метод находит элемент со значением value.
     * @param value - значение
     * @return ссылка на элемент
     */

    Optional<Node<E>> findBy(E value);
}
