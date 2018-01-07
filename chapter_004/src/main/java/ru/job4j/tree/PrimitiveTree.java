package ru.job4j.tree;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * класс реализует дерево на основе интерфейса SimpleTree.
 *
 * @param <E> - тип значений элементов
 */
public class PrimitiveTree<E extends Comparable<E>> implements SimpleTree {
    /**
     * метод устанавливает ссылку на корень дерева.
     *
     * @param root - корень
     */
    public void setRoot(Node<E> root) {
        this.root = root;
    }

    /**
     * метод возвращает ссылку на корень дерева.
     *
     * @return root
     */
    public Node<E> getRoot() {
        return this.root;
    }

    /**
     * корень дерева.
     */
    private Node<E> root;

    /**
     * конструктор.
     *
     * @param value - значение корня
     */
    public PrimitiveTree(E value) {
        this.root = new Node<E>(value);
    }

    /**
     * метод добавляет элемент со значением child в список элемента со значением value.
     *
     * @param parent - родитель
     * @param child  - дочерний элемент
     * @return true, если добавление прошло успешно
     */
    @Override
    public boolean add(Comparable parent, Comparable child) {
        Optional<Node<E>> rsl = this.findBy(parent);
        Node<E> el = new Node<>((E) child);
        if (rsl.isPresent()) {
            if (rsl.get().contains(child)) {
                return false;
            } else {
                rsl.get().add(el);
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * метод находит элемент со значением value.
     *
     * @param value - значение
     * @return ссылка на элемент
     */

    @Override
    public Optional<Node<E>> findBy(Comparable value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new PrimitiveTreeIterator(this);
    }

    /**
     * метод проверяет, является ли дерево бинарным.
     *
     * @return true, если является
     */
    public boolean isBinary() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.leaves().size() > 2) {
                return false;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return true;
    }
}
