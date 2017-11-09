package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * класс для тестирования меода hasCycle класса Node.
 */

public class NodeTest {
    /**
     * последний элемент списка ссылается на первый.
     */
    @Test
    public void ifLastElementRefersOnFirstThenTrue() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);
        assertThat(Node.hasCycle(first), is(true));
    }

    /**
     * третий элемент списка ссылается на второй.
     */
    @Test
    public void ifThirdElementRefersOnSecondThenTrue() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        first.setNext(two);
        two.setNext(third);
        third.setNext(two);
        four.setNext(null);
        assertThat(Node.hasCycle(first), is(true));
    }

    /**
     * первый элемент списка ссылается на себя.
     */
    @Test
    public void ifFirstElementRefersOnFirstThenTrue() {
        Node first = new Node(1);
        first.setNext(first);
        assertThat(Node.hasCycle(first), is(true));
    }

    /**
     * циклических ссылок нет.
     */
    @Test
    public void ifHasNotCycleThenFalse() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(null);
        assertThat(Node.hasCycle(first), is(false));
    }
}
