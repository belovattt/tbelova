package ru.job4j.tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * класс для тестирования методов класса BinarySearchTree.
 */
public class BinarySearchTreeTest {
    /**
     * тест проверяет метод in.
     * Если элемент с таким ключом в дереве есть, метод возвращает true,
     * иначе - false
     */
    @Test
    public void inTest() {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>(3, 5);
        Element<Integer, Integer> el = new Element<>(5, 0);
        tree.add(el);
        el = new Element<>(1, 0);
        tree.add(el);
        el = new Element<>(-1, 10);
        tree.add(el);
        el = new Element<>(20, 10);
        tree.add(el);
        assertThat(tree.in(3), is(true));
        assertThat(tree.in(1), is(true));
        assertThat(tree.in(-1), is(true));
        assertThat(tree.in(5), is(true));
        assertThat(tree.in(20), is(true));
        assertThat(tree.in(50), is(false));
    }

    /**
     * Тест проверяет метод add.
     * Если элемента с таким ключом еще нет, метод всавляет его в дерево,
     * иначе меняет его значение
     */
    @Test
    public void addTest() {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>(3, 5);
        Element<Integer, Integer> el = new Element<>(5, 0);
        tree.add(el);
        el = new Element<>(1, 0);
        tree.add(el);
        el = new Element<>(-1, 10);
        tree.add(el);
        el = new Element<>(1, 10);
        tree.add(el);
        assertThat(tree.find(-1).getValue(), is(10));
        assertThat(tree.find(1).getValue(), is(10));
    }

    /**
     * Метод проверяет метод find.
     * Если элемент с таким ключом найден, возвращается ссылка на этот элемент,
     * иначе возвращается null
     */
    @Test
    public void findTest() {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>(3, 5);
        Element<Integer, Integer> el1 = new Element<>(5, 0);
        tree.add(el1);
        Element<Integer, Integer> el2 = new Element<>(1, 0);
        tree.add(el2);
        Element<Integer, Integer> el3 = new Element<>(-1, 10);
        tree.add(el3);
        Element<Integer, Integer> el4 = new Element<>(20, 10);
        tree.add(el4);
        assertThat(tree.find(5), is(el1));
        assertThat(tree.find(1), is(el2));
        assertThat(tree.find(-1), is(el3));
        assertThat(tree.find(20), is(el4));
        assertThat(tree.find(55) == null, is(true));
    }
}
