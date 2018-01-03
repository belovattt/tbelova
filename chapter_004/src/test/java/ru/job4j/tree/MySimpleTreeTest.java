package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * класс для тестирования методов класса MySimpleTree.
 */
public class MySimpleTreeTest {
    /**
     * если элемент существует, то метод findBy возвращает ненулевую ссылку.
     */
    @Test
    public void when6ElFindLastThen6() {
        MySimpleTree<Integer> tree = new MySimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    /**
     * Если элемент не существует, то метод findBy возвращает нулевую ссылку.
     */
    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        MySimpleTree<Integer> tree = new MySimpleTree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    /**
     * Если родительский элемент существует, метод add возвращает true.
     */
    @Test
    public void when2AddThenTrue() {
        MySimpleTree<Integer> tree = new MySimpleTree<>(1);
        assertThat(tree.add(1, 2), is(true));
        assertThat(tree.add(1, 3), is(true));
        assertThat(tree.add(2, 4), is(true));


    }

    /**
     * Если родительский элемент не существует, метод add возвращает false.
     */
    @Test
    public void when5AddThenFalse() {
        MySimpleTree<Integer> tree = new MySimpleTree<>(1);
        assertThat(tree.add(1, 2), is(true));
        assertThat(tree.add(1, 3), is(true));
        assertThat(tree.add(5, 4), is(false));
    }

    /**
     * Метод тестирует итератор.
     */
    @Test(expected = NoSuchElementException.class)
    public void iteratorTest() {
        MySimpleTree<Integer> tree = new MySimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Iterator<Integer> it = tree.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * если у каждого элемента не больше двух детей, isBinary возвращает true.
     */
    @Test
    public void whenTreeIsBinaryThenTrue() {
        MySimpleTree<Integer> tree = new MySimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 4);
        tree.add(4, 5);
        tree.add(4, 6);
        assertThat(
                tree.isBinary(),
                is(true)
        );
    }

    /**
     * если у какого-то элемента больше двух детей, isBinary возвращает false.
     */
    @Test
    public void whenTreeIsNotBinaryThenFalse() {
        MySimpleTree<Integer> tree = new MySimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(4, 6);
        assertThat(
                tree.isBinary(),
                is(false)
        );
    }
}
