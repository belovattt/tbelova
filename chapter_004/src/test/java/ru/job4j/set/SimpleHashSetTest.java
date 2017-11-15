package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для методов класса SimpleHashSet.
 */

public class SimpleHashSetTest {
    /**
     * Тест для метода add.
     * если добавляется уникальный элемент, метод возвращает true
     * если добавляемый элемент уже есть в множестве, метод возвращает false
     */
    @Test
    public void addTest() {
        SimpleHashSet<String> hashSet = new SimpleHashSet<String>();
        assertThat(hashSet.add("10"), is(true));
        assertThat(hashSet.add("20"), is(true));
        assertThat(hashSet.add("20"), is(false));

    }

    /**
     * тест для метода contains.
     * Если элемент есть в множестве, метод возвращает true, иначе false
     */
    @Test
    public void containsTest() {
        SimpleHashSet<String> hashSet = new SimpleHashSet<String>();
        hashSet.add("10");
        assertThat(hashSet.contains("10"), is(true));
        assertThat(hashSet.contains("20"), is(false));
        hashSet.add("20");
        assertThat(hashSet.contains("20"), is(true));
    }

    /**
     *Тест для метода remove.
     * Если элемент есть в множестве, метод удаляет его и возвращает true
     * Если такого элемента в множестве нет, метод возвращает false
     */
    @Test
    public void removeTest() {
        SimpleHashSet<String> hashSet = new SimpleHashSet<String>();
        hashSet.add("10");
        hashSet.add("20");
        assertThat(hashSet.remove("20"), is(true));
        assertThat(hashSet.contains("20"), is(false));
    }
}
