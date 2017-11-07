package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DinArrayTest {
    @Test
    /**
     * тест для метода add()
     * создаем массив размерности 2 и добавляем в него три элемента
     * получаем массив с тремя заполненными элементами
     */
    public void addThreeElementsTest() {
        DinArray<Integer> arr = new DinArray<Integer>(2);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        assertThat(arr.getArr(), is(new Integer[]{1, 2, 3}));
    }
    @Test (expected = NoSuchElementException.class)
    /**
     * тест для метода get().
     * создаем массив из двух элементов
     * метод возвращает по номеру два элемента
     * при попытке вернуть третий элемент выбрасывается исключение
     */
    public void getTwoElements() {
        DinArray<Integer> arr = new DinArray<Integer>(2);
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
     * метод hasNext() возвращет true
     * метод next() возвращет 3
     * метод next() вызывает исключение
     *
     */
    public void iteratorTest(){
        DinArray<Integer> arr = new DinArray<Integer>(2);
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
