package ru.job4j.tree;

/**
 * класс для создания одного листа бинарного дерева поиска.
 *
 * @param <E> ключ
 * @param <V> значение
 */
public class Element<E extends Comparable<E>, V> {
    /**
     * метод возвращает ключ элемента.
     *
     * @return key
     */
    public Comparable<E> getKey() {
        return key;
    }

    /**
     * ключ.
     */
    private Comparable<E> key;

    /**
     * метод возвращает значение элемента.
     *
     * @return value
     */

    public V getValue() {
        return value;
    }

    /**
     * метод устанавливает значение элемента.
     *
     * @param value - значение
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * значение.
     */
    private V value;

    /**
     * метод устанавливает ссылку на левое поддерево элемента.
     *
     * @param left - ссылка на левое поддерево
     */

    public void setLeft(Element left) {
        this.left = left;
    }

    /**
     * метод возвращает ссылку на левое поддерево элемента.
     *
     * @return left
     */
    public Element getLeft() {
        return left;
    }

    /**
     * ссылка на левое поддерево
     */
    private Element left;

    /**
     * метод устанавливает ссылку на правое поддерево.
     *
     * @param right - ссылка на правое поддерево
     */
    public void setRight(Element right) {
        this.right = right;
    }

    /**
     * метод возвращает ссылку на правое поддерево.
     *
     * @return right
     */
    public Element getRight() {
        return right;
    }

    /**
     * правое поддерево.
     */
    private Element right;

    /**
     * конструктор.
     *
     * @param key   - ключ
     * @param value - значение
     */
    public Element(E key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

}
