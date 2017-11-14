package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * тесты для SimpleListSet
 */

public class SimpleListSetTest {
    /**
     * тест для метода add.
     * добавляем 1
     * добавляем 2
     * добавляем 1 - выбрасывается исключение
     */
    @Test(expected = ValueAlreadyExistException.class)
    public void addTest() {
        SimpleListSet<Integer> simpleListSet = new SimpleListSet();
        simpleListSet.add(1);
        assertThat(simpleListSet.getHead().getData(), is(1));
        simpleListSet.add(2);
        assertThat(simpleListSet.getHead().getNext().getData(), is(2));
        simpleListSet.add(1);
    }

    /**
     * тест для итератора.
     * добавляем в множество два элемента
     * третий вызов метода next() вызывает исключение
     */
    @Test (expected = NoSuchElementException.class)
    public void iteratorTest() {
        SimpleListSet<Integer> simpleListSet = new SimpleListSet();

        simpleListSet.add(1);
       simpleListSet.add(2);
        Iterator<Integer> it = simpleListSet.iterator();
       assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}
