package ru.job4j.tree;

/**
 * класс реализует простейшее бинарное дерево поиска.
 *
 * @param <E> - ключ
 * @param <V> - значение
 */
public class BinarySearchTree<E extends Comparable<E>, V> {
    /**
     * ссылка на корень.
     */
    private final Element<E, V> root;

    /**
     * конструктор.
     *
     * @param key   - ключ
     * @param value - значение
     */

    public BinarySearchTree(E key, V value) {
        this.root = new Element<>(key, value);
    }

    /**
     * метод проверяет, есть ли элемент с таким ключом в дереве.
     *
     * @param key - ключ
     * @return true, если есть
     */
    public boolean in(E key) {
        return this.inTree(key, this.root);
    }

    /**
     * вспомогательный рекурсивный метод проверяет, есть ли элемент с заданным ключом в дереве начиная с элемента el.
     *
     * @param key
     * @param el
     * @return true, если есть
     */
    private boolean inTree(E key, Element el) {
        boolean result = false;
        if (el.getKey().compareTo(key) == 0) {
            result = true;
        } else {
            if ((el.getKey().compareTo(key) > 0) && (el.getLeft() != null)) {
                result = this.inTree(key, el.getLeft());
            } else {
                if (el.getRight() != null) {
                    result = this.inTree(key, el.getRight());
                }
            }
        }
        return result;
    }

    /**
     * метод добавляет элемент в дерево.
     * Если элемент с таким ключом уже есть, метод меняет его значение
     *
     * @param el - элемент
     */
    public void add(Element el) {
        addTree(el, this.root);
    }

    /**
     * вспомогательный рекурсивный метод ищет место для вставки el начиная с элемента start.
     *
     * @param el
     * @param start
     */
    private void addTree(Element el, Element start) {
        if (el.getKey().equals(start.getKey())) {
            start.setValue(el.getValue());
        } else {
            if (el.getKey().compareTo(start.getKey()) < 0) {
                if (start.getLeft() == null) {
                    start.setLeft(el);
                } else {
                    addTree(el, start.getLeft());
                }
            } else {
                if (start.getRight() == null) {
                    start.setRight(el);
                } else {
                    addTree(el, start.getRight());
                }
            }
        }
    }

    /**
     * метод возвращает элемент по ключу.
     *
     * @param key - ключ
     * @return элемент
     */
    public Element find(E key) {
        return this.findRec(key, this.root);
    }

    /**
     * вспомогательный рекурсивный метод ищет элемент по ключу начиная с вершины start
     *
     * @param key
     * @param start
     * @return элемент
     */
    private Element findRec(E key, Element start) {
        Element result = null;
        if (start.getKey().equals(key)) {
            result = start;
        } else {
            if ((start.getKey().compareTo(key) < 0) && (start.getRight() != null)) {
                result = findRec(key, start.getRight());
            } else {
                if ((start.getKey().compareTo(key) > 0) && (start.getLeft() != null)) {
                    result = findRec(key, start.getLeft());
                }
            }
        }
        return result;
    }
}
