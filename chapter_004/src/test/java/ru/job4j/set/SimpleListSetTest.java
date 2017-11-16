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
}
