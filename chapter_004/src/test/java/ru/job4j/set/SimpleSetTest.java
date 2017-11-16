package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * тесты для SimpleSet
 */
public class SimpleSetTest {

    /**
     * тест для метода add.
     * добавляем 1
     * добавляем 2
     * добавляем 1 - выбрасывается исключение
     */
    @Test(expected = ValueAlreadyExistException.class)
    public void addTest() {
        SimpleSet<Integer> simpleSet = new SimpleSet(2);
        simpleSet.add(1);
        assertThat(simpleSet.getArr(), is(new Integer[]{1}));
        simpleSet.add(2);
        assertThat(simpleSet.getArr(), is(new Integer[]{1, 2}));
        simpleSet.add(1);
    }

    /**
     * тест для итератора.
     * добавляем в множество два элемента
     * третий вызов метода next() вызывает исключение
     */
    @Test(expected = NoSuchElementException.class)
    public void iteratorTest() {
        SimpleSet<Integer> simpleSet = new SimpleSet(2);
        Iterator<Integer> it = simpleSet.iterator();
        simpleSet.add(1);
        simpleSet.add(2);
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}
