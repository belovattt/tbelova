package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DinListTest {
    @Test
    /**
     * тест для метода add()
     * создаем список размерности и добавляем в него три элемента
     * получаем список с тремя заполненными элементами
     */
    public void addThreeElementsTest() {
        DinList<Integer> arr = new DinList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        assertThat(arr.get(0), is(1));
        assertThat(arr.get(1), is(2));
        assertThat(arr.get(2), is(3));

    }

    @Test(expected = NoSuchElementException.class)
    /**
     * тест для метода get().
     * создаем список из двух элементов
     * метод возвращает по номеру два элемента
     * при попытке вернуть третий элемент выбрасывается исключение
     */
    public void getTwoElements() {
        DinList<Integer> arr = new DinList<Integer>();
        arr.add(1);
        arr.add(2);
        assertThat(arr.get(0), is(1));
        assertThat(arr.get(1), is(2));
        arr.get(3);
    }

    @Test (expected = NoSuchElementException.class)
    /**
     * тест для итератора.
     * создаем массив из двух элементов
     * метод hasNext() в начальной позиции возвращает true
     * дважды вызываем метод next()
     * метод hasNext() возвращает false
     * добавляем третий элемент
     * метод hasNext() возвращает true
     * метод next() возвращает 3
     * метод next() вызывает исключение
     *
     */
    public void iteratorTest() {
        DinList<Integer> arr = new DinList<Integer>();
        arr.add(1);
        arr.add(2);
        Iterator<Integer> it = arr.iterator();
        assertThat(it.hasNext(), is(true));
       assertThat(it.next(), is(1));
       assertThat(it.next(), is(2));
       assertThat(it.hasNext(), is(false));
       arr.add(3);
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        it.next();

    }
}
